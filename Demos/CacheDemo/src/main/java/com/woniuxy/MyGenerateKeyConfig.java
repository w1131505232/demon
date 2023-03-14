package com.woniuxy;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class MyGenerateKeyConfig {

    @Bean  //放入IOC里的对象的名字默认就是方法名
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator() {

            //                    执行方法时的对象   执行方法时的方法名   执行方法时的形参
            @Override
            public Object generate(Object target, Method method, Object... params) {
                //返回的值组合要保证唯一性
                return  target.getClass() + "WONIUHZ02" + method.getName();
            }
        };
    }


}
