<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>검색 결과</title>
</head>
<body>
    <h2>검색 결과</h2>

    <!-- 검색어 표시 -->
    <p>검색어: ${keyword}</p>

    <!-- 검색 결과 목록 테이블 -->
    <table border="1" style="margin-top: 10px;">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="board" items="${boardList}">
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
        <a href="<c:url value='/board/search?keyword=${keyword}&page=${currentPage - 1}' />">이전</a>
    </c:if>
    <a href="<c:url value='/board/search?keyword=${keyword}&page=${currentPage + 1}' />">다음</a>
</body>
</html>
