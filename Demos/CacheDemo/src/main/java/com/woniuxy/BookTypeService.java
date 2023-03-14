package com.woniuxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService {

    @Autowired
    BooktypeMapper booktypeMapper;

    //执行该方法需要使用缓存   value别名cacheName,值得是组名
//    @Cacheable(value = "bookTypesDemo",key = "#root.targetClass+#root.methodName")
//    @Cacheable(cacheNames = "bookTypesDemo",key = "#root.targetClass+#root.methodName")
    @Cacheable(value = "bookTypesDemo",keyGenerator = "myKeyGenerator")
    public List<Booktype> getAll(){
        List<Booktype> booktypes = booktypeMapper.selectList(null);
        return booktypes;
    }

    public Booktype getById(Integer typeId){
        Booktype booktype = booktypeMapper.selectById(typeId);
        return booktype;
    }

    //移除缓存数据
    @CacheEvict(value = "bookTypesDemo",allEntries = true)
    public void add(Booktype booktype){
        int insert = booktypeMapper.insert(booktype);
    }

    @CacheEvict(value = "bookTypesDemo",allEntries = true)
    public void deleteById(Integer typeId){
        int i = booktypeMapper.deleteById(typeId);
    }

    @CacheEvict(value = "bookTypesDemo",allEntries = true)
    public void updateById(Booktype booktype){
        int i = booktypeMapper.updateById(booktype);
    }


}
