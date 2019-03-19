package com.dly.service.impl;

import com.dly.dao.CategoryDao;
import com.dly.dao.impl.CategoryDaoImpl;
import com.dly.pojo.Category;
import com.dly.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    /**
     * 分类的数据访问对象
     */
    private CategoryDao cd=new CategoryDaoImpl();

    /**
     * 获取分类的列表
     * @return
     */
    @Override
    public List<Category> getList() {
        //数据的验证
        List<Category> all = cd.findAll();

        return all;
    }
}
