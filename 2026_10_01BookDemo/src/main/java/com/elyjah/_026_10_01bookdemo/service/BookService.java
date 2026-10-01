package com.elyjah._026_10_01bookdemo.service;


import com.elyjah._026_10_01bookdemo.dao.BookDao;
import com.elyjah._026_10_01bookdemo.model.BookInfo;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

public class BookService {
    @GetMapping("/getList")
    public List<BookInfo> getList() {
        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfos = bookDao.mockBookData();

        for (BookInfo bookInfo : bookInfos){
            if (bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}