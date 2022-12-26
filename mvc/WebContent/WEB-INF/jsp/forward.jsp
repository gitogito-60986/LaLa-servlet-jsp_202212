<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	Integer randomNum = (Integer)request.getAttribute("randomNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード先</title>
</head>
<body>
<h1>フォワード先</h1>
<p>フォワードされたページです</p>
<p>ランダムナンバーは<%=randomNum %></p>
<p><a href="http://localhost:8080/mvc/ex62">再読込み</a></p>
</body>
</html>