<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Divination" %>
<%
	// リクエストスコープに保存された Divination を取得
	Divination divination = (Divination) request.getAttribute("divination");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占いアプリ</title>
</head>
<body>
	<h1>モヤっと占い</h1>
	<p><%=divination.getToday() %>の運勢は<%=divination.getDivResult() %></p>
	
	<!-- JSPのテストページです -->
	<h1>JSPの出力テスト</h1>
	
	<%-- 日付を出力します --%>
	
</body>
</html>