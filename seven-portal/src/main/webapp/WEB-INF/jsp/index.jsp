<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>图书商城</title>
<%@ include file="indexbanner.jsp"%>
</head>
<body id="list-cont" onLoad="img()">

	<div class="commod-cont-wrap">

		<div class="category-banner">
			<div class="w1200">
				<img id="img" src="${pageContext.request.contextPath}/static/img/img1.png" style="height:500px;width: 1200px"/>
			</div>
		</div>
	</div>


	<div class="floors">
		<div class="sk">
			<div class="sk_inner w1200">
				<div class="sk_hd">
					<a href="javascript:;"> <img src="${pageContext.request.contextPath}/static/img/s_img1.jpg">
					</a>
				</div>
				<div class="sk_bd">
					<div class="layui-carousel" id="test1">
						<div carousel-item>
							<div class="item-box">
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g01.jpg"></a>
									<div class="title">人间失格</div>
									<div class="price">
										<span>￥17.80</span>
										<del>￥25.00</del>
									</div>
								</div>
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g02.jpg"></a>
									<div class="title">白夜行</div>
									<div class="price">
										<span>￥59.6</span>
										<del>￥62.00</del>
									</div>
								</div>
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g08.jpg"></a>
									<div class="title">红星照耀中国</div>
									<div class="price">
										<span>￥29.80</span>
										<del>￥33.00</del>
									</div>
								</div>
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g04.jpg"></a>
									<div class="title">岛上书店</div>
									<div class="price">
										<span>￥49.00</span>
										<del>￥69.00</del>
									</div>
								</div>
							</div>
							<div class="item-box">
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g05.jpg"></a>
									<div class="title">从你的全世界路过</div>
									<div class="price">
										<span>￥59.30</span>
										<del>￥99.00</del>
									</div>
								</div>
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g06.jpg"></a>
									<div class="title">解忧杂货店</div>
									<div class="price">
										<span>￥49.00</span>
										<del>￥89.00</del>
									</div>
								</div>
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g07.jpg"></a>
									<div class="title">偷影子的人</div>
									<div class="price">
										<span>￥61.00</span>
										<del>￥63.52</del>
									</div>
								</div>
								<div class="item">
									<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/g09.jpg"></a>
									<div class="title">阿弥陀福,么么哒</div>
									<div class="price">
										<span>￥48.23</span>
										<del>￥52.00</del>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="hot-recommend-con">
		<div class="hot-con1 w1200 layui-clear">
			<div class="item">
				<div class="big-img">
					<a href="#product-list-box"><img src="${pageContext.request.contextPath}/static/img/hot1.png" style="height:490px;"></a>
				</div>
			</div>
			<div class="item">
				<div class="top-img">
					<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/hot5.png" style="height:246px;width: 350px"></a>
				</div>
				<div class="bottom-img">
					<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/hot6.png" style="height:220px;width: 175px"></a> <a
						class="baby-cream" href="javascript:;"><img
						src="static/img/hot7.png" style="height:220px;width: 175px"></a>
				</div>
			</div>
			<div class="item item1 margin0 padding0">
				<a href="javascript:;"><img src="${pageContext.request.contextPath}/static/img/hot8.png" style="height:242px;width: 390px"></a> <a
					href="javascript:;">
					<img class="btm-img" src="static/img/hot9.png" style="height:242px;width: 390px"></a>
			</div>
		</div>
	</div>




	<div class="product-cont w1200" id="product-cont">
		<div class="product-item product-item1 layui-clear">
			<div class="left-title">
				<h4>
					<i>1F</i>
				</h4>
				<img src="static/img/icon_gou.png">
				<h5>文学小说</h5>
			</div>
			<div class="right-cont">
				<a href="javascript:;" class="top-img">
				<img src="static/img/img12.png" style="height:150px;width: 999.6px" alt=""></a>
				<div class="img-box">
					<c:forEach var="book" items="${list0 }" >
						<!-- 点击图片跳转到商品详情（book/details） -->
						<a href="/book/details?id=${book.id }"><img src="${book.image }"></a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="product-item product-item2 layui-clear">
			<div class="left-title">
				<h4>
					<i>2F</i>
				</h4>
				<img src="static/img/icon_gou.png">
				<h5>少儿阅读</h5>
			</div>
			<div class="right-cont">
				<a href="javascript:;" class="top-img"><img
					src="static/img/img12.png" style="height:150px;width: 999.6px" alt=""></a>
				<div class="img-box">
					<c:forEach var="book1" items="${list1 }" >
						<a href="/book/details?id=${book1.id }"><img src="${book1.image }"></a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="product-item product-item3 layui-clear">
			<div class="left-title">
				<h4>
					<i>3F</i>
				</h4>
				<img src="static/img/icon_gou.png">
				<h5>励志与成功</h5>
			</div>
			<div class="right-cont">
				<a href="javascript:;" class="top-img"><img
					src="static/img/img12.png" style="height:150px;width: 999.6px" alt=""></a>
				<div class="img-box">
					<c:forEach var="book2" items="${list2 }" >
						<a href="/book/details?id=${book2.id }"><img src="${book2.image }" ></a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<div class="product-list-box" id="product-list-box">
		<div class="product-list-cont w1200">
			<h4>更多推荐</h4>
			<div class="product-item-box layui-clear">
			<c:forEach var="book3" items="${list3 }" >
					<div class="list-item">
						<a href="/book/details?id=${book3.id }"><img src="${book3.image }" height="180" width="150"></a>
						<p>${book3.bookName }</p>
						<span>￥${book3.price/100 }</span>
					</div>
			</c:forEach>
			</div>
		</div>
	</div>
	<%@ include file="foot.jsp"%>
	<script type="text/javascript">
    
	
	//layui框架的初始化
layui.config({
    base: '${pageContext.request.contextPath}/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','carousel','laypage','jquery'],function(){
	  var laypage = layui.laypage,$ = layui.$
      var carousel = layui.carousel,
     mm = layui.mm;
     var option = {
        elem: '#test1'
        ,width: '100%' //设置容器宽度
        ,arrow: 'always'
        ,height:'298' 
        ,indicator:'none'
      }
      carousel.render(option);
     

});

 
  </script>
	<script type="text/javascript">
  var arr=new Array();
arr[0]="${pageContext.request.contextPath}/static/img/img1.png";    //这里放图片路径
arr[1]="${pageContext.request.contextPath}/static/img/img2.png";
arr[2]="${pageContext.request.contextPath}/static/img/img3.png";
 
var i=0;
function img()
{
var ima=document.getElementById("img");
ima.src=arr[i];
i++;
if(i==3)
   i=0
setTimeout("img()",2000) //一秒钟调用一次
}
</script>
</body>
</html>