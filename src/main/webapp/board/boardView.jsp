<%--
  Created by IntelliJ IDEA.
  User: johyeon-u
  Date: 2024. 7. 30.
  Time: 오후 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 상세조회</title>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 상세조회</h1>
    <table>
        <tr>
            <th>작성일 </th><td><fmt:formatDate value="${board.createDate }"/></td>
            <th>조회수</th><td>${board.readCount}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td colspan="3">${board.title}</td>
        </tr>

        <tr>
            <th>내용</th>
            <td colspan="3"><pre>${board.title}</pre></td>
        </tr>
    </table>
    <br><br>
    <input tpye="button" value="게시글 수정"
           onclick="location.href ='BoardServlet?command=board_update_form&num=${board.num}'">
    <input tpye="button" value="게시글 삭제"
           onclick="location.href ='BoardServlet?command=board_delete&num=${board.num}'">
    <input tpye="button" value="목록"
           onclick="location.href ='BoardServlet?command=board_list'">
    <input tpye="button" value="게시글 등록"
           onclick="location.href ='BoardServlet?command=board_post_form'">
</div>
</body>
</html>
