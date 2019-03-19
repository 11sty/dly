<%--
  Created by IntelliJ IDEA.
  User: select
  Date: 2019/2/21
  Time: 11:25
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

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
        label.error{
            background: url(img/unchecked.gif) no-repeat 10px;
            color:red;
            padding-left: 30px;
        }
        label.success{
            background: url(img/checked.gif) no-repeat 10px;
        }
    </style>
</head>

<body>

<!--logo部分-->
<div class="container">
    <div class="col-lg-4 col-md-4 col-sm-6">
        <a href="${pageContext.request.contextPath}/index.action"><img src="${pageContext.request.contextPath}/static/img/logo.png" /></a>
    </div>
    <div class="col-lg-5 col-md-5 hidden-xs col-sm-6">

    </div>
    <div class="col-md-3 text-right" style="padding-top:30px">
        <ol class="list-inline">
            <li>
                <a href="${pageContext.request.contextPath}/pages/login.jsp">已有账号,立即登录</a>
            </li>
        </ol>
    </div>
</div>

<!--主体部分-->
<div class="container" style="height: 650px;">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-7" style="background:#fff;padding:40px 50px;margin:30px;border:0px solid #ccc;">
            <font>会员注册</font>USER REGISTER
            <hr />
            <form id="regForm" class="form-horizontal" style="margin-top:5px;"
                  action="${pageContext.request.contextPath}/regist.action" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="member_nikname" id="username" placeholder="请输入用户名">
                    </div>
                    <div class="col-sm-4" style="padding: 5px 0;">
                        <label class="error" for="username"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="member_pwd" id="password" placeholder="请输入密码">
                    </div>
                    <div class="col-sm-4" style="padding: 5px 0;">
                        <label class="error" for="password"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="sure_pwd" id="confirmpwd" placeholder="请输入确认密码">
                    </div>
                    <div class="col-sm-4" style="padding: 5px 0;">
                        <label class="error" for="confirmpwd"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="member_email" id="email" placeholder="Email">
                    </div>
                    <div class="col-sm-4" style="padding: 5px 0;">
                        <label class="error" for="email"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="member_name" id="name" placeholder="请输入姓名">
                    </div>
                    <div class="col-sm-4" style="padding: 5px 0;">
                        <label class="error" for="name"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">联系电话</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="telephone" name="member_phone">
                    </div>
                    <div class="col-sm-4" style="padding: 5px 0;">
                        <label class="error" for="telephone"></label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="validateCode" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="validateCode" name="member_vericode">
                    </div>
                    <div class="col-sm-2">
                        <img id="loginform:vCode" src="${pageContext.request.contextPath}/code.action"
                             onclick="this.src='/code.action?d='+Math.random();" />
                    </div>
                </div>
                <div class="col-sm-4 col-sm-offset-2" style="color:red;padding-bottom: 15px">
                    &nbsp;
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-6">
                        <input class="btn btn-success btn-block" type="submit"  value="立即注册" />
                    </div>
                </div>
            </form>
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
