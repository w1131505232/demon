package com.woniuxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.entity.User;
import com.woniuxy.entity.User2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper   //指定当前类是需要mybatis处理的mapper类
//public interface UserMapper {
public interface UserMapper2 extends BaseMapper<User2> {


}
