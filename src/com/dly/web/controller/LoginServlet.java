package com.dly.web.controller;

import com.dly.dto.BaseDto;
import com.dly.pojo.Member;
import com.dly.service.MemberService;
import com.dly.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login.action"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从表单获取用户名密码
        String member_nikname = request.getParameter("member_nikname");
        String member_pwd = request.getParameter("member_pwd");
        //创建member对象保存用户名密码
        Member member = new Member();
        member.setMember_nikname(member_nikname);
        member.setMember_pwd(member_pwd);
        //调用service获取查询的数据，以及返回信息
        MemberService ms = new MemberServiceImpl();
        BaseDto<Member> login = ms.login(member);
        //将返回信息给页面
        request.setAttribute("msg", login.getMsg());

        //判断登录是否成功
        if (login.getCode() == 200) {
            //登录成功，将member对象放入session，并跳转到相应页面
            request.getSession().setAttribute("member", login.getData());
            //将用户名密码存入cookie中
            String autoLogin = request.getParameter("autoLogin");
            String usernameCode = URLEncoder.encode(member_nikname, "utf-8");
            if (autoLogin != null) {
                Cookie usernameCookie = new Cookie("usernameCookie", usernameCode);
                Cookie passwordCookie = new Cookie("passwordCookie", member_pwd);
                //设置携带路径
                usernameCookie.setPath(request.getContextPath());
                passwordCookie.setPath(request.getContextPath());
                //cookie存在时间
                usernameCookie.setMaxAge(60 * 60);
                passwordCookie.setMaxAge(60 * 60);
                //发送cookie
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                //response.sendRedirect("/index.jsp");
                System.out.println("选中");
            }
            String remember = request.getParameter("remember");
            Cookie usernameCookie = new Cookie("member_nikname", usernameCode);
            if(remember != null){
                //String usernameCode = URLEncoder.encode(member_nikname, "utf-8");
                usernameCookie.setMaxAge(60 * 60);
                response.addCookie(usernameCookie);
            }else{
                usernameCookie.setMaxAge(0);
                response.addCookie(usernameCookie);
            }
            request.getRequestDispatcher("/pages/loginSuccess.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/loginFailed.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.getSession().setAttribute("member", null);
        //注销时清除cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(!"member_nikname".equals(cookie.getName())){
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println("士大夫");
                }
            }
        }
        System.out.println("士");
        response.sendRedirect("/index.jsp");
    }
}