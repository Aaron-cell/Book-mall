<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>用户注册</title>
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
<div class="wel" id="from">
    <div class="box-2 le-2">
            <div class="flrg-1">
                <h3>注册</h3>
                <div class="a" >
                    <input type="text" name="username" id="username" class="in-1" placeholder="您的用户名" onchange="checkusername()">
                    <div class="checkusername"></div>
                </div>
                <div class="a" >
                    <input type="text" name="nickname" id="nickname" class="in-1" placeholder="您的用户昵称" onchange="checknickname()">
                	<div class="checknickname"></div>
                </div>
                <div class="a">
                    <input type="password" name="password" id="password" class="in-1" placeholder="输入密码">
                </div>
                <div class="a">
                    <input type="password" name="repassword" id="repassword" class="in-1" placeholder="再次确认密码">
                </div>
                <div class="a">
                    <input type="text" name="phone" id="phone" class="in-1" placeholder="输入手机号码">
                </div>
                <div class="a">
                    <input type="email" name="email" id="email" class="in-1" placeholder="输入邮箱地址" onchange="isEmail()">
    				<div class="checkemail"></div>            
                </div>
                <div class="msg">
                </div>
                <div class="a">
                    <button onclick="submitForm()">注册</button>
                </div>
                <div class="a">
                    <a href="${pageContext.request.contextPath}/login">去登录</a>
                </div>
            </div>
    </div>
</div>
<script type="text/javascript">
	/*验证用户名  */
	function checkusername(){		
		var username=$(" input[ name='username' ] ").val();
		$.post("/check/username",{"username" : username},function(_data){
			if(_data.status ==200 ){
				$(".checkusername").html('<font size="2" color="blue">用户名可用</font>');
			}else{
				$("#username").val("");
				$(".checkusername").html('<font size="2" color="red">用户名已被占用</font>');
			}
		});
	}
	/* 验证用户昵称 */
	function checknickname(){
		var nickname=$(" input[ name='nickname' ] ").val();
		$.post("/check/nickname",{"nickname" : nickname},function(_data){
			if(_data.status ==200 ){
				$(".checknickname").html('<font size="2" color="blue">用户昵称可用</font>');
			}else{
				$("#nickname").val("");
				$(".checknickname").html('<font size="2" color="red">用户昵称已被占用</font>');
			}
		});
	}
	
	
	/*正则表单式 验证邮箱合法性  */
	function isEmail() {
		var email=$(" input[ name='email' ] ").val();
	    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    if (filter.test(email)) {
	    	$(".checkemail").html('<font size="2" color="blue">电子邮箱合法</font>'); 
	    } else {
	    	$("#email").val("");
	    	$(".checkemail").html('<font size="2" color="red">电子邮箱不合法</font>'); 
	    } 
	}
	function submitForm(){
		var password=$(" input[ name='password' ] ").val();
		var repassword=$(" input[ name='repassword' ] ").val();
		var phone=$(" input[ name='phone' ] ").val();
		var email=$(" input[ name='email' ] ").val();
		var nickname=$(" input[ name='nickname' ] ").val();
		var username=$(" input[ name='username' ] ").val();
		
		if(username ==''){
			$(".msg").html('<font size="3" color="red">请将信息填写完整</font>');
			return;
		}else if(password ==''){
			$(".msg").html('<font size="3" color="red">请将信息填写完整</font>');
			return;
		}else if(nickname ==''){
			$(".msg").html('<font size="3" color="red">请将信息填写完整</font>');
			return;
		}else if(repassword ==''){
			$(".msg").html('<font size="3" color="red">请将信息填写完整</font>');
			return;
		}else if(password != repassword){
			$(".msg").html('<font size="3" color="red">两次密码不一致</font>');
			return;
		}else if(phone ==''){
			$(".msg").html('<font size="3" color="red">请将信息填写完整</font>');
			return;
		}else if(email ==''){
			$(".msg").html('<font size="3" color="red">请将信息填写完整</font>');
			return;
		}
		
		$.post("/user/register",{"username": username,"password": password,"nickname" : nickname,"phone" : phone,"email" : email}, function(_data){
			if(_data.status == 200){
				alert("注册成功！请邮箱激活登录");
				location.href = "http://localhost:8081/login";
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