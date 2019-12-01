<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>商品详情</title>
</head>
<body>
<%@ include file="indexbanner.jsp"%>
  <div class="content content-nav-base datails-content">
 <div class="data-cont-wrap w1200">
      <div class="crumb">
        <a href="/">首页</a>
        <span>></span>
        <a href="javascript:;">所有商品</a>
        <span>></span>
        <a href="javascript:;">产品详情</a>
      </div>
      <div class="product-intro layui-clear">
      	<input type="hidden" name="bookId" value="${book.id }"/>
        <div class="preview-wrap">
          <a href="javascript:;"><img src="${book.image }"height="300" width="250"></a>
        </div>
        <div class="itemInfo-wrap">
          <div class="itemInfo">
            <div class="title">
              <h4><font size="5" color="red">${book.bookName }</font> </h4>
              <h4><font size="4" color="black">${book.sellPoint}</font> </h4>
            </div>
            <div class="summary">
            <p class="activity"><span>类目</span><strong >${book.book_cat }</strong></p>
            <p class="activity"><span>作者</span><strong >${book.author }</strong></p>
              <p class="activity"><span>售价</span><strong class="price"><i>￥</i>${book.price/100 }</strong></p>
              <!-- <p class="address-box"><span>送&nbsp;&nbsp;&nbsp;&nbsp;至</span><strong class="address">江西&nbsp;&nbsp;南昌&nbsp;&nbsp;东湖区</strong></p> -->
            </div>
            <div class="choose-attrs">
              <div class="color layui-clear"><span class="title">状&nbsp;&nbsp;&nbsp;&nbsp;态</span> <div class="color-cont"><span class="btn">
              		<c:if test="${book.status == 1 }">
              			上架中
              		</c:if>
              		<c:if test="${book.status == 2 }">
              			已下架
              		</c:if>
              	</span> 
              	</div>
              	<br>
              	 <div class="color layui-clear"><span class="title">剩余数量</span> <font size="3" color="black">${book.num }</font></div>
      
              </div>
              <div class="number layui-clear" ><span class="title">购买数量</span><div class="number-cont"><span class="cut btn">-</span><input onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="text" name="num" value="1"><span class="add btn">+</span></div></div>
            </div>
            <div class="choose-btns">
              <button class="layui-btn layui-btn-primary purchase-btn">立刻购买</button>
              <button class="layui-btn  layui-btn-danger car-btn" onclick="submitForm()"><i class="layui-icon layui-icon-cart-simple"></i>加入购物车</button>  
            </div>
            
          </div>
          
        </div>
        <div class="detail">
        	<h4>图书详情</h4>
             	<h5><font size="3" color="red">${book.bookDesc }</font></h5>
             </div>
      </div>
     <div class="product-list-box" id="product-list-box">
		<div class="product-list-cont w1200">
			<h4>更多推荐</h4>
			<div class="product-item-box layui-clear">
				<c:forEach var="book" items="${list }" >
					<div class="list-item">
						<a href="/book/details?id=${book.id }"><img src="${book.image }" height="180" width="150"></a>
						<p>${book.bookName }</p>
						<span>￥${book.price/100 }</span>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
    </div>
  </div>
  <%@ include file="foot.jsp"%>
  
<script type="text/javascript">
  layui.config({
    base: '${pageContext.request.contextPath}/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery'],function(){
      var mm = layui.mm,$ = layui.$;
      var cur = $('.number-cont input').val();
      $('.number-cont .btn').on('click',function(){
        if($(this).hasClass('add')){
          cur++;
         
        }else{
          if(cur > 1){
            cur--;
          }  
        }
        $('.number-cont input').val(cur)
      })
      
  });
  
  function submitForm(){
	  var number=$(" input[ name='num' ] ").val();
	  var bookId=$(" input[ name='bookId' ] ").val();
	  $.post("/add/cart",{"number": number,"id": bookId},function(data){
		  if(data.status == 200){
				alert("商品添加成功");
			}else if(data.status == 403){
				alert(data.msg);
			}
	  });
  };
</script>



</body>
</html>