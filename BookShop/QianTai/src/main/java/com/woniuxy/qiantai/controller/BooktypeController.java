package com.woniuxy.qiantai.controller;


import com.woniuxy.dal.entity.Booktype;
import com.woniuxy.servicelayer.BooktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@RestController
@RequestMapping("/booktype")
public class BooktypeController {

    @Autowired
    BooktypeService booktypeService;

    @Autowired
    RedisTemplate<String,Object> stringObjectRedisTemplate;

    @RequestMapping("/all")
    public List<Booktype> all(){

        //增加缓存机制
        ValueOperations<String, Object> opsForValue = stringObjectRedisTemplate.opsForValue();
        List<Booktype> booktypeList = (List<Booktype>)opsForValue.get("booktypeList");
        if (booktypeList == null){
            booktypeList = booktypeService.list();
            opsForValue.set("booktypeList",booktypeList);
        }

        return booktypeList;
    }

    @RequestMapping("detail")
    public Booktype detail(Integer bookTypeId){
        return booktypeService.getById(bookTypeId);
    }

}

