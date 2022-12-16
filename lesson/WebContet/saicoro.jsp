<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="toba.Saicoro"%>
<%
	Saicoro saicoro = new Saicoro();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サイコロの目</title>
</head>
<body>
		<% if(saicoro.getEye() % 2 == 0) { %>
			<p>サイコロを振った結果は、丁 です</p>
		<% } else { %>
			<p>サイコロを振った結果は、半 です</p>
		<% } %>
		<p>サイコロの目は、 <%= saicoro.getEye() %> です</p>
</body>
</html>