package com.book.service.impl;

import com.book.mapper.BookMapper;
import com.book.pojo.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询所有图书
     */
    @Override
    public List<Book> queryAll() {
        return bookMapper.queryAll();
    }

    /**
     * 添加图书
     */
    @Override
    public Integer addBook(Book book) {
        return bookMapper.addBook(book);
    }

    /**
     * 修改图书
     */
    @Override
    public Integer updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    /**
     * 删除图书
     */
    @Override
    public Integer deleteBook(Integer id) {
        return bookMapper.deleteBook(id);
    }
}
