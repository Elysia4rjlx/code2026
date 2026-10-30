package com.elyjah._0261029springaopdemo.moder;

import lombok.Data;

@Data
public class BookInfo {
    private Integer id;
    private String name;
    private String author;

    public BookInfo() {
    }

    public BookInfo(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}