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

@WebServlet(name = "BookDetailServlet",urlPatterns = {"/detail.action"})
public class BookDetailServlet extends HttpServlet {
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
         * *********************  分类列表结束  *******************
         */

        //获取数据
        String id=request.getParameter("id");
        
        //调用service
        GoodsService gs = new GoodsServiceImpl();

        Goods detail = gs.detail(Integer.valueOf(id));

        request.setAttribute("detail",detail);

        request.getRequestDispatcher("/pages/bookinfo.jsp").forward(request,response);
    }
}
