package com.book.web;

import com.book.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/findAll")
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId(1);
        book.setName("兄弟");
        book.setAuthor("余华");
        book.setPress("人民出版社");
        book.setTime("2024-09-23");
        books.add(book);
        return books;
    }

    @GetMapping("/findById")
    public Book findBookById(Integer id) {
        Book book = new Book();
        book.setId(2);
        book.setName("红楼梦");
        book.setAuthor("曹雪芹");
        book.setPress("人民出版社");
        book.setTime("2024-09-23");
        if (id == book.getId()) {
            return book;
        }
        return null;
    }

    @GetMapping("/search")
    public Book search(@RequestParam(name = "name", required = true) String name,
                       @RequestParam(name = "author", required = true) String author) {
        Book book = new Book();
        book.setId(3);
        book.setName("西游记");
        book.setAuthor("吴承恩");
        book.setPress("人民出版社");
        book.setTime("2024-09-23");
        if ("西游记".equals(name) && "吴承恩".equals(author)) {
            return book;
        }
        return null;
    }

    @GetMapping("/demo")
    public void demo(Integer id) {
        System.out.println(id);
    }

}
