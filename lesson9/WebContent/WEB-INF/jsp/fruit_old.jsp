<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Fruit" %>
<%
	Fruit fruit = (Fruit)session.getAttribute("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フルーツの名前と値段は？</title>
</head>
<body>
<p>
	フルーツの種類は、<%=fruit.getName() %><br>
	フルーツの値段は、<%=fruit.getPrice() %>円
</p>
</body>
</html>