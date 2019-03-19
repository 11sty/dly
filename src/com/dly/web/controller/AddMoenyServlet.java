package com.dly.web.controller;

import com.dly.dao.CartDao;
import com.dly.dao.MemberDao;
import com.dly.dao.impl.CartDaoImpl;
import com.dly.dao.impl.MemberDaoImpl;
import com.dly.pojo.Member;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddMoenyServlet",urlPatterns = {"/addmoney.action"})
public class AddMoenyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取memberId
        Member member = (Member) request.getSession().getAttribute("member");
        //获取充值的钱数
        String addMoney = request.getParameter("money");
        System.out.println(addMoney);

        //找到原来的钱
        Member oldmoneymember = new Member();
        MemberDao memberDao = new MemberDaoImpl();
        oldmoneymember = memberDao.findByName(member.getMember_nikname());

        member.setMember_money(oldmoneymember.getMember_money()+Integer.valueOf(addMoney));
        Boolean tag = memberDao.updateMember(member);

        if(tag==null){
            request.getRequestDispatcher("/pages/addMoneyFailed.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/pages/addMoneySuccess.jsp").forward(request,response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
