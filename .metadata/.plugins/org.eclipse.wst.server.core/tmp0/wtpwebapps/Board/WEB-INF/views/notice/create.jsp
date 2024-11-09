<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>공지사항 작성</title>
</head>
<body>
    <h2>공지사항 작성</h2>
    <form action="<c:url value='/notice/create' />" method="post">
        <label>제목: </label><input type="text" name="title" /><br />
        <label>내용: </label><textarea name="content"></textarea><br />
        <label>작성자: </label><input type="text" name="writer" /><br />
        <button type="submit">등록</button>
    </form>
</body>
</html>
