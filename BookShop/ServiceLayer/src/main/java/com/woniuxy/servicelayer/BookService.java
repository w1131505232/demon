package com.woniuxy.servicelayer;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.dal.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
public interface BookService extends IService<Book> {

    List<Book> topN(Integer n);

    Book seeDetail(Integer bookId);

    Page<Book> pageByType(Integer currentPage, Integer pageSize, Integer typeId);
}
