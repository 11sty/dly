package com.dly.web.controller;

import com.dly.pojo.Category;
import com.dly.pojo.Goods;
import com.dly.service.CategoryService;
import com.dly.service.GoodsService;
import com.dly.service.impl.CategoryServiceImpl;
import com.dly.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//首页
@WebServlet(name = "IndexServlet",urlPatterns = {"/index.action"})
public class IndexServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * *****************   分类列表  *******************
         * */
        //调用service
        CategoryService cs= new CategoryServiceImpl();

        //获取分类的列表
        List<Category> categories = cs.getList();

        //把数据存放到request域对象
        request.setAttribute("list",categories);

        /**
         * *****************   推荐书籍  *******************
         * */
        GoodsService gs=new GoodsServiceImpl();
        List<Goods> reGoods = gs.getReGoods();
        System.out.println(reGoods);
        request.setAttribute("query1",reGoods);

        /**
         * *****************   新上架书籍  *******************
         * */
        List<Goods> newGoods = gs.getNewGoods();
        request.setAttribute("query2",newGoods);

        //请求转发
        request.getRequestDispatcher("/pages/index.jsp").forward(request,response);


        //System.out.println("hello servlet!");
    }
}
