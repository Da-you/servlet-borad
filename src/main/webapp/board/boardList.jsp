<%--
  Created by IntelliJ IDEA.
  User: johyeon-u
  Date: 2024. 7. 29.
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 리스트</h1>
    <table class="list">
        <tr>
            <td colspan="5" style="border: white; text-align: right">
                <a href="BoardServlet?command=board_post_form"> 게시글 등록</a>
            </td>
        </tr>
        <tr>
            <td colspan="5" style="border: white; text-align: right">
                <a href="UserServlet?command=user_signup_form"> 회원 가입</a>
            </td>
        </tr>
        <tr>
            <td colspan="5" style="border: white; text-align: right">
                <a href="UserServlet?command=user_login_form"> 로그인</a>
            </td>
        </tr>
        <tr>
        </tr>
        <th>번호</th><th>제목</th><th>작성일</th><th>조회수</th>
        <c:forEach var="board" items="${boardList }">
            <tr class="record">
                <td>${board.num}</td>
                <td>
                    <a href="BoardServlet?command=board_view&num=${board.num}">
                            ${board.title }
                    </a>
                </td>
                <td><fmt:formatDate value="${board.createDate }"/></td>
                <td>${board.readCount}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
