package com.elyjah._026_10_01bookdemo.model;

import lombok.Data;

/**
 * 翻页请求参数
 */
@Data
public class PageRequest {
    private int currentPage = 1; //当前页码默认第一页
    private int pageSize = 10;

    // 占位字段，真正的值由 getOffset() 计算
    private int offset;

    /**
     * 计算 SQL 的起始索引
     * 第1页 -> (1-1)*10 = 0
     * 第2页 -> (2-1)*10 = 10
     */
    public int getOffset() {
        return (currentPage - 1) * pageSize;
    }
}