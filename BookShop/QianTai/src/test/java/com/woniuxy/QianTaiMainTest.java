package com.woniuxy;

import com.woniuxy.servicelayer.RoleService;
import com.woniuxy.servicelayer.util.JwtUtil;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
public class QianTaiMainTest {

    @Autowired
    RoleService roleService;


    @Test
    void Test(){
        System.out.println( roleService.list() );
    }


    private String secrect ="aksASDFASD!@#$!@##$!ajsdkj91834asjdf!@#$!@#kasdf";

    @Test
    void testJWTEncode(){

        JwtBuilder jwtBuilder = Jwts.builder();

        //头部
        jwtBuilder.setHeaderParam("alg","HS256");
        jwtBuilder.setHeaderParam("typ","JWT");


        //载荷
        jwtBuilder.setIssuer("woniuBookshop2");
        jwtBuilder.setSubject("蜗牛书店");
        //过期时间
        Date expireDate = new Date(  new Date().getTime() + 60*1000 );
        jwtBuilder.setExpiration(expireDate);
        //增加自定义信息
        jwtBuilder.claim("username","wukong");
        jwtBuilder.claim("age","666");


        //签名
        jwtBuilder.signWith(SignatureAlgorithm.HS256,secrect);


        String token = jwtBuilder.compact();

        System.out.println(token);
    }

    @Test
    void testParser(){

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ3b25pdUJvb2tzaG9wMiIsInN1YiI6Iuicl-eJm-S5puW6lyIsImV4cCI6MTY3ODY5MTQzOCwidXNlcm5hbWUiOiJ3dWtvbmciLCJhZ2UiOiI2NjYifQ.x3aEU5Qqf4txA3rcttXOt09EMloRhKzwZZ2-5Lo7DUk";

        JwtParser parser = Jwts.parser();
        // ExpiredJwtException
        Jws<Claims> claimsJws = parser.setSigningKey(secrect).parseClaimsJws(token);
        System.out.println(claimsJws);
        System.out.println(claimsJws.getHeader());
        System.out.println(claimsJws.getBody());
        System.out.println(claimsJws.getSignature());

        Claims body = claimsJws.getBody();
        System.out.println( body.getIssuer() );
        System.out.println( body.getSubject() );
        System.out.println( body.getExpiration() );
        System.out.println( body.get("username") );
        System.out.println( body.get("age") );

    }

    @Test
    void testJwtUtil(){

        HashMap<String, Object> infoMap = new HashMap<>();
        infoMap.put("name","woniu");
        infoMap.put("address","panshi");

        String token = JwtUtil.createToken(15, infoMap);
        System.out.println(token);

        System.out.println( JwtUtil.parseValue(token,"name") );
        System.out.println( JwtUtil.parseValue(token,"address") );
        System.out.println( JwtUtil.parseValue(token,"xxxxx") );

    }



}
