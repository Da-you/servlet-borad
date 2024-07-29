<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <form method = "get" action ="LoginServlet">
    <label for="id"> 아이디 : </label>
    <input type = "text" name="id" id="userid"><br>

    <label for="password"> 비밀번호 : </label>
    <input type = "password" name="password" id="password"><br>
    <input type = "submit" value="로그인">
    </form>
  </body>
</html>