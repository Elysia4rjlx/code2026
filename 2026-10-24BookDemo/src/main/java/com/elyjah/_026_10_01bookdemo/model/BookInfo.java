package com.elyjah._026_10_01bookdemo.model;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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

    //statusCN 是数据库里没有的字段——它是给前端看的中文名，
    // 由 Service 层根据 status 翻译。这个字段体现了 Model 里的"非持久化字段"设计。
    private String statusCN;

    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

}