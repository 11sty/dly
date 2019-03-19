package com.dly.dao;

import com.dly.pojo.Category;

import java.util.List;

public interface CategoryDao {
    //查询所有分类的方法
    List<Category> findAll();
}
