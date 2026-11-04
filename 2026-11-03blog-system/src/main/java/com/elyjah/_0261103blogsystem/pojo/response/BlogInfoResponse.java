package com.elyjah._0261103blogsystem.pojo.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class BlogInfoResponse {
    private Integer id;

    private String title;


    private String content;


    private Integer userId;


    private Integer deleteFlag;


//    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}