<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" />
		<title>新規社員情報登録結果 - 社員情報マネージャー</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h2 class="page_title">新規社員情報登録結果</h2>
				<p><c:out value="${msg}" /></p>
				<div class="btn-area">
					<a href="<%= request.getContextPath() %>/list">社員一覧画面へ戻る</a>
				</div>
			</article>
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</body>
</html>