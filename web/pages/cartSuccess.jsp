<%--
  Created by IntelliJ IDEA.
  User: xi
  Date: 2019/2/18
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>

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
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
        ol li{
            margin-top: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>

<body>

<!--logo部分-->
<div class="container">
    <div class="col-lg-4 col-md-4 col-sm-6">
        <img src="${pageContext.request.contextPath}/static/img/logo.png" />
    </div>
    <div class="col-lg-5 col-md-5 hidden-xs col-sm-6">

    </div>
    <div class="col-md-3 text-right" style="padding-top:30px">

    </div>
</div>

<!--注册成功-->
<div class="container" style="height: 650px;">
    <div class="row text-center" style="margin-top: 50px;">
        <h1><img src="${pageContext.request.contextPath}/static/img/success.jpg" /> ${msg}</h1>
    </div>
    <hr />
    <div class="row text-center" style="margin-top: 50px;">
        <a href="${pageContext.request.contextPath}/index.jsp">继续买</a>
        <a href="${pageContext.request.contextPath}/cart.action">查看购物车</a>
    </div>
    <hr />
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
