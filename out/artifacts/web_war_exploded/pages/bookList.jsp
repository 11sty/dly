<%--
  Created by IntelliJ IDEA.
  User: xi
  Date: 2019/2/17
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 引入头部公共文件 --%>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <c:forEach items="${pageUtil.content}" var="book">
            <input type="hidden" name="goodsId" value="${book.goods_id}">
            <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                <a href="${pageContext.request.contextPath}/detail.action?id=${book.goods_id}"  class="addScan1"><img class="pic" src="${pageContext.request.contextPath}/file/book/${book.goods_img}" /></a>
                <p class="price">¥ ${book.goods_price}点券</p>
                <p class="bookname"><a href="${pageContext.request.contextPath}/detail.action?id=${book.goods_id}" class="addScan2">${book.goods_name}</a></p>
            </div>
        </c:forEach>
    </div>
</div>

<!------------  分页开始 ------------>
<div class="container">
    <div class="row text-center" style="margin: 50px auto">
        <ul class="pagination" style="text-align:center; margin-top:10px;">
            <li class="${pageUtil.nowPage==1?"disabled":""}">
                <a href="${pageContext.request.contextPath}/bookList.action?id=${param.get("id")}&page=${pageUtil.prevPage}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
            </li>
            <c:forEach items="${pageUtil.pagesList}" var="p">
                <li class="${pageUtil.nowPage==p?"active":""}">
                    <a href="${pageContext.request.contextPath}/bookList.action?id=${param.get("id")}&page=${p}">${p}</a>
                </li>
            </c:forEach>
            <li class="${pageUtil.nowPage==pageUtil.totalPages?"disabled":""}">
                <a href="${pageContext.request.contextPath}/bookList.action?id=${param.get("id")}&page=${pageUtil.nextPage}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--------------- 分页结束 --------------->

<!--商品浏览记录-->
<!-- <div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

    <h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
    <div style="width: 50%;float: right;text-align: right;">
        <a href="">more</a>
    </div>
    <div style="clear: both;"></div>

    <div style="overflow: hidden;">

        <ul style="list-style: none;">
            <li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
                <img src="products/1/cs10001.jpg" width="130px" height="130px" />
                <p>
            </li>
        </ul>
    </div>
</div> -->
<div class="container">
    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a style="color:green">浏览记录</a></li>
        </ul>
    </div>
    <div class="row" style="border: 1px solid #ddd;padding:30px ">
        <c:forEach items="${scanList}" var="sc">
            <input type="hidden" name="goodsId" value="${sc.goods_id}">
            <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                <a href="${pageContext.request.contextPath}/detail.action?id=${sc.goods_id}" class="addScan1"><img class="history_pic" src="${pageContext.request.contextPath}/file/book/${sc.goods_img}" width="150" /></a>
                <p class="price">¥ ${sc.goods_price}点券</p>
                <p class="bookname"><a href="${pageContext.request.contextPath}/detail.action?id=${sc.goods_id}" class="addScan2">${sc.goods_name}</a></p>
            </div>
        </c:forEach>
    </div>
</div>

<%-- 引入底部文件 --%>
<jsp:include page="common/footer.jsp"></jsp:include>

<script>
    $(function(){
        var goodsId;
        var index;
        $(".addScan1").click(function () {
            index=$(".addScan1").index(this);
            $("input[name='goodsId']").each(function (i) {
                if(i==index){
                    goodsId=$("input[name='goodsId']").eq(i).val();
                }
            });
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/addScan.action",
                data:"goodsId="+goodsId,
            });
        })
        $(".addScan2").click(function () {
            index=$(".addScan2").index(this);
            $("input[name='goodsId']").each(function (i) {
                if(i==index){
                    goodsId=$("input[name='goodsId']").eq(i).val();
                }
            });
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/addScan.action",
                data:"goodsId="+goodsId,
            });
        })
    })
</script>

</body>

</html>
