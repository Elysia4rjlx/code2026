package com.elyjah._0261016logdemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping
    public void log(){
        log.info("-------------- 要输出日志的内容----------------");
    }


    @GetMapping("/printLog")
    public String printLog(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "请观察控制台";
    }
}