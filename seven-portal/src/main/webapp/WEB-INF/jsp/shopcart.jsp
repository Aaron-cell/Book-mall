w<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>购物车</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style1.css" type="text/css" />
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			#div1{
				width:1000px;
				height: 600px;
				margin-left: auto; 
				margin-right: auto;
			}
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>

		<!-- 引用导航栏和菜单栏 -->
	<%@ include file="indexbanner.jsp"%>

<div id="div1">
		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<c:set var="total" scope="session" value="0"/>
				<!-- map属于双链集合，无法直接访问作为一个集合存在的value值（因为没法取到key），需要取cart中处理一下map -->
							<c:forEach items="${bookList }" var="book">
								 
								<tr class="active">
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${book.image}" width="70" height="60">
									</td>
									<td width="30%">
										<a target="_blank">${book.bookName}</a>
									</td>
									<td width="20%">
										￥${book.price/100}
									</td>
									<td width="10%">
										<input type="text" name="quantity" value="${book.num}" maxlength="4" size="10" readonly="readonly">
									</td>
									<td width="15%">
										<span class="subtotal">￥${book.price/100 * book.num}</span>
										<c:set var="total" scope="session" value="${total+book.price/100 * book.num }"/>
									</td>
									<td>
										<a href="/delete/cart?id=${book.id }" class="delete">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
				 商品金额: <strong style="color:#ff6600;">￥<c:out value="${total}"/>元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/deleteCart" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath}/order/show">
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('${pageContext.request.contextPath}/static/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>

		</div>
</div>
		<%@ include file = "foot.jsp" %>

	</body>

</html>