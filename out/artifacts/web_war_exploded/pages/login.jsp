<%--
  Created by IntelliJ IDEA.
  User: select
  Date: 2019/2/18
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
 float:left; */
        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
    </style>
</head>
<%
    String username = "";
    //获取当前站点的所有Cookie
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
        if ("member_nikname".equals(cookies[i].getName())) {
            username = cookies[i].getValue();
        }
    }
%>
<body>

<!--logo部分-->
<div class="container">
    <div class="col-lg-4 col-md-4 col-sm-6">
        <a href="${pageContext.request.contextPath}/index.action"><img src="${pageContext.request.contextPath}/static/img/logo.png"/></a>
    </div>
    <div class="col-lg-5 col-md-5 hidden-xs col-sm-6">

    </div>
    <div class="col-md-3 text-right" style="padding-top:30px">
        <ol class="list-inline">
            <li>
                <a href="${pageContext.request.contextPath}/pages/regist.jsp">没有帐号? 注册</a>
            </li>
        </ol>
    </div>
</div>

<!--主体部分-->
<div class="container"
     style="height:650px;background:url('${pageContext.request.contextPath}/static/img/login_bg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-8">
            <!--<img src="${pageContext.request.contextPath}/static/image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
        </div>

        <div class="col-md-4">
            <div style="width:100%;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
                <font>会员登录</font>USER LOGIN

                <hr/>
                <form class="form-horizontal" action="${pageContext.request.contextPath}/login.action" method="post">

                    <div class="form-group">
                        <div class="col-sm-11 input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" class="form-control" name="member_nikname" value="<%=username%>" id="username"
                                   placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-11 input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" name="member_pwd" id="password"
                                   placeholder="请输入密码">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <div class="checkbox">
                                &nbsp;<label>
                                <input type="checkbox" name="autoLogin" value="autoLogin" checked="checked"> 自动登录
                            </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>
                                    <input type="checkbox" name="remember" value="yes" checked="checked"> 记住用户名
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-11">
                            <input type="submit" class="btn btn-block btn-danger" width="100" value="登录" name="submit">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<hr/>

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