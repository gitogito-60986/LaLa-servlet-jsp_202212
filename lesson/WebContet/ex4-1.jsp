<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Employee"%>
<%
	Employee emp = new Employee("湊 雄輔", "0001");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex4-1</title>
</head>
<body>
	<p>IDは <%= emp.getId() %>、名前は <%= emp.getName() %> です</p>
</body>
</html>