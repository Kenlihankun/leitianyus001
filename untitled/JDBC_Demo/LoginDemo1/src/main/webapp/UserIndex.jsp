<%--
  Created by IntelliJ IDEA.
  User: leitianyu
  Date: 2022/6/10
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>${sessionScope.User.username}:欢迎您</div>
<div>${sessionScope.User.id}:是您的id</div>


</body>
</html>
