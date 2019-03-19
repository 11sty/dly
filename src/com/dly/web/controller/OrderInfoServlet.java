package com.dly.web.controller;

import com.dly.dao.CartDao;
import com.dly.dao.OrderDao;
import com.dly.dao.impl.CartDaoImpl;
import com.dly.dao.impl.OrderDaoImpl;
import com.dly.pojo.Cart;
import com.dly.pojo.Category;
import com.dly.pojo.Member;
import com.dly.pojo.Order;
import com.dly.service.CartService;
import com.dly.service.CategoryService;
import com.dly.service.impl.CartServiceImpl;
import com.dly.service.impl.CategoryServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.dly.utils.OrderNumberUtil.getOrderIdByUUId;

@WebServlet(name = "OrderInfoServlet",urlPatterns = {"/orderinfo.action"})
public class OrderInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * ==========处理分类=============
         */
        // 调用service
        CategoryService cs = new CategoryServiceImpl();

        // 拿到分类的列表
        List<Category> categories = cs.getList();

        // 把数据存放到 request域对象
        request.setAttribute("list",categories);


        /***
         * 购物车列表
         */
        //获取memberId
        Member member = (Member) request.getSession().getAttribute("member");


        /**
         * sty
         */
        //生成订单号
        String orderNumber = getOrderIdByUUId();
        CartDao cart = new CartDaoImpl();
        Boolean tag = cart.insertCartCode(orderNumber,member.getMember_id());
        //System.out.println("tag:"+tag);



        CartService cartService = new CartServiceImpl();
        List<Cart> carts = cartService.cartList(member.getMember_id());

        /**
         * sty
         */
        //存入cart中
        for (Cart temp: carts) {
            temp.setCart_order_code(orderNumber);
            System.out.println("temp:"+temp.getCart_order_code());
        }



        request.setAttribute("orderinfo",carts);

        request.getRequestDispatcher("/pages/orderinfo.jsp").forward(request,response);


    }
}
