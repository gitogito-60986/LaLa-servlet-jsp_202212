<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー年齢認証</title>
</head>
<body>
	<form action="/alchole/ask" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="number" name="age"><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>