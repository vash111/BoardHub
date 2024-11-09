<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
    <h2>게시판 목록</h2>
    <a href="<c:url value='/board/create' />">새 글 작성</a>
    <table border="1">
        <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${board.id}</td>
                <td><a href="<c:url value='/board/read/${board.id}' />">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.createdDate}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- 페이지네이션 링크 -->
    <c:if test="${currentPage > 0}">
        <a href="<c:url value='/board/list?page=${currentPage - 1}' />">이전</a>
    </c:if>
    <a href="<c:url value='/board/list?page=${currentPage + 1}' />">다음</a>
</body>
</html>