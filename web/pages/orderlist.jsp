<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--头部文件引入开始--%>
<jsp:include page="common/header.jsp"/>
<%--头部文件引入结束--%>
		
		<!-- 主体部分 -->
			<div class="container">
				<!-- 广告 -->
				<div class="row">
					<div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px; ">
						<img src="${pageContext.request.contextPath}/static/img/ad.jpg " style="width: 99%; "/>
					</div>
				</div>
				<!--页头-->
				<div class="page-header">
					<h1>我的订单 <small>您留下的足迹</small></h1>
				</div>
				<!--订单信息-->
				<table class="table">
					<thead>
						<tr class="active">
							<th>图片</th>
							<th>书名</th>
							<th>作者</th>
							<th>出版社</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderList}" var="orders">
						<tr>
							<td colspan="7">订单编号:${orders.order_code}</td>
						</tr>
						<tr class="warning">
							<td><img width="100px" src="${pageContext.request.contextPath}/file/book/${orders.cart.goods.goods_img}"></td>
							<td align="center">${orders.cart.goods.goods_name}</td>
							<td align="center">${orders.cart.goods.goods_author}</td>
							<td align="center">${orders.cart.goods.goods_publish}</td>
							<td align="center">&yen; <span class="price">${orders.cart.goods.goods_price}</span> 点券</td>
							<td align="center">${orders.cart.cart_goods_count}</td>
							<td align="center">&yen; <span class="price">${orders.cart.cart_goods_count*orders.cart.goods.goods_price}</span> 点券</td>
						</tr>
						<tr class="success">
							<td colspan="6" align="right">下单时间:${orders.order_add_time}</td>
							<td align="right">订单总价:&yen; <span class="price">${orders.cart.cart_goods_count*orders.cart.goods.goods_price}</span> 点券</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
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
	<script type="text/javascript">
		//删除背包项
		function delBookFromBag(bid){
			if (confirm("你真的要抛弃我吗?")) {
				location.href="${pageContext.request.contextPath}/static/bag?method=delBookFromBag&bid="+bid;
			}
		}
		//清空背包
		function clearBag(){
			if (confirm("你就不要我们了吗?")) {
				location.href="${pageContext.request.contextPath}/static/bag?method=clearBag";
			}
		}
	</script>
</html>