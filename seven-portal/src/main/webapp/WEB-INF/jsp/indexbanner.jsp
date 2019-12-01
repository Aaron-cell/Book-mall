<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body id="list-cont">
  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="/">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login">
        	<c:if test="${sessionScope.nickname != null}">
		        ${sessionScope.nickname},欢迎您! &nbsp; &nbsp; <a href="/user/logout">[注销]</a>&nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="/order/add/address">[添加地址]</a>
        	</c:if>
        	<c:if test="${sessionScope.nickname == null}">
		        <a href="/login">登录</a>
        	</c:if>
        </div>
        <div class="sp-cart"><a href="/showCart">购物车</a><span>2</span></div>
        <div class="login">
        	<c:if test="${sessionScope.nickname != null}">
		        <a href="/userupdate">&nbsp&nbsp&nbsp&nbsp修改个人信息</a>
        	</c:if>
        	<c:if test="${sessionScope.nickname == null}">
        	</c:if>
        </div>
      </div>
    </div>
  </div>


  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="/" title="蔦屋书城">
             <a href="/" title="首页" alt="首页"><img src="${pageContext.request.contextPath}/static/img/logo1.png"></a>
          </a>
        </h1>
        <div class="mallSearch">
          <form action="/search/book" class="layui-form" method="get" novalidate>
            <input type="text" name="q" id="q" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
 <div class="content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
       
        </div>
      </div>
    </div>
</body>
</html>