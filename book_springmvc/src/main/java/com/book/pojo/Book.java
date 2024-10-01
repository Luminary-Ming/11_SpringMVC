package com.book.pojo;

import lombok.Data;

@Data
public class Book {
    private int id;
    // 书名
    private String name;
    // 作者
    private String author;
    // 出版社
    private String press;
    // 出版时间
    private String time;
}
