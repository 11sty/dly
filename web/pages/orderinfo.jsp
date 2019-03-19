
<%--
  Created by IntelliJ IDEA.
  User: 大哥
  Date: 2019/2/21
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"/>
<!-- 主体部分 -->
<div class="container">
    <!-- 广告 -->
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs "
             style="padding-left: 14px;">
            <img src="${pageContext.request.contextPath}/static/img/ad.jpg "
                 style="width: 99%;" />
        </div>
    </div>
    <!-- 订单详情的展示 -->
    <c:forEach items="${orderinfo}" var="dd" end="0">
        <h4>订单详情 <small>&nbsp;&nbsp;&nbsp;&nbsp;编号${dd.cart_order_code}:</small></h4>
    </c:forEach>
    <table class="table">
        <thead>
        <tr class="active">
            <th colspan="4">书籍</th>
            <%--<th>名称</th>
            <th>作者</th>
            <th>出版社</th>--%>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${orderinfo}" var="order" >
            <tr>
                <td><img src="${pageContext.request.contextPath}/file/book/${order.goods.goods_img}"></td>
                <td>${order.goods.goods_name}</td>
                <td>${order.goods.goods_author}</td>
                <td>${order.goods.goods_publish}</td>
                <td>${order.goods.goods_price}</td>
                <td>${order.cart_goods_count}</td>
                <td class="rowTotalPrice">${order.goods.goods_price*order.cart_goods_count}</td>
            </tr>

        </c:forEach>


        </tbody>
    </table>
    <hr />
    <h4>收货人信息</h4>
    <form method="post" action="${pageContext.request.contextPath}/pay.action">
        <div class="row">
            <div class="form-group col-sm-4">
                <label for="email" class="control-label">
                    <i class="glyphicon glyphicon-envelope"></i> 收货人邮箱
                </label>
                <input type="email" class="form-control" name="email" id="email">
            </div>
        </div>
        <div class="row" id="row">
            <div class="form-group col-sm-4">
                <label for="name" class="control-label">
                    <i class="glyphicon glyphicon-user"></i> 收货人姓名</label>
                <input type="text" class="form-control" name="name" id="name">
            </div>
        </div>


        <hr />
        <div class="row text-right" style="padding-right: 30px">
            总金额:&yen; <span class="price">88</span> 点券&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="hidden" class="toPrice" value="" name="toPrice">
            <input type="submit" class="btn btn-primary btn-lg" value="支付订单" onclick="return Cmd();">
        </div>
    </form>
</div>
<hr />

<!--页脚-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs "
             style="padding-left: 14px;">
            <img src="${pageContext.request.contextPath}/static/img/footer.jpg"
                 style="width: 98%;" />
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
        <div
                style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
            Copyright &copy; 2003-2017 国信安书城 版权所有</div>
    </div>
</div>

</body>


<script>
    // 让页面加载完成之后才去执行js代码
    $(function () {
        //总价格
        var totalPrice = 0;

        $(".rowTotalPrice").each(function () {
            totalPrice=totalPrice+parseInt($(this).text());
        });
        // 赋值到总价的位置
        $(".price").text(totalPrice);
        $(".toPrice").val(totalPrice);
    });
</script>


<script>
    function Cmd(){
        var ipt = document.getElementById("row").getElementsByTagName("input"); //查找divbox这个div里的所有文本框
        for(var i = 0; i < ipt.length; i++){ //循环
            if(ipt[i].value.length == 0){ //如果其中一个文本框没有填写
                alert("所有文本框都需要填写"); //弹出提示
                ipt[i].focus(); //定位到没有填写的文本框
                return false; //返回false
            }
        }
        return true; //都已经填写，返回true
    }
</script>

<script type="text/javascript">
    //onblur失去焦点事件，用户离开输入框时执行 JavaScript 代码：
    //函数：验证邮箱格式
    function isEmail(strEmail){
        //定义正则表达式的变量:邮箱正则
        var reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        console.log(strEmail);
        //文本框不为空，并且验证邮箱正则成功，给出正确提示
        if(strEmail != null && strEmail.search(reg) != -1)
        {
            document.getElementById("test_user").innerHTML = "<font color='green' size='4px'>√邮箱格式正确！</font>";
        }else{
            document.getElementById("test_user").innerHTML = "<font color='red' size='4px'>邮箱格式错误！</font>";
        }
    }
</script>



</html>
