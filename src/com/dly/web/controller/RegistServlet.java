package com.dly.web.controller;

import com.dly.dto.BaseDto;
import com.dly.pojo.Member;
import com.dly.service.MemberService;
import com.dly.service.impl.MemberServiceImpl;
import com.dly.utils.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet",urlPatterns = {"/regist.action"})
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberNikname = request.getParameter("member_nikname");
        String memberPwd = request.getParameter("member_pwd");
        String surePwd = request.getParameter("sure_pwd");
        String memberEmail = request.getParameter("member_email");
        String memberName = request.getParameter("member_name");
        String memberPhone = request.getParameter("member_phone");
        String memberVeriCode = request.getParameter("member_vericode");

        Member member = new Member();

        member.setMember_nikname(memberNikname);
        member.setMember_pwd(MD5Util.MD5(memberPwd));
        member.setMember_email(memberEmail);
        member.setMember_name(memberName);
        member.setMember_phone(Long.valueOf(memberPhone));
        //得到session中的验证码
        String sessionCode = request.getSession().getAttribute("code").toString();

        MemberService ms = new MemberServiceImpl();
        BaseDto<Member> baseDto = ms.regist(member,surePwd,memberVeriCode,sessionCode);
        request.setAttribute("msg",baseDto.getMsg());
        if(baseDto.getCode() == 200){
            //注册成功！
            //System.out.println(sessionCode);

            request.getRequestDispatcher("/pages/registSuccess.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/pages/registFailed.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
