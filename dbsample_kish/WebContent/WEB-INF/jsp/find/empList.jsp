<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" />
		<title>社員情報マネージャー</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		
		<main class="center-layout">
			<article>
				<h2 class="page_title">社員一覧画面</h2>
				<c:choose>
					<c:when test="${empty empList}">
						<p class="notfound">該当する社員は存在しません。</p>
						<a class="notfound" href="<%= request.getContextPath() %>/list">社員一覧 再表示</a>
					</c:when>
					<c:otherwise>
						<table class="emp_list_table">
							<tr>
								<th class="empId">社員ID</th>
								<th class="empName">社員名</th>
								<th class="gender">性別</th>
								<th class="birthday">生年月日</th>
								<th class="deptName">部署名</th>
								<th class="no-border no-background"></th>
								<th class="no-border no-background"></th>
							</tr>
							<c:forEach var="emp" items="${empList}">
								<tr>
									<td>${emp.id}</td>
									<td>${emp.name}</td>
									<td>${emp.gender.name}</td>
									<td>${emp.birthday}</td>
									<td>${emp.dept.name}</td>
									<td class="no-border img-td">
										${img_pencil}
									</td>
									<td class="no-border img-td">
										${img_trash}
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</article>
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</body>
</html>