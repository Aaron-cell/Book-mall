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
	  <div class="shop_cort"> 
      <!--左边--> 
      <div class="shop_cort-left fl" style="padding-left: 300px;"> 
       <h3>收货人信息</h3> 
       <!--填写地址信息--> 
       <div class="shop_cort-adress"> 
        <!--地址--> 
        <form action="/order/balance" method="post">
        <c:if test="${num == 0 }">
        	<font size="4" color="black">无可用地址--></font><a href="/order/add/address"> <font size="4" color="blue">[请添加新的地址]</font></a>	
        </c:if>
        <c:if test="${num >= 0 }">
        	<c:forEach var="address" items="${AddressList }">
        		<div class="shop_adress-top"> 
		         <input type="radio" checked="checked" name="address" value="${address.id }" />
		         <label>${address.receiverState }${address.receiverCity }${address.receiverDistrict }${address.receiverAddress }</label>
		         <label> &nbsp;&nbsp;${address.nickname }(收) ${address.receiverMobile } </label>
		         <span>默认地址</span>
		         <a href="javascript:deleteAddress(${address.id });">删除</a> 
		        </div>
        	</c:forEach>
        	
        </c:if>  
        <font size="5" color="red">${msg }</font>
        <!--地址end--> 
        <!--新加地址end--> 
        <div class="shop_adress-qr"> 
         <div class="shop_adressqr-top"> 
          <a class="fr" href="/showCart">返回修改购物车&gt;&gt;</a> 
          <span>确认订单信息</span> 
          <i>提示：专属订制产品，需要相关证书认证时间。建议尽快提交。</i> 
         </div> 
         <!--订单--> 
         <table cellspacing="0" cellpadding="0" border="0" class="shop_adressqr-of"> 
          <tbody>
           <tr class="shop_adressqr-first"> 
            <td class="shop_adress-shoop">图片</td> 
            <td class="shop_adress-cz">图书</td> 
            <td class="shop_adress-sc">作者</td> 
            <td class="shop_adress-kz">数量</td> 
            <td class="shop_adress-pirce">价格</td> 
           </tr> 
           <c:set var="total" scope="session" value="0"/>
           <c:set var="number" scope="session" value="0"/>
           <c:forEach var="item" items="${bookList }" >
	           	<tr class="shop_adressqr-sec"> 
		            <td class="shop_adress-shoop"><img alt="${item.bookName }" src="${item.image }" height="70px" width="50px"></td> 
		            <td class="shop_adress-cz">${item.bookName }</td> 
		            <td class="shop_adress-sc">${item.author }</td> 
		            <td class="shop_adress-kz">${item.num }</td> 
		            <c:set var="number" scope="session" value="${number+item.num }"/> 
		            <td class="shop_adress-pirce"><span style="font-family:微软雅黑">￥${item.price/100 }</span></td>
		            <c:set var="total" scope="session" value="${total+item.price/100 * item.num }"/> 
	           </tr> 
           </c:forEach>
           
          </tbody>
         </table> 
         <!--订单end--> 
         <!--总计--> 
         <div class="shop_adress-zj"> 
          <div class="fl"> 
           <span>总计</span> 
          </div> 
          <div class="fr"> 
           <i><c:out value="${number}"/></i> 
           <span>件商品</span> 
           <span>应付金额：</span> 
           <i style="font-family:微软雅黑" class="fw_bold">￥<c:out value="${total}"/> 元</i> 
          </div> 
         </div> 
         <!--总计--> 
         <!--最后一块--> 
         <div class="shop_adress-last"> 
          
          <div  class="shop_adress-tjdd fr"> 
           <div class="bt1 fr">
             <button class="layui-btn" style="width: 160px;
    height: 50px;font-size: 19px;line-height: 50px;background: #ff5500;" >结算</button>
           </div> 
           </form>
          </div> 
         </div> 
         <!--最后一块end--> 
        </div> 
       </div> 
       <!--填写地址信息end--> 
      </div> 
	   </div> 
	 
	 
	<%@ include file="foot.jsp"%>
	     
     <script type="text/javascript">
        function addressItemSelected(control) {
            $(control).addClass("check_bk").siblings().removeClass("check_bk");
            //设置为选中状态
            $(control).find("input:radio").attr("checked", true);
        }
        //市数据加载事件
        
       /*  var CityDataLoadEvent = function () { };
        var DistrictDataLoadEvent = function () { }; */

        $(function () {
      

            //省下拉框ID
            var province = "#province";
            var city = "#city";
            var district = "#district";
   
     
       

            //保存地址按钮事件
            $(".save").click(function () {
                var data = getData();
                if (data.name == "") {
                    alert("收货人不能为空。");
                    return;
                }
                if (data.province == "") {
                    alert("省份不能为空。");
                    return;
                }
                if (data.city == "") {
                    alert("城市不能为空。");
                    return;
                }
                if (data.district == "") {
                    alert("区县不能为空。");
                    return;
                }
                if (data.street == "") {
                    alert("详细地址不能为空。");
                    return;
                }
                if (data.postcode == "") {
                    alert("邮编不能为空。");
                    return;
                }
                if (data.mobile == "" && data.telephone == "") {
                    alert("手机号/固定电话必填一个。");
                    return;
                }
                var action = "save";
                if (isNaN(data.ID)) {
                    action = "add";
                }
            });
        });

    
 

 
		
   
        function deleteAddress(id) {
            if (confirm("确认是否删除？")) {
            	$.post("/delete/Address",{"id" : id},function(_data){
            		if(_data.status == 200){	
            			location.href = "http://localhost:8081"+_data.msg;
            		}
            	});
            }
        }

      
        $(function () {
            $("#aspnetForm").attr("action", "cart_order_success.html");
        });

      
    </script> 
</body>
</html>