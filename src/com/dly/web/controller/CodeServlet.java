package com.dly.web.controller;



import com.dly.utils.CodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CodeServlet",urlPatterns = "/code.action")
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //产生图片和验证码
//        Map<String,Object> codeMap = CodeUtil.generateCodeAndPic();
//        //将验证码保存到session中
//        HttpSession session = request.getSession();
//        session.setAttribute("code",codeMap.get("code").toString());
//
//        //禁止图片缓存
//
//
//
//
//        //jsp用image方式打开图片
//        response.setContentType("images/jpeg");
//        //存入servlet输入流中
//        ServletOutputStream sos;
//        sos = response.getOutputStream();
//        ImageIO.write((RenderedImage)codeMap.get("codePic"),"jpeg",sos);
//        sos.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //产生图片和验证码
        Map<String,Object> codeMap = CodeUtil.generateCodeAndPic();
        //将验证码保存到session中
        HttpSession session = request.getSession();
        session.setAttribute("code",codeMap.get("code").toString());

        //禁止图片缓存

        //jsp用image方式打开图片
        response.setContentType("images/jpeg");
        //存入servlet输入流中
        ServletOutputStream sos;
        sos = response.getOutputStream();
        ImageIO.write((RenderedImage)codeMap.get("codePic"),"jpeg",sos);
        sos.close();


    }
}
