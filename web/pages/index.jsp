<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:forward page="${pageContext.request.contextPath}/index.action"></jsp:forward>--%>

<%-- 引入头部公共文件 --%>
<jsp:include page="common/header.jsp"></jsp:include>

<!--轮播图-->
<div class="container">
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/static/img/1.jpg" alt="...">
        <div class="carousel-caption">
          ...
        </div>
      </div>
      <div class="item">
        <img src="${pageContext.request.contextPath}/static/img/2.jpg" alt="...">
        <div class="carousel-caption">
          ...
        </div>
      </div>
      <div class="item">
        <img src="${pageContext.request.contextPath}/static/img/3.jpg" alt="...">
        <div class="carousel-caption">
          ...
        </div>
      </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!--为你推荐-->
<div class="container" style="margin-top: 20px;">
  <!--上面的文字内容-->
  <div class="row">
    <div id="" style="font-size: 20px;padding-left: 33px;font-weight: bold;">
      <span class="glyphicon glyphicon-star-empty"></span> 为您推荐<hr />
    </div>
  </div>
  <!--图片内容-->
  <div class="row">
    <div class="col-md-2 col-sm-2 hidden-sm hidden-xs" style="height: 400px;">
      <img src="${pageContext.request.contextPath}/static/img/book/l1.jpg" height="100%"/>
    </div>
    <div class="col-md-10 col-sm-10" style="padding-left: 10px;" id="forYou">
      <c:forEach items="${query1}" var="reg">
        <input type="hidden" name="goodsId" value="${reg.goods_id}">
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
          <a href="${pageContext.request.contextPath}/detail.action?id=${reg.goods_id}" class="addScan1"><img class="pic" src="${pageContext.request.contextPath}/file/${reg.goods_img}" /></a>
          <p class="price">¥ ${reg.goods_price}点券</p>
          <p class="bookname"><a href="${pageContext.request.contextPath}/detail.action?id=${reg.goods_id}" class="addScan2">${reg.goods_name}</a></p>
        </div>
      </c:forEach>
    </div>
  </div>
</div>

<!--广告图片-->
<div class="container" style="margin-top: 10px;">
  <div class="row">
    <div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px;">
      <img src="${pageContext.request.contextPath}/static/img/ad.jpg" style="width: 98%;"/>
    </div>
  </div>
</div>

<!--新书上架-->
<div class="container" style="margin-top: 20px;">
  <!--上面的文字内容-->
  <div class="row">
    <div id="" style="font-size: 20px;padding-left: 33px;font-weight: bold;">
      <span class="glyphicon glyphicon-star-empty"></span> 新书上架<hr />
    </div>
  </div>
  <!--图片内容-->
  <div class="row">
    <div class="col-md-2 col-sm-2 hidden-sm hidden-xs" style="height: 400px;">
      <img src="${pageContext.request.contextPath}/static/img/book/l2.jpg" height="100%"/>
    </div>
    <div class="col-md-10 col-sm-10" style="padding-left: 10px;" id="forYou">
      <div class="row">
        <c:forEach items="${query2}" var="newg">
          <input type="hidden" name="goodsId" value="${newg.goods_id}">
          <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="${pageContext.request.contextPath}/detail.action?id=${newg.goods_id}" class="addScan1"><img class="pic" src="${pageContext.request.contextPath}/file/${newg.goods_img}" /></a>
            <p class="price">¥ ${newg.goods_price}点券</p>
            <p class="bookname"><a href="${pageContext.request.contextPath}/detail.action?id=${newg.goods_id}" class="addScan2">${newg.goods_name}</a></p>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>

<!-- 引入底部文件 -->
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