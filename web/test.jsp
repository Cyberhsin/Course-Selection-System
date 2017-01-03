<%--
  Created by IntelliJ IDEA.
  User: Shinlee
  Date: 2016/12/31
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
    function insertAdmin(){
        var form = document.forms[0];
        form.action = "/Admin/insertAdmin";
        form.method="post";
        form.submit();
    }
</script>
</head>
<body>
<h1>添加管理员</h1>
<form action="" name="adminForm">
    姓名：<input type="text" name="adminName">
    密码：<input type="text" name="adminPwd">
    <input type="button" value="添加" onclick="insertAdmin()">
</form>
</body>
</html>
