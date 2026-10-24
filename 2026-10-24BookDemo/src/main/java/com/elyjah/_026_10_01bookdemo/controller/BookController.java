package com.elyjah._026_10_01bookdemo.controller;

import com.elyjah._026_10_01bookdemo.common.Constant;
import com.elyjah._026_10_01bookdemo.common.Result;
import com.elyjah._026_10_01bookdemo.model.BookInfo;
import com.elyjah._026_10_01bookdemo.model.PageRequest;
import com.elyjah._026_10_01bookdemo.model.PageResult;
import com.elyjah._026_10_01bookdemo.model.UserInfo;
import com.elyjah._026_10_01bookdemo.service.BookService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 分页查询图书列表，（支持按书名搜索
     */
    @GetMapping("/getListByPage")
    public Result<PageResult<BookInfo>> getListByPage(PageRequest pageRequest, String bookName, HttpSession session) {
        log.info("获取图书列表,pageRequest:{},bookName:{}", pageRequest, bookName);

        // 1. Session 里根本没有登录用户的 key ->肯定没登录
        if (session.getAttribute(Constant.SESSION_USER_KEY) == null) {
            return Result.unlogin();
        }
            // 2. key 存在，但取出来的值是空的 / 用户信息不完整 -> 也当作没登录
            UserInfo userInfo = (UserInfo) session.getAttribute(Constant.SESSION_USER_KEY);
            if (userInfo == null || userInfo.getId() < 0 || "".equals(userInfo.getUserName())) {
                return Result.unlogin();
            }
            // 3. 登录了，正常返回图书列表
            PageResult<BookInfo> pageResult = bookService.getBookListByPage(pageRequest, bookName);
            return Result.success(pageResult);
        }


        /**
         * 添加图书
         * @return "" 表示成功
         */
        @PostMapping("/addBook")
        public String addBook (BookInfo bookInfo){
            log.info("添加图书：{}", bookInfo);
            if (!StringUtils.hasLength(bookInfo.getBookName())
                    || !StringUtils.hasLength(bookInfo.getAuthor())
                    || bookInfo.getCount() == null
                    || bookInfo.getPrice() == null
                    || !StringUtils.hasLength(bookInfo.getPublish())
                    || bookInfo.getStatus() == null) {
                return "输入参数不合法, 请检查入参!";
            }
            try {
                bookService.addBook(bookInfo);
                return "";
            } catch (Exception e) {
                log.error("添加图书失败", e);
                return e.getMessage();
            }
        }

        /**
         * 根据Id查阅图书
         */
        @GetMapping("/queryBookById")
        public BookInfo queryBookById (Integer bookId){
            log.info("根据ID查询图书：bookId={}", bookId);
            if (bookId == null || bookId < 0) {
                return new BookInfo();
            }
            return bookService.queryBookById(bookId);
        }

        /**
         * 修改图书
         * @return "" 表示成功
         */
        @PostMapping("/updateBook")
        public String updateBook (BookInfo bookInfo){
            log.info("修改图书：{}", bookInfo);

            try {
                bookService.updateBook(bookInfo);
                return "";
            } catch (Exception e) {
                log.error("修改失败：", e);
                return e.getMessage();
            }
        }


        /**
         * 批量删除图书（逻辑删除）
         * @return
         *
         */
        @PostMapping("/batchDeleteBook")
        public boolean batcDeleteBook (@RequestParam List < Integer > ids) {
//        @RequestParam：从 HTTP 请求中提取参数，并绑定到 Controller 方法的形参上
            if (ids == null || ids.isEmpty()) {
                log.warn("批量删除图书, 未选择任何图书");
                return false;
            }

            log.info("批量删除图书，ids：{}", ids);

            try {
                bookService.batchDeleteBook(ids);
            } catch (Exception e) {
                log.error("批量删除异常，e：", e);
                return false;
            }
            return true;
        }


}