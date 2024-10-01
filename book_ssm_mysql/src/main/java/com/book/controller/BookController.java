package com.book.controller;

import com.book.pojo.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*
    通配符方式：
     ● ?  ：匹配任何单字符，单只能匹配一个
    http://localhost:8080/mvc/user/login
    @GetMapping(path="/?ogin")  在客户端请求的时候路径中的 ? 可以表示任何一个字符

     ● *  ：匹配零个或任意数量的字符
    http://localhost:8080/mvc/user/ogin
    @GetMapping(path="/*ogin")  在客户端请求的时候路径中的 * 可以表示零个或任意多个字符

     ● ** ：匹配零个或更多的路径
    http://localhost:8080/mvc/user/a/b/c/d/d/e/login
    @GetMapping(path="/**")  在客户端请求的时候路径中的 ** 可以表示任意多个路径
*/
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

/*
    RestFul 编程风格：是一种基于 HTTP 协议的 Web 服务接口设计风格。
    ● GET：用于获取资源。
    ● POST：用于创建新的资源。
    ● PUT：用于更新现有的资源。PUT 通常要求完整地替换资源，而不是仅更新部分属性。
    ● DELETE：用于删除资源。
    ● PATCH：用于局部更新资源，与 PUT 不同，PATCH 只更新提供的属性。

    使用put、delete、get、post配合响应状态码完成对应的操作
    ● 200    get（查询） 的时候，操作成功
    ● 201    post（添加） 的时候，添加成功
    ● 204    put（修改），delete（删除） ，操作成功
    ● 404    get（查询） ， 没有查询到数据
    ● 500    get，post,delete,put, 操作失败
*/
    @GetMapping
    public List<Book> queryAll() {
        return bookService.queryAll();
    }

    @PostMapping
    public String addBook(Book book) {
        Integer i = bookService.addBook(book);
        if (i == 1) {
            return "添加成功！";
        }
        return "添加失败！";
    }

    @PutMapping
    public String updateBook(Book book) {
        Integer i = bookService.updateBook(book);
        if (i == 1) {
            return "修改成功！";
        }
        return "修改失败！";
    }

    @DeleteMapping
    public String deleteBook(Integer id) {
        Integer i = bookService.deleteBook(id);
        if (i == 1) {
            return "删除成功！";
        }
        return "删除失败！";
    }
}
