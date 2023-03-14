package com.woniuxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper   //指定当前类是需要mybatis处理的mapper类
//public interface UserMapper {
public interface UserMapper extends BaseMapper<User> {

    public User getUserByName(String name);

//    @Select()
//    @Delete()
//    @Update()
//    @Insert()
    @Select("select * from user where email like '%${keyword}%'")
    List<User> likeEmail(String keyword);


}
