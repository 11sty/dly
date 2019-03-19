package com.dly.web.controller;

import com.dly.dao.CartDao;
import com.dly.dao.impl.CartDaoImpl;
import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.service.CartService;
import com.dly.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCartCountServlet",urlPatterns = {"/UpdateCartCount.action"})
public class UpdateCartCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartServiceImpl cs = new CartServiceImpl();

        //更新购物车记录
        String id = request.getParameter("cartId");
        Integer cartId=Integer.valueOf(id);
        String count=request.getParameter("count");
        Integer cartCount=Integer.valueOf(count);

        Cart cart=new Cart();
        cart.setCart_id(cartId);
        cart.setCart_goods_count(cartCount);
        cs.updateCartCount(cart);
        //request.getRequestDispatcher("/pages/mybag.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
