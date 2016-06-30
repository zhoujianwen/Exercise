<%@page import="java.util.Iterator"%>
<%@page import="cn.zhoujianwen.model.Tang"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="keywords" content="唐诗,诗词">
<meta http-equiv="description" content="唐诗在线搜索">
<title>唐诗在线搜索</title>
<link rel="stylesheet" type="text/css" href="css/os1.css">
</head>
<body>
	<div id="s1">
		<div id="s2">
			<p id="logo">
				<span id="t1">唐</span><span id="t2">诗</span> <span id="t3">在</span><span
					id="t4">线</span><span id="t5">搜</span> <span id="t6">索</span><br />

			</p>
			<form action="Poem/TangServlet" method="post" name="searchForm">
				<input type="text" maxlength="30" name="searText" /> <select
					name="selTxtType">
					<option selected="selected">题目</option>
					<option>作者</option>
					<option>内容</option>
				</select> <input type="submit" value="搜&nbsp;&nbsp;&nbsp;索" name="submit" />
			</form>
		</div>
	</div>

	<div id="s2">
		<ul>

			<%
				List<Tang> list = (List<Tang>) session.getAttribute("list");
			%>
			<li style="margin-bottom: 10px;">诗搜为您找到相关结果约<%=list != null ? list.size() : 0%>个
			</li>
			<%
				if (list != null && list.size() > 0) {
					Iterator<Tang> iterator = list.iterator();
					while (iterator.hasNext()) {
						Tang tang = iterator.next();
			%>
			<li>
				<p id="title">
					题目：《<%=tang.getTitle()%>》
				</p>
				<p id="author">
					作者：<%=tang.getAuthor()%></p>
				<p id="content">
					<span style="color: #35b558"><b>诗词：</b></span><%=tang.getContent()%></p>
			</li>
			<%
				}
				} else {
			%>
			<li><p id="title"></p>
				<p id="author"></p>
				<p id="content"></p></li>
			<%
				}
			%>
		</ul>
	</div>
	<div id="c1"></div>
	<footer>
	<div id="f1">
		<p>©2016 shishou 使用诗搜前必读 意见反馈 京ICP证012345号</p>
		<p>京公网安备10000000000000号</p>
	</div>
	</footer>
</body>
</html>