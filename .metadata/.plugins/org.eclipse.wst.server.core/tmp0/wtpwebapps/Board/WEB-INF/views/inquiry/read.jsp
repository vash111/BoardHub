<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>1대1 문의 조회</title>
</head>
<body>
    <h2>1대1 문의 조회</h2>
    <h3>${inquiry.title}</h3>
    <p>작성자: ${inquiry.writer}</p>
    <p>작성일: <fmt:formatDate value="${inquiry.createdDate}" pattern="yyyy-MM-dd" /></p>
    <p>내용: ${inquiry.content}</p>
    
    <!-- 관리자일 경우만 댓글 작성 폼을 보여줌 -->
    <c:if test="${isAdmin}">
        <h3>댓글 작성</h3>
        <form action="<c:url value='/inquiry/comment' />" method="post">
            <input type="hidden" name="inquiryId" value="${inquiry.id}" />
            <textarea name="comment"></textarea><br />
            <button type="submit">댓글 등록</button>
            <a href="<c:url value='/inquiry/update/${inquiry.id}' />">수정</a>
        </form>
    </c:if>
    
    <!-- 댓글 표시 -->
    <c:if test="${not empty inquiry.comment}">
        <h3>관리자 댓글:</h3>
        <p>${inquiry.comment}</p>
    </c:if>

    <a href="<c:url value='/inquiry/list' />">목록으로 돌아가기</a>
</body>
</html>
