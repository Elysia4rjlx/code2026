package com.elyjah._026_10_01bookdemo.model;

import lombok.Data;

import java.util.List;

/**
 * 翻页结果
 * @param <T> 记录类型
 */
@Data
public class PageResult<T> {
    private int total;   //所有记录数
    private List<T> records; // 当前页数据
    private PageRequest pageRequest; // 把分页参数也带回去

    public PageResult(int total, List<T> records, PageRequest pageRequest) {
        this.total = total;
        this.records = records;
        this.pageRequest = pageRequest;
    }
}