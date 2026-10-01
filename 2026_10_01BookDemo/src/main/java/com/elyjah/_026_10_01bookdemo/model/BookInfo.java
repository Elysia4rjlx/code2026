package com.elyjah._026_10_01bookdemo.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {

    //图书ID
    private Integer id;
    //书名
    private String bookName;
    //作者
    private String author;
    //数量
    private Integer count;
    //定价
    private BigDecimal price;
    //出版社
    private String publish;
    //状态 0-无效 1-允许借阅   2-不允许借阅
    private Integer status;
    private String statusCN;

}