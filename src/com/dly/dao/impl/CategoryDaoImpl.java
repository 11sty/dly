package com.dly.dao.impl;

import com.dly.dao.CategoryDao;
import com.dly.pojo.Category;
import com.dly.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    /**
     * sql执行器
     */
    private QueryRunner runner=new QueryRunner(DruidUtil.getDataSource());

    /*
        查询所有分类
        写相关的sql语句
     */
    public List<Category> findAll(){
        //1、准备sql语句
        String sql="select * from category order by category_id asc limit 10";

        //2、执行sql
        List<Category> list=null;
        try {
            //执行sql并处理结果
             list = runner.query(sql, new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
