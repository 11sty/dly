package com.dly.web.controller;

import com.dly.pojo.Member;
import com.dly.pojo.Scan;
import com.dly.service.ScanService;
import com.dly.service.impl.ScanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddScanServlet",urlPatterns = {"/addScan.action"})
public class AddScanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsId=request.getParameter("goodsId");
        Member member= (Member) request.getSession().getAttribute("member");

        Scan scan=new Scan();
        scan.setScan_goods_id(Integer.valueOf(goodsId));
        scan.setScan_member_id(member.getMember_id());

        ScanService sc=new ScanServiceImpl();
        sc.saveScan(scan);
    }
}
