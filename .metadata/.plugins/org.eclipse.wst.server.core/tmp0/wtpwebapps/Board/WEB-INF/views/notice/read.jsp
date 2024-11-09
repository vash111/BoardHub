<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>공지사항 조회</title>
</head>
<body>
    <h2>공지사항 조회</h2>
    <h3>${notice.title}</h3>
    <p>작성자: ${notice.writer}</p>
    <p>작성일: ${notice.createdDate}</p>
    <p>내용: ${notice.content}</p>
    
    <!-- 수정 링크 -->
    <a href="<c:url value='/notice/update/${notice.id}' />">수정</a>

    <!-- 삭제 버튼에 확인 메시지 추가 -->
    <form action="<c:url value='/notice/delete/${notice.id}' />" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
        <button type="submit">삭제</button>
    </form>

    <a href="<c:url value='/notice/list' />">목록으로 돌아가기</a>
</body>
</html>
