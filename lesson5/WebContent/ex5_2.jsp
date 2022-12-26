<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ</title>
</head>
<body>
	<h1>お問い合わせフォーム</h1>
	<form action="/lesson5/Ex5_2" method="post">
		お名前：<br>
		<input type="text" name="name"><br>
		お問い合わせの種類:<br>
		<select name="qtype">
			<option value="0">会社について</option>
			<option value="1">製品について</option>
			<option value="2">アフターサポートについて</option>
		</select><br>
		お問い合わせの内容:<br>
		<textarea name="body"></textarea>
		<input type="submit" value="登録">
	</form>
</body>
</html>