<%--
  Created by IntelliJ IDEA.
  User: johyeon-u
  Date: 2024. 8. 3.
  Time: 오후 5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<div id="wrap" align="center">
    <h1>회원 정보 입력</h1>
    <form name="frm" method="post" action="UserServlet">
        <input type="hidden" name="command" value="user_login">
        <table>
            <tr>
                <th>ID</th>
                <td><input type="text" size="70" name="userId"> * 필수</td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="text" size="70" name="password"></td>
            </tr>
        </table>
        <br><br>
        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>
