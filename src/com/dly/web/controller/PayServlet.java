package com.dly.web.controller;

import com.dly.dao.CartDao;
import com.dly.dao.MemberDao;
import com.dly.dao.impl.CartDaoImpl;
import com.dly.dao.impl.MemberDaoImpl;
import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.pojo.Member;
import com.dly.pojo.Order;
import com.dly.service.CartService;
import com.dly.service.MemberService;
import com.dly.service.OrderService;
import com.dly.service.impl.CartServiceImpl;
import com.dly.service.impl.MemberServiceImpl;
import com.dly.service.impl.OrderServiceImpl;
import com.dly.utils.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.dly.utils.OrderNumberUtil.getOrderIdByUUId;


@WebServlet(name = "PayServlet",urlPatterns = {"/pay.action"})
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取order_email
        String order_email = request.getParameter("email");
        //System.out.println(order_email);
        if(order_email==null||order_email.isEmpty()){
            request.getRequestDispatcher("/pages/payFailed.jsp").forward(request,response);
        }
        //获取username
        String order_user_name = request.getParameter("name");
        //System.out.println(order_user_name);
        if(order_user_name==null||order_user_name.isEmpty()){
            request.getRequestDispatcher("/pages/payFailed.jsp").forward(request,response);
        }


        //获取order_total_price
        int price = Integer.parseInt(request.getParameter("toPrice"));
        //System.out.println(price);


        //获取time
        TimeUtil tu = new TimeUtil();
        int time = (int) TimeUtil.getTimeStamp();
        //System.out.println(time);
        //构件order对象

        //获取member_id,知道member_nick_name，在来一个查询找到获取member_id
        Member mem2 = new Member();
        MemberDao memberDao =  new MemberDaoImpl();
        mem2 = memberDao.findByName(order_user_name);
        Order order = new Order();
        //
       /* if(mem2!=null){
            order.setOrder_member_id(mem2.getMember_id());
        }else{
            request.getRequestDispatcher("/pages/payFailed.jsp").forward(request,response);
        }*/

        //获取memberId
        Member member = (Member) request.getSession().getAttribute("member");
        order.setOrder_member_id(member.getMember_id());
        System.out.println(member.getMember_id());


        //得到订单号
        //orderNumberUtil = new OrderNumberUtil();*//*
        String cart_order_code = getOrderIdByUUId();
        //System.out.println(orderNumber);*/

        //order.setOrder_id(1);
        //得到cart的订单号
        Cart cart = new Cart();
        cart.setCart_member_id(member.getMember_id());
        cart.setCart_order_code(cart_order_code);
        CartDao cart1 = new CartDaoImpl();
        //Boolean orderNumber = cart1.insertCartCode(cart);

        //String sql = "select * from cart where cart_goods_id=? and cart_member_id=? and cart_order_status=? LIMIT 1";
        order.setOrder_code(cart_order_code);

        order.setOrder_user_name(order_user_name);
        order.setOrder_member_id(member.getMember_id());
        order.setOrder_email(order_email);
        order.setOrder_total_price(price);
        order.setOrder_pay_status(1);
        order.setOrder_add_time(time);
        order.setOrder_id(1);

        //调用service
        OrderService orderService = new OrderServiceImpl();
        BaseDto<Order> orderBaseDto = orderService.addOrderinfo(order);



        request.setAttribute("msg",orderBaseDto.getMsg());
        if(orderBaseDto.getCode() == 200 ){

            //把cart更新了

            /**
             *
             * 修改购物车，即将状态值置1，下次不显示
             */

            CartDao cartDao = new CartDaoImpl();
            //封装cart
            cart.setCart_order_status(1);
            cart.setCart_order_code(cart_order_code);
            //调用service
            cart.setCart_member_id(mem2.getMember_id());
            cartDao.updateCart(cart);




            request.getRequestDispatcher("/pages/paySuccess.jsp").forward(request,response);
        }
        request.getRequestDispatcher("/pages/payFailed.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
