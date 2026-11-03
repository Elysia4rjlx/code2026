package com.elyjah._0261103blogsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elyjah._0261103blogsystem.domain.BlogInfo;
import com.elyjah._0261103blogsystem.service.BlogInfoService;
import com.elyjah._0261103blogsystem.mapper.BlogInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Elysia1111
* @description 针对表【blog_info(博客表)】的数据库操作Service实现
* @createDate 2026-11-03 16:24:15
*/
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo>
    implements BlogInfoService{

}




