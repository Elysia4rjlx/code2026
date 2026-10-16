package com.elyjah._0261016logdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerController {

    //private —— 日志对象是类的实现细节，不需要暴露给外部。
    //static —— Logger 是无状态且线程安全的对象，全类共用一个就够。设成 static 是为了避免每 new 一个实例就 new 一个 Logger。
    //final —— 不允许重新赋值。有人可能想 logger =
    // LoggerFactory.getLogger(Other.class) 来"换个名字"，
    // 这在排查问题时是有害的：日志显示的 Logger 名和你以为的不一样，会把人带偏。
    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping
    public String logger() {
        // 两种都留着，方便肉眼对比
        System.out.println("-------------- System.out 打印日志 ----------------");
        logger.info("-------------- Slf4j 要输出日志的内容 ----------------");
        return "请观察控制台两种输出的区别";
    }

    @GetMapping("/placeholder")
    public String placeholder() {
        String id = "0024";

        //反面教材：字符串拼接
        logger.info("[错误写法]: 用户 " + id + "登录成功");
        logger.debug("[错误写法] 用户订单数： " +findOrderCount(id));

        //正确写法
        logger.info("用户 {} 登录成功",id );
        logger.debug("用户订单数：{} ,",id);

        return "对比两种写法的输出";
    }

    private String findOrderCount(String id) {
        System.out.println(">>> findOrderCount 被调用了");
        return "42";
    }

    //现在是 root: info，debug 被过滤了。预期出现 2 次：
    //
    //错误写法那行——拼接在调用之前，findOrderCount 已经执行了，日志却没打印
    //正确写法那行——Logback 判断级别被过滤，方法根本没被调用

    public String exception(){
        String userId = "9999";
        try{
            simulateFailure();
        }catch (Exception e) {
            logger.error("查阅用户失败，userId={}",userId,e);
        }
        return "请观察控制台的堆栈信息";
    }

    private void simulateFailure() {
        throw new RuntimeException("模拟的数据库连接异常");
    }
}
