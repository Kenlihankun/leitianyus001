<%--
  Created by IntelliJ IDEA.
  User: leitianyu
  Date: 2022/6/9
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/loginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg" style="color: red">${login_msg} ${register_msg}</div>
        <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>

        <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
        <p>Remember:<input id="remember" name="remember"  type="checkbox" value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <a href="find.jsp"><input type="button"  class="button" value="Find">&nbsp;&nbsp;&nbsp;</a>
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>
<script src="https://fastly.jsdelivr.net/gh/stevenjoezhang/live2d-widget@latest/autoload.js"></script>
</body>
</html>
