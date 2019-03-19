package com.dly.web.filter;

import com.dly.pojo.Member;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"*.action","*.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //放行前
        //System.out.println("拦截到啦！");
        /**
         * 判断是否有session，有则放行
         * 没有：拦截
         * 跳转到指定的页面
         */

        //参数的强转
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        //准备放行的url
        String urls="/,/login.jsp,/index.action,/login.action,/regist.action,/regist.jsp,/index.jsp,/code.action,/select.action";

        //获取当前请求的url
        String requestURL = request.getRequestURL().toString();
        String url=requestURL.substring(requestURL.lastIndexOf("/"));
        //System.out.println(url);
        if(urls.indexOf(url)==-1){
            //获取session
            HttpSession session = request.getSession();

            //判断Session是否有值
            Member member= (Member) session.getAttribute("member");

            if(member==null){
                //拦截到了
                response.sendRedirect("/pages/login.jsp");
                return;
            }
        }

        //放行
        chain.doFilter(req, resp);

        //放行后
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤被创建成功！");

    }

}
