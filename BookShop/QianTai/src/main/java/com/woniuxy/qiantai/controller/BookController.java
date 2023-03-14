package com.woniuxy.qiantai.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.dal.entity.Book;
import com.woniuxy.servicelayer.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/topN")
    public List<Book> topN(Integer n){
        return bookService.topN(n);
    }


    @RequestMapping("detail")
    public Book detail(Integer bookId){
//       return bookService.getById(bookId);
        return bookService.seeDetail(bookId);
    }

    @RequestMapping("pageByType")
    public Page<Book> pageByType(Integer currentPage, Integer pageSize, Integer typeId){

        Page<Book> bookPage = bookService.pageByType(currentPage, pageSize, typeId);

        return bookPage;
    }



}

