<%--
  Created by IntelliJ IDEA.
  User: select
  Date: 2019/2/18
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 引入头部公共文件 --%>
<jsp:include page="common/header.jsp"></jsp:include>

<!--登录失败-->
<div class="container" style="height: 650px;">
    <div class="row text-center" style="margin-top: 50px;">
        <h1><img src="${pageContext.request.contextPath}/static/img/failed.jpg" /> ${msg}</h1>
    </div>
    <hr />

    <%--<div class="row">--%>
        <%--<p class="lead">不好意思,您的余额不足</p>--%>
        <%--<p>为了学习,我要<a href="#" class="btn btn-danger">去充值</a></p>--%>
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

</html>
