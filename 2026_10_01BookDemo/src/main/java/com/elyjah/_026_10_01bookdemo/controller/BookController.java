package com.elyjah._026_10_01bookdemo.controller;

import com.elyjah._026_10_01bookdemo.model.BookInfo;
import com.elyjah._026_10_01bookdemo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping("/getList")
    public List<BookInfo> getList(){
        BookService bookService = new BookService();
        List<BookInfo> list = bookService.getList();
        return list;
    }
}