<%--
  Created by IntelliJ IDEA.
  User: johyeon-u
  Date: 2024. 7. 29.
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <a herf="BoardServlet?command=board_write_form"> 게시글 등록</a>
            </td>
        </tr>
        <tr>
            <th>번호</th>
        </tr>
        <th>제목</th>
        <th>작성일</th>
        <th>조회</th>
        <c:forEach var="borad" items="${boardList }">
            <tr class="record">
                <td>${board.num}</td>
                <td>
                    <a href="BoardServlet?command=board_view&num=&{board.num}">
                            ${borad.title }
                    </a>
                </td>
                <td><fmt: formatDate value="${board.createdAt }"/></td>
                <td>${borad.readCount}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
