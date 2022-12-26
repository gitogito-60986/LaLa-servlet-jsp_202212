<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー年齢認証結果</title>
</head>
<body>
	<p><%= msg %></p>
	<a href="/alchole/ask">戻る</a>
</body>
</html>