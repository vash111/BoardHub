<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>문의 수정</title>
</head>
<body>
    <h2>1대1 문의 수정</h2>
    <form action="<c:url value='/inquiry/update' />" method="post">
        <input type="hidden" name="id" value="${inquiry.id}" />
        <div>
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" value="${inquiry.title}" />
        </div>
        <div>
            <label for="content">내용:</label>
            <textarea id="content" name="content">${inquiry.content}</textarea>
        </div>
        <div>
            <button type="submit">수정하기</button>
        </div>
    </form>
</body>
</html>
