package com.elyjah._026_10_01bookdemo.service;


import com.elyjah._026_10_01bookdemo.controller.BookController;
import com.elyjah._026_10_01bookdemo.enums.BookStatus;
import com.elyjah._026_10_01bookdemo.mapper.BookInfoMapper;
import com.elyjah._026_10_01bookdemo.model.BookInfo;
import com.elyjah._026_10_01bookdemo.model.PageRequest;
import com.elyjah._026_10_01bookdemo.model.PageResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    /**
     * 添加图书
     *
     */
    public void addBook(BookInfo bookInfo){
        bookInfoMapper.insertBook(bookInfo);
    }


    /**
     * 分页查询图书列表 （支持按书名搜索）
     */
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest,String bookName) {
        // 1. 查总数
        Integer count = bookInfoMapper.count(bookName);
        // 2. 查当前页数据
        List<BookInfo> books = bookInfoMapper.queryBookListByPage(pageRequest,bookName);
        // 3. 翻译状态中文名
        for(BookInfo book : books){
//            book.setStatusCN(BookStatus.getNameByCode(book.getStatus()).getName());
            BookStatus statusEnum = BookStatus.getNameByCode(book.getStatus());
            book.setStatusCN(statusEnum == null ? "未知" : statusEnum.getName());
        }
        // 4. 封装返回
        return new PageResult<>(count,books,pageRequest);

    }

    /**
     * 根据ID查询图书
     */
    public BookInfo queryBookById(Integer bookId) {
        return bookInfoMapper.queryBookById(bookId);
    }

    /**
     * 修改图书
     */
    public void updateBook(BookInfo bookInfo) {
        bookInfoMapper.updateBook(bookInfo);
    }


    /**
     * 批量删除图书（逻辑删除）
     */
    public void batchDeleteBook(List<Integer> ids) {
        //危险操作校验：集合为空的时候直接返回，一条SQL都不发

//        ids.isEmpty() （防无效数据库操作）
//        含义：前端传了参数，但传过来的是一个空数组（比如 []
        if (ids ==null || ids.isEmpty()){
            log.warn("批量删除图书ids为空, 已忽略");
            return;
        }
        bookInfoMapper.batchDeleteBook(ids);
    }
}