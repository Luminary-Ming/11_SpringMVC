package com.book.pojo;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    // 书名
    private String bookName;
    // 作者
    private String author;
    // 出版社
    private String press;
    // 出版时间
    private String time;
}
