<%--
  Created by IntelliJ IDEA.
  User: select
  Date: 2019/2/18
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 引入头部公共文件 --%>
<jsp:include page="common/header.jsp"></jsp:include>

<!--注册成功-->
<div class="container" style="height: 650px;">
    <div class="row text-center" style="margin-top: 50px;">
        <h1><img src="${pageContext.request.contextPath}/static/img/success.jpg" /> ${msg}</h1>
    </div>
    <%--<hr />--%>

    <%--<div class="row">--%>
        <%--<p class="lead">确认邮件已发送至您的邮箱12345@qq.com,点击邮箱中的链接就可以正常使用了.</p>--%>
        <%--<ul>--%>
            <%--<li><a href="">网易163邮箱</a></li>--%>
            <%--<li><a href="">网易126邮箱</a></li>--%>
            <%--<li><a href="">网易yeah.net邮箱</a></li>--%>
            <%--<li><a href="">搜狐sohu邮箱</a></li>--%>
            <%--<li><a href="">qq邮箱</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--<hr />--%>
    <%--<div class="row">--%>
        <%--<h4>还没有收到邮件?</h4>--%>
        <%--<ol>--%>
            <%--<li>稍等片刻,从新检查你的邮箱(由于网络延迟,请耐心等待1-3分钟)</li>--%>
            <%--<li>您可以尝试在广告邮件中查找</li>--%>
            <%--<li>也可以选则<a class="btn btn-primary">重新发送邮件</a></li>--%>
            <%--<li>如果注册邮箱地址填错,您需要<a class="btn btn-primary">重新注册</a></li>--%>
        <%--</ol>--%>
    <%--</div>--%>
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
<script>

    // 3秒之后自动跳转到 首页
    setTimeout(function () {
        // 直接跳转
        window.location.href = "${pageContext.request.contextPath}/index.action";
    },2000);



</script>
</html>
