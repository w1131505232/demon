package com.woniuxy.servicelayer.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.dal.entity.Book;
import com.woniuxy.dal.mapper.BookMapper;
import com.woniuxy.servicelayer.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> topN(Integer n) {

        //分页查询条件
        Page<Book> page = new Page<>(1,n);

        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.orderByDesc("buycount");

        Page<Book> bookPageResult = bookMapper.selectPage(page, bookQueryWrapper);
        List<Book> bookList = bookPageResult.getRecords();

        return bookList;
    }

    @Override
    public Book seeDetail(Integer bookId) {
        Book book = bookMapper.selectById(bookId);

        //阅读量+1
        Book bookUpdate = new Book();
        bookUpdate.setId(book.getId());
        bookUpdate.setReadcount( book.getReadcount()+1 );

        bookMapper.updateById(bookUpdate);

        return book;
    }

    @Override
    public Page<Book> pageByType(Integer currentPage, Integer pageSize, Integer typeId) {

        //分页查询条件
        Page<Book> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.eq("typeId",typeId);
        bookQueryWrapper.orderByDesc("buycount");

        Page<Book> bookPageResult = bookMapper.selectPage(page, bookQueryWrapper);

        return bookPageResult;
    }


}
