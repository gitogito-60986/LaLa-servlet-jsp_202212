<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Hero" %>
<%@ page import = "model.Dragon" %>
<%
	Hero hero = (Hero)application.getAttribute("hero");
	Dragon dragon = (Dragon)application.getAttribute("dragon");
	String dragonAttack = (String)request.getAttribute("dragonAttack");
	String heroAttack = (String)request.getAttribute("heroAttack");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	p { margin: 0; }
</style>
<title>Dragon's Quest</title>
</head>
<body>
	<h1>勇者とドラゴンの戦い</h1>
	<% if(heroAttack != null) { %>
	<p><%= heroAttack %></p>
	<% } %>
	<% if(dragonAttack != null) { %>
	<p><%= dragonAttack %></p>
	<% } %>
	<br>
	<p><%= dragon %></p>
	<p><%= hero %></p>
	<br>
	<p>どうする？</p>
	<form action="/rpg/game" method="post">
		<input type="radio" name="action" value="attack">攻撃する
		<input type="radio" name="action" value="runaway">逃げる
		<input type="submit" value="決定">
	</form>
</body>
</html>