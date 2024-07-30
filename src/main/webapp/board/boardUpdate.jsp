<%--
  Created by IntelliJ IDEA.
  User: johyeon-u
  Date: 2024. 7. 30.
  Time: 오후 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 수정</title>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 수정하기</h1>
    <form name="frm" method="post" action="BoardServlet">
        <input type="hidden" name="command" value="board_update">
        <input type="hidden" name="num" value="${board.num}">
        <table>
            <tr>
                <th>제목</th>
                <td><label>
                    <input type="text" size="70" name="title"
                               value="${board.title}">
                </label></td>
            </tr>

            <tr>
                <th>내용</th>
                <td><label>
<textarea cols="70" rows="15"
              name="content">${board.content}</textarea>
                </label></td>
            </tr>
        </table>
        <br><br>
        <input type="submit" value="등록">
        <input type="reset" value="다시 작성">
        <input type="button" value="목록"
               onclick="location.href ='BoardServlet?command=board_list'">
    </form>
</div>
</body>
</html>
