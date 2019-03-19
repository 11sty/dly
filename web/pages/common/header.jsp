<%--
  Created by IntelliJ IDEA.
  User: xi
  Date: 2019/2/17
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:forward page="${pageContext.request.contextPath}/index.action"></jsp:forward>--%>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>国信安图书借阅在线首页</title>

    <!-- 引入Bootstrap核心样式文件 -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">

    <!-- 引入jQuery核心js文件 -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <style>
        .carousel img{
            width: 350px;
            margin: auto;
        }
        .pic{
            width: 90%;
        }
        .price{
            color:red;
            font-size: 13pt;
        }
        .bookname a{
            color:grey;
            font-size: 10pt;
        }
    </style>
</head>

<body>
<!--logo部分-->
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="${pageContext.request.contextPath}/index.action"> <img src="${pageContext.request.contextPath}/static/img/logo.png" /></a>
        </div>
        <div class="col-lg-5 col-md-4 hidden-xs col-sm-6">
            <img src="${pageContext.request.contextPath}/static/img/header.png" />
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12 text-right" style="padding-top: 30px;">
            <c:if test="${member==null}">
                <a href="${pageContext.request.contextPath}/pages/login.jsp">登录</a>&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/pages/regist.jsp">注册</a>
            </c:if>
            <c:if test="${member!=null}">
                欢迎您：<a href="#">${member.member_nikname}</a>&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/login.action">注销</a>&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/cart.action">购物车</a>&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/orderList.action">我的订单</a>
            </c:if>
        </div>
    </div>
</div>

<!--导航栏-->
<div class="container" style="margin-top: 10px;">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-book"></span></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <%--<li class="active">--%>
                    <%--<a href="#">计算机 <span class="sr-only">(current)</span></a>--%>
                    <%--</li>--%>
                    <c:forEach items="${list}" var="cat">
                        <li>
                            <a href="${pageContext.request.contextPath}/bookList.action?id=${cat.category_id}">${cat.category_name}</a>
                        </li>
                    </c:forEach>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他分类 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">宗教</a>
                            </li>
                            <li>
                                <a href="#">哲学</a>
                            </li>
                            <li>
                                <a href="#">心理学</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">法律</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">烹饪美食</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" role="search" action="select.action" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="书名/作者名/出版社" name="keyWords" value="${key}">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </div>
        </div>
    </nav>
</div>
