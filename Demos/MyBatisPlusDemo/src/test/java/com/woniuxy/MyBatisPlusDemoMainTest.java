package com.woniuxy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.entity.User;
import com.woniuxy.entity.User2;
import com.woniuxy.mapper.UserMapper;
import com.woniuxy.mapper.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusDemoMainTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapper2 userMapper2;

    @Test
    void testMapper(){

        User tom = userMapper.getUserByName("Tom");
        System.out.println(tom);

        List<User> userList = userMapper.likeEmail("bao");
        System.out.println(userList);
    }

    @Test
    void testPlusMapper(){
        User user = userMapper.selectById(3);
        System.out.println(user);

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("email","bao");

        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);

    }



    @Test
    void testPlusMapperZhuJie(){
        User2 user2 = userMapper2.selectById(3);
        System.out.println(user2);

        QueryWrapper<User2> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("email","bao");

        List<User2> users = userMapper2.selectList(userQueryWrapper);
        System.out.println(users);

    }




}
