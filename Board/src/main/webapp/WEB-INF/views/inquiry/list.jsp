<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>1대1 문의 목록</title>
</head>
<body>
    <h2>1대1 문의 목록</h2>
    <a href="<c:url value='/inquiry/create' />">새 문의 작성</a>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <c:if test="${empty inquiries}">
            <tr>
                <td colspan="4">데이터가 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach var="inquiry" items="${inquiries}">
            <tr>
                <td>${inquiry.id}</td>
                <td><a href="<c:url value='/inquiry/read/${inquiry.id}' />">${inquiry.title}</a></td>
                <td>${inquiry.writer}</td>
                <td><fmt:formatDate value="${inquiry.createdDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
        </c:forEach>
    </table>

    <!-- 페이지네이션 링크 -->
    <div>
        <c:if test="${currentPage > 0}">
            <a href="<c:url value='/inquiry/list?page=${currentPage - 1}' />">이전</a>
        </c:if>
        <c:if test="${not empty inquiries}">
            <a href="<c:url value='/inquiry/list?page=${currentPage + 1}' />">다음</a>
        </c:if>
    </div>
</body>
</html>
