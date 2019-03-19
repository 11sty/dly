<%--
  Created by IntelliJ IDEA.
  User: xi
  Date: 2019/2/21
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 引入头部公共文件 --%>
<jsp:include page="common/header.jsp"></jsp:include>

<!-- 主体部分 -->
<div class="container">
    <!-- 广告 -->
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px; ">
            <img src="${pageContext.request.contextPath}/static/img/ad.jpg " style="width: 99%; "/>
        </div>
    </div>
    <!--主体信息-->
    <table class="table">
        <thead>
        <tr class="active">
            <th colspan="4">书籍</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="bagItems">
            <c:forEach items="${carts}" var="cart">
                <tr>
                    <<input type="hidden" name="cartId" value="${cart.cart_id}">
                    <td><img src="${pageContext.request.contextPath}/file/book/${cart.goods.goods_img}" width="150px"></td>
                    <td>${cart.goods.goods_name}</td>
                    <td>${cart.goods.goods_author}</td>
                    <td>${cart.goods.goods_publish}</td>
                    <td>${cart.goods.goods_price}<input type="hidden" name="goodsPrice" value="${cart.goods.goods_price}"></td>
                    <td><input type="number" class="goodsCount" value="${cart.cart_goods_count}" min="1" style="width: 50px;"/></td>
                    <td class="rowTotalPrice">${cart.goods.goods_price*cart.cart_goods_count}</td>
                    <td><a href="${pageContext.request.contextPath}/delCart.action?id=${cart.cart_id}">删除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-right">商品总金额:&yen; <span class="price">88</span> 点券</div>
    <div class="row text-right" style="padding-right: 20px;margin-top: 10px;">
        <a href="${pageContext.request.contextPath}/delAllCart.action" style="margin-right: 10px;">清空我的书包</a>
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/orderinfo.action">去结算</a>
    </div>
</div>

<!-- 引入底部文件 -->
<jsp:include page="common/footer.jsp"></jsp:include>

<script>
    //让页面加载完成之后采取执行js代码
    $(function () {
        var totalPrice=0;
        $(".rowTotalPrice").each(function () {
            totalPrice=totalPrice+parseInt($(this).text());
        })
        //赋值到总价的位置
        $(".price").text(totalPrice);

        //数量变化是，小计及总计变化
        $(".goodsCount").each(function (i) {
            $(this).change(function () {
                totalPrice=0;
                $(".rowTotalPrice").each(function (j) {
                    if(i==j){
                        $("input[name='goodsPrice']").each(function (m) {
                            if(i==m){
                                $(".rowTotalPrice").eq(i).text(parseInt($("input[name='goodsPrice']").eq(i).val())*parseInt($(".goodsCount").eq(i).val()));
                            }
                        })
                    }
                    totalPrice=totalPrice+parseInt($(".rowTotalPrice").eq(j).text());
                });
                $(".price").text(totalPrice);
            })
        });
        
        //Ajax传值更新购物车数据表
        var cartGoodsCount;
        var postCartId;
        $(".goodsCount").each(function (i) {
            $(this).change(function () {
                cartGoodsCount=$(this).val();
                $("input[name='cartId']").each(function (j) {
                    if(i==j){
                        postCartId=$("input[name='cartId']").eq(i).val();
                    }
                })
            })
        })
        $(".goodsCount").click(function () {
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/UpdateCartCount.action",
                data:"count="+cartGoodsCount+"&cartId="+postCartId,
            })
            <%--$.post("${pageContext.request.contextPath}/UpdateCartCount.action",{count:cartGoodsCount,cartId:postCartId});--%>
        })
    });
</script>

</body>

</html>
