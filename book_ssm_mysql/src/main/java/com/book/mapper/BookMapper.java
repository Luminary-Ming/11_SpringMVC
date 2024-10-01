package com.book.mapper;

import com.book.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    /**
     * 查询所有图书
     */
    @Select("select * from book")
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
    @Delete("delete from book where id = #{id}")
    public Integer deleteBook(Integer id);
}
