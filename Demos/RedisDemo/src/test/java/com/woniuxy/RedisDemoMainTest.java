package com.woniuxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisDemoMainTest {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedisTemplate(){

        //1.先获取到ops操作对象
        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();//操作value是字符串的

        //2.使用ops操作数据
        opsForValue.set("k1","v1");
        opsForValue.set("k11","v11",5, TimeUnit.SECONDS);
        opsForValue.setIfAbsent("k1","v1111111111111111");
        opsForValue.setIfAbsent("k3","v3333333333333333");

        System.out.println( opsForValue.get("k1") );
        System.out.println( opsForValue.get("k11") );

    }



    @Test
    void testStringRedisTemplate(){

        //1.先获取到ops操作对象
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();//操作value是字符串的

        //2.使用ops操作数据
        opsForValue.set("k1","v1");
        opsForValue.set("k11","v11",5, TimeUnit.SECONDS);
        opsForValue.setIfAbsent("k1","v1111111111111111");
        opsForValue.setIfAbsent("k3","v3333333333333333");

        System.out.println( opsForValue.get("k1") );
        System.out.println( opsForValue.get("k11") );

        Boolean deleteResult = stringRedisTemplate.delete("k1");
        System.out.println(deleteResult);

    }

    @Test
    void testRedisTemplateObject(){

        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();//操作value是字符串的

//        //将对象转换为可以存储一堆二进制数据的过程称之为序列化
        opsForValue.set("currentDate",new Date());

        //将一堆二进制数据读取出来,还原成Java对象  这个过程称之为 反序列化
        Object objectFromRedis = opsForValue.get("currentDate");

        Date dateFromRedis = (Date) objectFromRedis;
        System.out.println(dateFromRedis.getTime() );


    }


    @Test
    void testRedisTemplateObjectCustomObject(){

        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();//操作value是字符串的

        //JDK的默认序列化需要对象必须实现了 java.io.Serializable 接口
        opsForValue.set("user",new User("xiaoming",66));

        User user = (User)opsForValue.get("user");
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

    @Autowired
    RedisTemplate<String,Object> stringObjectRedisTemplate;

    @Test
    void teststringObjectRedisTemplate(){

        ValueOperations<String, Object> opsForValue = stringObjectRedisTemplate.opsForValue();

        opsForValue.set("User2",new User2("小红",18));

        User2 user2 = (User2) opsForValue.get("User2");
        System.out.println(user2);


        HashOperations<String, Object, Object> opsForHash = stringObjectRedisTemplate.opsForHash();
        opsForHash.put("悟空","花果山","猴大王");
        opsForHash.put("悟空","天庭","弼马温");
        opsForHash.put("悟空","五指山","泼猴");

        System.out.println( opsForHash.get("悟空","天庭") );
        System.out.println( opsForHash.get("悟空","五指山") );

       // stringObjectRedisTemplate.delete("悟空");
        opsForHash.delete("悟空","花果山");

    }





}
