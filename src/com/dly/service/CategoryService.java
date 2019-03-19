package com.dly.service;

import com.dly.pojo.Category;

import java.util.List;

//主要用于存放业务逻辑
public interface CategoryService {

    /**
     * 获取分类的列表
     * @return
     */
    List<Category> getList();
}
