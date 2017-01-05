<%--
  Created by IntelliJ IDEA.
  User: Shinlee
  Date: 2017/1/5
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function addUser(){
            var form = document.forms[0];
            form.action = "/insertAdmin";
            form.method="post";
            form.submit();
        }
    </script>
</head>

<body>
<h1>添加用户</h1>
<form action="" name="userForm">
    姓名：<input type="text" name="adminName"><br>
    年龄：<input type="text" name="adminPwd">
    <input type="button" value="添加" onclick="addUser()">
</form>

</body>
</html>
