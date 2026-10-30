package com.elyjah._0261029springaopdemo.Controller;


import com.elyjah._0261029springaopdemo.Aspect.Exercise4MyAspect;
import com.elyjah._0261029springaopdemo.moder.BookInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/getList")
    public List<BookInfo> getList() {
        List<BookInfo> list = new ArrayList<>();
        list.add(new BookInfo(1, "三体", "刘慈欣"));
        list.add(new BookInfo(2, "活着", "余华"));
        return list;
    }

    @Exercise4MyAspect
    @GetMapping("/getById")
    public BookInfo getById(Integer id) {
        return new BookInfo(id, "三体", "刘慈欣");
    }

    @PostMapping("/add")
    public String add(BookInfo bookInfo) {
        return "add ok";
    }

    @GetMapping("/error")
    public String error() {
        int a = 10 / 0;
        return "never";
    }
}