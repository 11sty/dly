<%--
  Created by IntelliJ IDEA.
  User: 天哥
  Date: 2019/2/22
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--头部文件引入开始--%>
<jsp:include page="common/header.jsp"/>
<%--头部文件引入结束--%>

<div class="container">
    <div class="row">
        <c:forEach items="${selectResult.content}" var="result">
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="${pageContext.request.contextPath}/detail.action?id=${result.goods_id}"><img class="pic" src="${pageContext.request.contextPath}/file/book/${result.goods_img}" /></a>
            <p class="price">¥ ${result.goods_price}点券</p>
            <p class="bookname"><a href="#">${result.goods_name}</a></p>
        </div>
        </c:forEach>
    </div>
</div>

<!--分页 -->
<div class="container">
    <div class="row text-center" style="margin: 50px auto">
        <ul class="pagination" style="text-align:center; margin-top:10px;">
            <li class="disabled">
            <c:if test="${selectResult.nowPage!=1}">
                <a href="${pageContext.request.contextPath}/select.action?keyWords=${key}&page=${p>1 ? p-1: 1}" aria-label="Next">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </c:if>
            </li>
            <c:forEach items="${selectResult.pagesList}" var="p">
                <li class="${selectResult.nowPage==p ? "active":""}">
                    <a href="${pageContext.request.contextPath}/select.action?keyWords=${key}&page=${p}">${p}</a>
                </li>
            </c:forEach>
            <li>
                <c:if test="${selectResult.nowPage!=selectResult.totalPages}">
                    <a href="${pageContext.request.contextPath}/select.action?keyWords=${key}&page=${p<selectResult.totalPages ? p: selectResult.totalPages}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </c:if>
            </li>
        </ul>
    </div>
</div>
<!-- 分页结束=======================-->

<!--商品浏览记录-->
<!-- <div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

    <h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
    <div style="width: 50%;float: right;text-align: right;">
        <a href="">more</a>
    </div>
    <div style="clear: both;"></div>

    <div style="overflow: hidden;">

        <ul style="list-style: none;">
            <li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
                <img src="products/1/cs10001.jpg" width="130px" height="130px" />
                <p>
            </li>
        </ul>
    </div>
</div> -->
<div class="container">
    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a style="color:green">浏览记录</a></li>
        </ul>
    </div>
    <div class="row" style="border: 1px solid #ddd;padding:30px ">
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">¥ 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">¥ 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">¥ 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">¥ 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">¥ 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">¥ 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
    </div>
</div>
<!--页脚-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px;">
            <img src="${pageContext.request.contextPath}/static/img/footer.jpg" style="width: 98%;"/>
        </div>
    </div>
</div>
<hr />

<!--友情链接和版权信息-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="" align="center">
            <ul class="list-inline">
                <li><a>关于我们</a></li>
                <li><a>联系我们</a></li>
                <li><a>招贤纳士</a></li>
                <li><a>法律声明</a></li>
                <li><a>友情链接</a></li>
                <li><a>支付方式</a></li>
                <li><a>配送方式</a></li>
                <li><a>服务声明</a></li>
                <li><a>广告声明</a></li>
            </ul>
        </div>
        <div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
            Copyright &copy; 2003-2017 国信安书城 版权所有
        </div>
    </div>
</div>

</body>

</html>
