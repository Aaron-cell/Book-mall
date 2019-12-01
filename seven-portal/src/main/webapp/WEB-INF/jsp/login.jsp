<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
</head>
<body>
<!--背景-->
<div class="wel" id="background-3"></div>
<!--左右两边云-->
<div class="wel" id="box">
    <div class="box-1 lefp"></div>
    <div class="box-1">
        <div class="righp"></div>
    </div>
</div>
<!--荧光点点-->
<div class="wel" id="git"></div>
<!--登录注册表-->
<div class="wel" id="from">
    <div class="box-2 le-1">
            <div class="flrg">
                    <h3>登录</h3>
                 <div class="a">
                    <input type="hidden" id="redictURL" name="redictURL" value="${redictURL }" class="in-1" >
                </div>
                    
                <div class="a">
                    <!--<label>账号：</label>-->
                    <input type="text" id="username" name="username" class="in-1" placeholder="请输入账号" >
                </div>
                <div class="a">
                    <!--<label>密码：</label>-->
                    <input type="password" id="password" name="password" class="in-1" placeholder="请输入密码" >
                </div>
                <div class="a">
                    <!--<label>验证码：</label>-->
                    <input type="text" id="code" name="code" class="in-1" placeholder="请输入验证码">
                </div>
                <img src="checkCode" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">
                <div class="msg">
                </div>
                <div class="a">
                    <button  onclick="submitForm()">登录</button>
                </div>
                <div class="a">
                    <div class="hr"></div>
                </div>
                <div class="a">
                    <a href="${pageContext.request.contextPath}/register">去注册</a>
                </div>
            </div>
    </div>

</div>
<script type="text/javascript">

	function submitForm(){
		var redicturl=$(" input[ name='redictURL' ] ").val();
		var username=$(" input[ name='username' ] ").val();
		var password=$(" input[ name='password' ] ").val();
		var code=$("input[ name='code'] ").val();
		if(username ==''){
			$(".msg").html('<font size="3" color="red">请填写密码</font>');
			return;
		}else if(password ==''){
			$(".msg").html('<font size="3" color="red">请填写用户名</font>');
			return;
		}else if(code ==''){
			$(".msg").html('<font size="3" color="red">请填写验证码</font>');
			return;
		}
		$.post("/user/login",{"username": username,"password": password,"code": code}, function(_data){
			if(_data.status == 200){
				if(redicturl == ''){
					location.href = "http://localhost:8081/";
				}else{
					location.href = "http://localhost:8081"+redicturl;
				}
			}else{
				$(".msg").html('<font size="3" color="red">'+_data.msg+'</font>');
			}
		});
		
	}
</script>
<div style="text-align:center;">
<p>更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>