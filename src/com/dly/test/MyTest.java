package com.dly.test;

import com.dly.dao.CategoryDao;
import com.dly.dao.impl.CategoryDaoImpl;
import com.dly.dao.impl.GoodsDaoImpl;
import com.dly.pojo.Category;
import com.dly.utils.MD5Util;
import org.junit.Test;

import java.util.List;

public class MyTest {
    /**
     * 测试分类
     */
    @Test
    public void test01(){
        //1、得到对应的dao的实例
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();

        //2、执行方法
        List<Category> categories = categoryDao.findAll();

        //测试
        for (Category category:categories){
            System.out.println(category);
        }
    }

    @Test
    public void test02(){

        String pwd = MD5Util.MD5("123123");
//        String pwd2 = MD5Util.MD5(pwd1);
//
//        String pwd = pwd1.substring(0,15)+pwd2.substring(15);
//        System.out.println(pwd.length());
        System.out.println(pwd);

    }

    @Test
    public void test03(){

        GoodsDaoImpl goodsDao=new GoodsDaoImpl();
        Integer totalCount=goodsDao.getTotalCount(1);
        System.out.println(totalCount);

    }
}
