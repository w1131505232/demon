package com.woniuxy.qiantai.interceptors;

import com.woniuxy.servicelayer.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断token是否需要续期
        List<Cookie> cookieList = Arrays.stream(request.getCookies()).filter(cookie -> {
            return cookie.getName().equals("user_token");
        }).collect(Collectors.toList());
        if (cookieList.size()==1){
            String tokenFromCookie = cookieList.get(0).getValue();

            try {
                JwtUtil.parseValue(tokenFromCookie, "account");
            }catch (ExpiredJwtException expiredJwtException){

                System.out.println("userToken已过期,需要判断是否需要展期");

                //判断关联数据是否也过期了
                ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
                String accountFromRedis = opsForValue.get(tokenFromCookie);
                if (!StringUtils.isEmpty(accountFromRedis)){
                    System.out.println("关联数据未过期,符合展期条件,进行展期");

                    //展期操作:  生成新的token    关联数据也更新   当前request中的过期token也要更新掉
                    //1.生成新的token
                    String refreshToken = JwtUtil.createTokenSingleInfo(20, "account", accountFromRedis);
                    Cookie cookie = new Cookie("user_token",refreshToken);
                    cookie.setPath("/");
                    response.addCookie(cookie);

                    //2.关联数据也更新
                    stringRedisTemplate.delete(tokenFromCookie);
                    opsForValue.set(refreshToken,accountFromRedis,40, TimeUnit.MINUTES);

                    //3.当前request中的过期token也要被更新掉
                    cookieList.get(0).setValue(refreshToken);

                }else {
                    System.out.println("关联数据已过期过期,不进行展期");
                }

            }

        }

        return true;
    }
}
