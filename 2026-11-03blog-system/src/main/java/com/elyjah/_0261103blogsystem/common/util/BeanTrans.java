package com.elyjah._0261103blogsystem.common.util;


import com.elyjah._0261103blogsystem.common.exception.BlogException;
import com.elyjah._0261103blogsystem.domain.BlogInfo;
import com.elyjah._0261103blogsystem.pojo.response.BlogInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanTrans {
    public static BlogInfoResponse trans(BlogInfo blogInfo) {
        if (blogInfo == null) {
            throw new BlogException("博客信息不为空");
        }
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo,blogInfoResponse);
        return blogInfoResponse;
    }
}