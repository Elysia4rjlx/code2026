package com.elyjah._0261103blogsystem.controller;

import com.elyjah._0261103blogsystem.pojo.response.BlogInfoResponse;
import com.elyjah._0261103blogsystem.service.BlogInfoService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {

//    @Autowired
    @Resource(name = "blogInfoServiceImpl")
    private BlogInfoService blogInfoService;

    @RequestMapping("/getList")
    public List<BlogInfoResponse> getList() {
        return blogInfoService.getListByDesc();
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail(@NotNull(message = "blogId 不能为空") Integer blogId) {
        log.info("获取博客详情，blogID：{}",blogId);
        return blogInfoService.getBlogDetail(blogId);
    }
}