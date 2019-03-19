<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<c:if test="${member==null}">--%>
	<%--<script>--%>
		<%--window.location.href="${pageContext.request.contextPath}/pages/login.jsp";--%>
	<%--</script>--%>
<%--</c:if>--%>

<%-- 引入头部公共文件 --%>
<jsp:include page="common/header.jsp"></jsp:include>

		<!-- 主体部分 -->
		<!--书籍详情-->
		<div id="" class="container" style="margin-top: 30px;">
			<div class="col-lg-4 col-md-4" style="margin-left: -30px;">
				<div id="" class="col-md-12">
					<img src="${pageContext.request.contextPath}/file/${detail.goods_img}" style=";border: 1.5px solid darkgray;" />
				</div>
			</div>
			<div id="" class="col-lg-8 col-md-8" style="margin-left: 30px;">
				<div id="" class="row">
					<p style="font-family: 'arial black' ;font-size: 23px;">${detail.goods_name}</p>
					<p style="color: gray;">${detail.goods_desc}</p>
				</div>
				<div id="" class="row" style="background: #F5F5F5;padding: 10px;">
					<div id="" class="row" style="padding: 5px;">
						<div id="" class="col-lg-5 col-md-5 col-sm-5">
							<span style="font-size:14px;">售&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价:</span>
							<span style="color: red;font-size: 12px;">￥</span>
							<span style="color: red;font-size: 23px;">${detail.goods_price}</span>
						</div>
						<div id="" class="col-lg-7 col-md-7 col-sm-7">
							<span style="font-size:14px;tex: center;line-height: 33px;">100</span><span style="font-size:14px;line-height: 33px;">人评论</span> &nbsp;&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-star" style="font-size: 13px;color: #FEBC05;"></span>
							<span class="glyphicon glyphicon-star" style="font-size: 13px;color: #FEBC05;"></span>
							<span class="glyphicon glyphicon-star" style="font-size: 13px;color: #FEBC05;"></span>
							<span class="glyphicon glyphicon-star" style="font-size: 13px;color: #FEBC05;"></span>
							<span class="glyphicon glyphicon-star" style="font-size: 13px;color: #FEBC05;"></span>
						</div>
					</div>
					<div id="lal" class="row" style="padding: 5px;">
						<div id="" class="col-lg-5 col-md-5 col-sm-5">
							<span style="font-size:14px;">纸质售价:</span>
							<span style="color: black;font-size: 12px;">￥</span>
							<span style="font-size: 14px;">${detail.goods_price}</span>
							<a href="#" style="padding-left: 5px;font-size: 14px;">购买纸书</a>
						</div>
					</div>
				</div>
				<div id="bookinfo" class="row">
					<div id="" class="row">
						<span style="font-size:14px;">作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者:</span>
						<a style="font-size:14px;">${detail.goods_author}</a>
					</div>
					<div id="" class="row">
						<span style="font-size:14px;">出&nbsp;&nbsp;版&nbsp;社:</span>
						<a style="font-size:14px;">${detail.goods_publish}</a>
					</div>
					<div id="" class="row">
						<span style="font-size:14px;">出版时间:</span>
						<span style="font-size:14px;">${detail.goods_publish_time}</span>
					</div>
					<div id="" class="row">
						<span style="font-size:14px;">字&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</span>
						<span style="font-size:14px;">${detail.goods_words}万</span>
					</div>
					<div id="" class="row">
						<span style="font-size:14px;">所属分类:</span>
						<a style="font-size:14px;">${detail.category.category_name}</a>
					</div>
				</div>
				<div id="bookbuy" class="row">
					<div id="" class="col-lg-2 col-md-2 col-sm-2">
						<form method="post" action="${pageContext.request.contextPath}/cart.action">
							<input type="hidden" name="goods_id" value="${detail.goods_id}">
							<button href="#" class="btn btn-success">加入购物车</button>
						</form>
					</div>
					<div id="" class="col-lg-2 col-md-2 col-sm-2">
						<a href="#" class="btn btn-danger">立即购买</a>
					</div>
					<div id="" class="col-lg-2 col-md-2 col-sm-2">
						<a href="#content" class="btn btn-default">试&nbsp;&nbsp;读</a>
					</div>
				</div>
				<div id="" style="padding-top: 10px;">
					<hr style="border:1px dotted;" />
				</div>
				<div id="">
					<div id="" class="col-lg-2 col-md-2 col-sm-2" style="margin-left: -10px;margin-top:15px;font-size: 14px;">
						<span id="">支持设备:</span>
					</div>
					<div id="de" class="col-lg-9 col-md-9 col-sm-9" style="margin-left: -30px;">
						<div id="" class="col-lg-2 col-md-2 col-sm-2">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/iPad.png" />
								<br />
								<span style="margin-left: -5px;font-size: 13px;">iPad</span></a>
						</div>
						<div id="" class="col-lg-2 col-md-2 col-sm-2">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/line_pc.png" />
								<br />
								<span style="margin-left: -12px;font-size: 13px;">PC在线</span></a>
						</div>
						<div id="" class="col-lg-2 col-md-2 col-sm-2">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/touch_screen.png" />
								<br />
								<span style="margin-left: -12px;font-size: 13px;">触屏版</span></a>
						</div>
						<div id="" class="col-lg-2 col-md-2 col-sm-2">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/reader.png" />
								<br />
								<span style="margin-left: -17px;font-size: 13px;">当当阅读</span></a>
						</div>
						<div id="" class="col-lg-2 col-md-2 col-sm-2">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/andriod.png" />
								<br />
								<span style="margin-left: -10px;font-size: 13px;"> android </span></a>
						</div>
						<div id="" class="col-lg-2 col-md-2 col-sm-2">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/iphone.png" />
								<br />
								<span style="margin-left: -10px;font-size: 13px;">iphone</span></a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!--目录-->
		<div class="container" style="margin-top: 40px;">
			<div>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active">
						<a href="#intro">图书简介</a>
					</li>
					<li role="presentation">
						<a href="#content">目录</a>
					</li>
				</ul>
			</div>
			<div style="height: 20px;"></div>
			<div id="intro">
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					简单点说话的方式简单点,递进的情绪请省略,你又不是个演员 别设计那些情节,
					没意见我只想看看你怎么圆 你难过的太表面 像没天赋的演员,观众一眼能看见 
				</p>
			</div>
			<div style="height: 20px;"></div>
		</div>


<!-- 引入底部文件 -->
<jsp:include page="common/footer.jsp"></jsp:include>

	</body>

</html>