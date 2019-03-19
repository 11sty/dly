package com.dly.web.controller;

import com.dly.pojo.Category;
import com.dly.pojo.Member;
import com.dly.pojo.Order;
import com.dly.service.CategoryService;
import com.dly.service.OrderService;
import com.dly.service.impl.CategoryServiceImpl;
import com.dly.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = {"/orderList.action"})
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 分类处理
         */
        //调用service
        CategoryService cs=new CategoryServiceImpl();
        //拿到分类的列表
        List<Category> categories=cs.getList();
        //将数据存放在request域对象
        request.setAttribute("list",categories);

        /**
         * 我的订单列表
         */
        Member member= (Member) request.getSession().getAttribute("member");

        OrderService orderService=new OrderServiceImpl();
        List<Order> orders=orderService.orderList(member.getMember_id());
        System.out.println(orders);
        request.setAttribute("orderList",orders);
        request.getRequestDispatcher("/pages/orderlist.jsp").forward(request,response);
    }
}
