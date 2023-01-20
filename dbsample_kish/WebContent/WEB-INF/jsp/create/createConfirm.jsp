<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" />
		<title>新規社員情報登録確認 - 社員情報マネージャー</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		
		<main class="center-layout">
			<article>
				<h2 class="page_title">新規社員情報登録確認</h2>
				<table class="">
					<tr>
						<th>ID</th>
						<td>
							<c:out value="${emp.id}" />
						</td>
					</tr>
					<tr>
						<th>名前</th>
						<td>
							<c:out value="${emp.name}" />
						</td>
					</tr>
					<tr>
						<th>性別</th>
						<td>
							<c:out value="${emp.gender.name}" />
						</td>
					</tr>
					<tr>
						<th>生年月日</th>
						<td>
							<c:out value="${emp.birthday}" />
						</td>
					</tr>
					<tr>
						<th>部署</th>
						<td>
							<c:out value="${emp.dept.name}" />
						</td>
					</tr>
				</table>
				<form class="input-form">
					<input type="hidden" name="id" value="${emp.id}">
					<input type="hidden" name="name" value="${emp.name}">
					<input type="hidden" name="gender" value="${emp.gender.id}">
					<input type="hidden" name="birthday" value="${emp.birthday}">
					<input type="hidden" name="dept" value="${emp.dept.id}">
					<div class="btn-area">
						<input type="submit" value="キャンセル" class="cansel-btn"
							formmethod="post" formaction="<%= request.getContextPath() %>/create">
						<input type="submit" value="登録" class="submit-btn"
							formmethod="post" formaction="<%= request.getContextPath() %>/createDone">
					</div>
				</form>
			</article>
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</body>
</html>