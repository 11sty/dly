package com.dly.web.controller;

import com.dly.dao.impl.GoodsDaoImpl;
import com.dly.pojo.Category;
import com.dly.pojo.Goods;
import com.dly.pojo.Member;
import com.dly.pojo.Scan;
import com.dly.service.CategoryService;
import com.dly.service.GoodsService;
import com.dly.service.ScanService;
import com.dly.service.impl.CategoryServiceImpl;
import com.dly.service.impl.GoodsServiceImpl;
import com.dly.service.impl.ScanServiceImpl;
import com.dly.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet",urlPatterns = {"/bookList.action"})
public class BookListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        /**
         * ********************  书籍列表 ********************
         */
        //获取category_id
        String id = request.getParameter("id");
        Integer category_id=Integer.valueOf(id);

        //获取当前的页数
        String pageStr=request.getParameter("page");
        Integer page=pageStr==null?1:Integer.valueOf(pageStr);
        Integer pageSize=12;

        //调用service,获取数据
        GoodsService gs = new GoodsServiceImpl();
        //List<Goods> categoryList=gs.getCategoryList(category_id);
        PageUtil<Goods> pageUtil = new PageUtil<>();
        pageUtil.setNowPage(page);
        pageUtil.setPageSize(pageSize);
        gs.getCategoryList(pageUtil,category_id);
        //request.setAttribute("categoryList",categoryList);
        request.setAttribute("pageUtil",pageUtil);

        //浏览记录
        Member member= (Member) request.getSession().getAttribute("member");
        List<Goods> scanList=gs.getScanList(member.getMember_id());
        request.setAttribute("scanList",scanList);

        //数据转发
        request.getRequestDispatcher("/pages/bookList.jsp").forward(request,response);

    }
}
