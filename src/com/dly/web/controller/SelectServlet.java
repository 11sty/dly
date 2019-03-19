package com.dly.web.controller;

import com.dly.pojo.Category;
import com.dly.pojo.Goods;
import com.dly.service.CategoryService;
import com.dly.service.GoodsService;
import com.dly.service.impl.CategoryServiceImpl;
import com.dly.service.impl.GoodsServiceImpl;
import com.dly.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = {"/select.action"})
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 分类处理
         */
        //调用service
        CategoryService cs=new CategoryServiceImpl();
        //拿到分类的列表
        List<Category> categories=cs.getList();
       //将数据存放在request域对象
        request.setAttribute("list",categories);

        //获取查询关键字
        request.setCharacterEncoding("utf-8");
        String keyWords=request.getParameter("keyWords");
        String pageStr = request.getParameter("page");
        Integer page = pageStr == null? 1 : Integer.valueOf(pageStr);
        Integer pageSize=12;
        //调用serivce
        GoodsService rs=new GoodsServiceImpl();
        PageUtil<Goods> pageUtil=new PageUtil<>();

        pageUtil.setNowPage(page);
        pageUtil.setPageSize(pageSize);

        rs.getSelectResultByKeyWord(pageUtil,keyWords);
        System.out.println(pageUtil.getTotalNums());
        request.setAttribute("key",keyWords);
        request.setAttribute("selectResult",pageUtil);
        request.getRequestDispatcher("pages/select.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
}
