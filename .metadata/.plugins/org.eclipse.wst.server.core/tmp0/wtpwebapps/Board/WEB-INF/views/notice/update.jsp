<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>공지사항 수정</title>
</head>
<body>
    <h2>공지사항 수정</h2>
    <form action="<c:url value='/notice/update' />" method="post">
        <input type="hidden" name="id" value="${notice.id}" />
        
        <label>제목: </label>
        <input type="text" name="title" value="${notice.title}" required /><br />

        <label>내용: </label>
        <textarea name="content" required>${notice.content}</textarea><br />

        <label>작성자: </label>
        <input type="text" name="writer" value="${notice.writer}" readonly /><br />

        <button type="submit">수정</button>
        <a href="<c:url value='/notice/list' />">취소</a>
    </form>
</body>
</html>
