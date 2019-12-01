<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="${pageContext.request.contextPath}/static/css/shopping.css?v=1.3.5" type="text/css" rel="stylesheet" /> 
  <script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script> 
  <script src="${pageContext.request.contextPath}/static/js/shoppcart.js" type="text/javascript"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>


<body>
	<%@ include file="indexbanner.jsp"%>
		<div style="text-align:center; vertical-align:middle;">
			<form action="${pageContext.request.contextPath}/order/addAddress" id="myForm" method="post">
				移动电话:	<input type="text" id="receiverMobile" name="receiverMobile" required /><br>
				固定电话：  <input type="text" id="receiverPhone" name="receiverPhone" /><br>
				 选择地区：<br>
				 <select id='province' name="receiverState"><option id="-1">---省---</option></select><br>
				 <select id='city' name="receiverCity"><option id="-1">---市---</option></select><br>
				 <select id='county' name="receiverDistrict"><option id="-1">---区---</option></select><br>
				详细地址：<textarea name="receiverAddress" clos="20" rows="2" required></textarea><br>	
				邮政编码：<input type="text" id="receiverZip" name="receiverZip"  /><br>
				
				默认地址：
				是<input type="radio" id="flag" name="flag" value="1" checked="checked"><br>
				否<input type="radio" id="flag" name="flag" value="0" ><br>
				<input type="submit" name="添加地址">
			</form>
		</div>
  	  <%@ include file="foot.jsp"%>
</body>
<script type="text/javascript">
    
 $(function() {
     initProvinces();  
 });
    /**
     * 获取省列表
     */
    function initProvinces() {
        $('#province').empty();
        $.ajax({
            type : "POST",
            url : "/get/addr",
            success : function(_data) {
                $.each(_data.data, function(i, it) {
                    $("<option value=\"" + it.code + "\">" + it.name + "</option>").click(function() {
                            initCities(it.code);
                    }).appendTo($('#province'));
                });
            }
       });
    }
    /**
     * 获取市列表
     */
    function initCities(provinceID) {
        $('#city').empty();
        $.ajax({
            type : "POST",
            url : "/get/addr?parentId=" + provinceID,
            success : function(_data) {
                $.each(_data.data, function(i, it) {
                    $("<option value=\"" + it.code + "\">" + it.name + "</option>").click(function() {
                            initCounties(it.code);
                    }).appendTo($('#city'));
                });
            }
        });
    }
    /**
     * 获取区县列表
     */
    function initCounties(cityID) {
        $('#county').empty();
        $.ajax({
            type : "POST",
            url : "/get/addr?parentId=" + cityID,
            success : function(_data) {
                $.each(_data.data, function(i, it) {
                    $("<option value=\"" + it.code + "\">" + it.name + "</option>")
                    .appendTo($('#county'));
                });
            }
 });
}
   
//……
</script>
</html>