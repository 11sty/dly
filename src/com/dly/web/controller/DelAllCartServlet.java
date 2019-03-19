package com.dly.web.controller;

import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.pojo.Member;
import com.dly.service.CartService;
import com.dly.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelAllCartServlet",urlPatterns = {"/delAllCart.action"})
public class DelAllCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = new CartServiceImpl();
        //删除指定会员ID的购物车记录
        //获取member_id
        Member member= (Member) request.getSession().getAttribute("member");
        Cart cart=new Cart();
        cart.setCart_member_id(member.getMember_id());

        BaseDto<Cart> cartBaseDto1=cartService.delAllCart(cart);
        if(cartBaseDto1.getCode()==200){
            request.setAttribute("msg",cartBaseDto1.getMsg());
            request.getRequestDispatcher("/pages/cartSuccess.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/pages/cartFailed.jsp").forward(request,response);
        }
    }
}
