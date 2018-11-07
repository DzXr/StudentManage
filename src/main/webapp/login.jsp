<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5 0005
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>学生信息管理系统</h1>
<h2>教师登录</h2>
<div  align ="center" style="text-align:center;background-color:#eeaadd">
    <form action="/login.do" method="post">
        教师编号: <input type="text" name="teaid"/><br/>
            密码:<input type="password" name="teapass"/><br/>

        <%
            if(request.getParameter("judge") != null){
        %>
        <div style="color: red">用户名或密码错误！</div>
        <%
            }
        %>
        <input type="submit" value="确认登录"/>
    </form>
</div>
</body>
</html>
