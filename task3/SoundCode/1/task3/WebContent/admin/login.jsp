<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
body, div, ul, li, p, a, h3, label, input {
	margin: 0px;
	padding: 0px;
}

body {
	background-color: #F79154;
}

#formlogin {
	margin-left: auto;
	margin-right: auto;
}

#formlogin {
	background-color: white;
	width: 300px;
	padding: 10px;
	font-family: 微软雅黑;
	font-size: 1.1em;
	color: black;
	text-align: center;
}

#formlogin div label {
	width: 70px;
	display: inline-block;
	text-align: center;
	vertical-align: middle;
	display: inline-block;
	text-align: center;
	vertical-align: middle;
}

#formlogin div.item {
	margin-top: 10px;
}

#formlogin div input {
	font-family: 微软雅黑;
	font-size: 15px;
	width: 200px;
	line-height: 30px;
	height: 30px;
	font-size: 15px;
}

#formlogin  a {
	width: 280px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	vertical-align: middle;
	color: white;
	text-decoration: none;
	display: inline-block;
	background-color: red;
}

#formlogin  a:HOVER {
	background-color: rgb(249, 94, 94);
}
</style>

<script type="text/javascript">
	//检查用户名
	function uidCheck() {
		var uid = document.getElementById("userName"); //获取DOM对象
		var errors = document.getElementById("errors");
		if (uid.value.trim() == "" || uid == null) {
			errors.innerText = "用户名不能为空！";
			return false;
		} else {
			errors.innerText = "";
			return true;
		}
	}

	//检查密码
	function pwdCheck() {
		var pwd = document.getElementById("passWord");//获取DOM对象
		var errors = document.getElementById("errors");
		if (pwd.value.trim() == "" || pwd == null) {
			errors.innerText = "密码不能为空！";
			return false;
		} else if (pwd.value.trim().length < 8 || pwd.value.trim().length > 18) {
			errors.innerText = "密码长度要大于等于8位且小于18位！";
			return false;
		} else {
			errors.innerText = "";
			return true;
		}
	}

	//联合检查
	function form_ElemCheck() {
		if (uidCheck() && pwdCheck()) {
			return true;
		} else {
			return  false;
		}
	}

	function form_submit() {
		if (form_ElemCheck()) {
			document.getElementById("formlogin").submit();
		}
	}

	function form_ElemClear() {
		var errors = document.getElementById("errors"); //获取DOM对象
		var uid = document.getElementById("userName");
		var pwd = document.getElementById("passWord");
		errors.innerText = "";
		uid.value = "";
		pwd.value = "";
	}
</script>
</head>
<body>
	<form id="formlogin" action="do_login.jsp" method="post">
		<div class="item">
			<label for="userName">用户名</label> <input id="userName" type="text"
				name="userName" tabindex="1" autocomplete="off" placeholder="请输入用户名" />
		</div>
		<div class="item">
			<label for="passWord">密码</label> <input id="passWord" type="password"
				name="passWord" tabindex="2" autocomplete="off" placeholder="请输入密码" />

		</div>
		<div class="item">
			<span id="errors"></span>
		</div>
		<div class="item">
			<a href="javascript:;" onclick="form_submit()" id="loginsubmit"
				tabindex="3">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
		</div>
		<div class="item">
			<a href="javascript:;" onclick="form_ElemClear()" id="loginreset"
				tabindex="4">重&nbsp;&nbsp;&nbsp;&nbsp;置</a>
		</div>
	</form>
	<script>
		var inputs = document.getElementsByTagName("input");
		for (var n = 0; n < inputs.length; n++) {
			inputs[n].addEventListener("blur", form_ElemCheck);
		}
	</script>
</body>
</html>