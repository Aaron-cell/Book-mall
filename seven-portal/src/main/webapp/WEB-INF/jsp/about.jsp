<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/main.css">
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="layui/layui.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>Insert title here</title>
<%@ include file="indexbanner.jsp"%>
</head>
<body>
<div class="content content-nav-base about-content">
  <div class="banner-box">
      <div class="banner"></div>
    </div>
    <div class="brief-content layui-clear w1200">
      <div class="img-box">
        <img src="static/img/us_img1.jpg">
        <img class="top" src="static/img/us_img2.jpg">
      </div>
      <div class="text">
        <p>我们的母婴产业2016年涉足母婴行业，以品牌经销为主，在强大市场的推动下，于2016年创立自己的独立品牌。公司立足于江西南昌，2年的品牌沉淀和运营经验让我们在行业中获得良好的口碑和市场份额。以直营+连锁加盟模式，让成功可复制，成为越来越多中小投资者的优选项目，更多的妈妈青睐我们的产品。</p>
      </div>
    </div>
    <div class="banner-text">
      <div class="w1200">
        <p>我们的母婴产业2016年涉足母婴行业，以品牌经销为主，在强大市场的推动下，于2016年创立自己的独立品牌。公司立足于江西南昌，2年的品牌沉淀和运营经验让我们在行业中获得良好的口碑和市场份额。以直营+连锁加盟模式，让成功可复制，成为越来越多中小投资者的优选项目，更多的妈妈青睐我们的产品。</p>
      </div>
    </div>
    
  </div>
<%@ include file="foot.jsp"%>
<script type="text/javascript">

layui.config({
    base: 'static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm'],function(){
      var
     mm = layui.mm;
  
    

});
</script>
</body>
</html>