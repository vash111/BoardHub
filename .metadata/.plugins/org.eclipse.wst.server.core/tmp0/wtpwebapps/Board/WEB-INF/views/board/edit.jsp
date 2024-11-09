<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시글 수정</title>
</head>
<body>
    <h2>게시글 수정</h2>
    <form action="<c:url value='/board/update' />" method="post">
        <input type="hidden" name="id" value="${board.id}" />
        <label>제목:</label>
        <input type="text" name="title" value="${board.title}" /><br />
        <label>내용:</label>
        <textarea name="content">${board.content}</textarea><br />
        <button type="submit">수정 완료</button>
    </form>
    <a href="<c:url value='/board/list' />">목록으로 돌아가기</a>
</body>
</html>
