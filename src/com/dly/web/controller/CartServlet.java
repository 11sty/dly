package com.dly.web.controller;

import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.pojo.Category;
import com.dly.pojo.Member;
import com.dly.service.CartService;
import com.dly.service.CategoryService;
import com.dly.service.impl.CartServiceImpl;
import com.dly.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = {"/cart.action"})
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取goods_id
        String goods_id = request.getParameter("goods_id");
        //获取member_id
        Member member= (Member) request.getSession().getAttribute("member");
        //构建cart对象
        Cart cart = new Cart();
        cart.setCart_goods_id(Integer.valueOf(goods_id));
        cart.setCart_member_id(member.getMember_id());

        //调用service
        CartService cartService=new CartServiceImpl();
        BaseDto<Cart> cartBaseDto=cartService.addCard(cart);

        if(cartBaseDto.getCode()==200){
            request.setAttribute("msg",cartBaseDto.getMsg());
            request.getRequestDispatcher("/pages/cartSuccess.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/pages/cartFailed.jsp").forward(request,response);
        }
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

        //购物车列表
        //获取memberId
        Member member = (Member) request.getSession().getAttribute("member");
        CartService cartService = new CartServiceImpl();
        List<Cart> carts=cartService.cartList(member.getMember_id());
        request.setAttribute("carts",carts);
        request.getRequestDispatcher("/pages/mybag.jsp").forward(request,response);

    }
}
