package com.elyjah._0261103blogsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elyjah._0261103blogsystem.common.Constants;
import com.elyjah._0261103blogsystem.common.enums.ResultCodeEnum;
import com.elyjah._0261103blogsystem.common.exception.BlogException;
import com.elyjah._0261103blogsystem.common.util.BeanTrans;
import com.elyjah._0261103blogsystem.domain.BlogInfo;
import com.elyjah._0261103blogsystem.pojo.response.BlogInfoResponse;
import com.elyjah._0261103blogsystem.service.BlogInfoService;
import com.elyjah._0261103blogsystem.mapper.BlogInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Elysia1111
 * @description 针对表【blog_info(博客表)】的数据库操作Service实现
 * @createDate 2026-11-03 16:24:15
 */
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo>
        implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public List<BlogInfoResponse> getListByDesc() {
        //从数据库中查询数据
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getDeleteFlag, Constants.IS_NOT_DELETE).orderByDesc(BlogInfo::getId));

        //转换数据格式
//        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream()
//                .map(blogInfo -> BeanTrans.trans(blogInfo)).toList();

        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream().map(blog -> {
            BlogInfoResponse resp = new BlogInfoResponse();
            BeanUtils.copyProperties(blog, resp);

            String content = blog.getContent();
            if (content == null) {
                resp.setContent("");
            } else {
                resp.setContent(content.length() > 10
                        ? content.substring(0, 10)
                        : content);
            }
            return resp;

        }).toList();
        return blogInfoResponses;

//            List<BlogInfo> blogInfos = blogInfoMapper.selectList(
//                    new LambdaQueryWrapper<BlogInfo>()
//                            .eq(BlogInfo::getDeleteFlag, Constants.IS_NOT_DELETE)   // 条件：delete_flag = 0，只要未删除的
//                            .orderByDesc(BlogInfo::getId));                          // 排序：ORDER BY id DESC
//            // 先准备一个【空的】结果列表，等下往里装
//            List<BlogInfoResponse> blogInfoResponses = new ArrayList<>();
//
//            // 一条一条处理：冒号左边=每次取出来的那一个，右边=要遍历的列表
//            for (BlogInfo blogInfo : blogInfos) {
//                BlogInfoResponse resp = new BlogInfoResponse();                      // 造一个空的返回对象
//                BeanUtils.copyProperties(blogInfo, resp);                            // 源 → 目标 按同名属性拷（此时 content 是全文）
//
//                String content = blogInfo.getContent();                              // 取原始全文
//                if (content == null) {
//                    resp.setContent("");                                             // 空值给空串
//                } else {
//                    resp.setContent(content.length() > 10                            // 先判长度
//                            ? content.substring(0, 10)                               // 够长截前 10 字
//                            : content);                                              // 不够长原样给
//                }
//                blogInfoResponses.add(resp);                                         // 把这一个放进结果列表（对应 stream 版的 return resp）
//            }
//            return blogInfoResponses;                                                // 交回 Controller
//        }


    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        BlogInfo blogInfo = blogInfoMapper.selectOne(new LambdaQueryWrapper<BlogInfo>()
                .eq(BlogInfo::getId,blogId).eq(BlogInfo::getDeleteFlag,Constants.IS_NOT_DELETE));

        if (blogInfo == null) {
            throw new BlogException("博客不存在");
//            throw new BlogException(ResultCodeEnum.PARAM_ERROR, "博客不存在");

        }


        return BeanTrans.trans(blogInfo);
    }
}




