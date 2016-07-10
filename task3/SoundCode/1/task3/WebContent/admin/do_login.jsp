<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("userName");
	String pwd = request.getParameter("passWord");
	if (uid.equals("admin") && pwd.equals("12345678"))
	{
		request.setAttribute("userName", uid);
		request.setAttribute("passWord", pwd);
%>
<jsp:forward page="loginSuccess.jsp"></jsp:forward>
<%
	} else {
		out.println("您提交的用户名或密码不正确！请点击<a href='" + "/task3/admin/login.jsp" + "'>返回</a>，重新登录");
	}
%>
