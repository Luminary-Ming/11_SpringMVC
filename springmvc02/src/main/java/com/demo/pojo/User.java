package com.demo.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    // 爱好
    private String[] like;
}
