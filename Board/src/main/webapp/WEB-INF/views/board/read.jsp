<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시글 조회</title>
</head>
<body>
    <h2>게시글 조회</h2>
    <h3>${board.title}</h3>
    <p>작성자: ${board.writer}</p>
    <p>작성일: ${board.createdDate}</p>
    <p>내용: ${board.content}</p>
    
    <!-- 수정 링크 추가 -->
    <a href="<c:url value='/board/edit/${board.id}' />">수정</a>

    <!-- 기존 수정 버튼 (POST 요청) -->
    <form action="<c:url value='/board/update' />" method="post">
        <input type="hidden" name="id" value="${board.id}" />
        <button type="submit">수정</button>
    </form>

    <!-- 삭제 버튼에 확인 메시지 추가 -->
    <form action="<c:url value='/board/delete/${board.id}' />" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
        <button type="submit">삭제</button>
    </form>
    
    <a href="<c:url value='/board/list' />">목록으로 돌아가기</a>
</body>
</html>
