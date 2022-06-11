<%--
  Created by IntelliJ IDEA.
  User: leitianyu
  Date: 2022/6/11
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>找回密码</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
        <span>注册账户？</span> <a href="register.jsp">登录</a>
    </div>
    <form id="reg-form" action="/selectByIdServlet" method="post">
        <div id="errorMsg" style="color: red">${login_msg} ${register_msg}</div>
        <table>

            <tr>
                <td>用户ID</td>
                <td class="inputs">
                    <input name="id" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none">用户名不太受欢迎</span>
                </td>

            </tr>
            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/checkCodeServlet">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="确认" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
<script>
    document.getElementById("changeImg").onclick=function (){
        document.getElementById("checkCodeImg").src="/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>
</body>
</html>
