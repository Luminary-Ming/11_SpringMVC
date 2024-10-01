package com.book.service;

import com.book.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 查询所有图书
     */
    public List<Book> queryAll();

    /**
     * 添加图书
     */
    public Integer addBook(Book book);

    /**
     * 修改图书
     */
    public Integer updateBook(Book book);

    /**
     * 删除图书
     */
    public Integer deleteBook(Integer id);
}
