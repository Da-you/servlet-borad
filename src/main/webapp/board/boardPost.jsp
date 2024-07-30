<%--
  Created by IntelliJ IDEA.
  User: johyeon-u
  Date: 2024. 7. 30.
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
    <title>게시글 작성</title>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 등록</h1>
    <form name="frm" method="post" action="BoardServlet">
        <input type="hidden" name="command" value="board_post">
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" size ="70" name="title"> * 필수 </td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea cols ="70" rows="15" name="content"></textarea> </td>
            </tr>
        </table>
        <br><br>
        <input type="submit" value="등록">
        <br><br>
        <input tpye="button" value="목록" onclick="location.href ='BoardServlet?command=board_list'">
    </form>
</div>
</body>
</html>
