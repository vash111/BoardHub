<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>공지사항 목록</title>
</head>
<body>
	<h2>공지사항 목록</h2>
	<a href="<c:url value='/notice/create' />">새 공지사항 작성</a>

	<!-- 검색 폼 수정 -->
	<form action="<c:url value='/notice/search' />" method="get"
		style="margin-top: 10px;">
		<input type="text" name="keyword" placeholder="검색어를 입력하세요"
			value="${keyword}" />
		<button type="submit">검색</button>
	</form>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="notice" items="${notices}">
			<tr>
				<td>${notice.id}</td>
				<td><a href="<c:url value='/notice/read/${notice.id}' />">${notice.title}</a></td>
				<td>${notice.writer}</td>
				<td>${notice.createdDate}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 페이지네이션 링크 -->
	<c:if test="${currentPage > 0}">
		<a href="<c:url value='/notice/list?page=${currentPage - 1}' />">이전</a>
	</c:if>
	<a href="<c:url value='/notice/list?page=${currentPage + 1}' />">다음</a>
</body>
</html>
