<%@ page import="com.wzm.api.entity.Class" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="searchCla.css">
</head>
<body>
    <div class="target">
            <div class="target-1">     
                    <select name="" id="select-nav" onchange="window.location=this.value;">
                        <option value="main.html">首页</option>
                        <option value="clamanage.do">班级管理</option>
                        <option value="searchcla.html">查找班级</option>
                        <option value="addcla.html">增加班级</option>
                        <option value="login.html">退出登录</option>
                    </select>
                        </div>
      <div class="target-2">学生信息管理系统</div>
     
    <div class="target-3">
        <table border=1>
            <th width=10%>班级号</th><th width=10%>院系</th><th width=10%>专业</th><th width=10%>操作</th>
            <tr>
                <%
                    if(session.getAttribute("classes") != null)
                    {
                        Class classes = (Class)session.getAttribute("classes");
                %>
                    <td><a href='classInformationManage.do?claid=<%=classes.getClaid() %>'><%=classes.getClaid() %></a></td>
                    <td><%=classes.getIns() %></td>
                    <td><%=classes.getMajor() %></td>
                    <td><a href='deletecla.do?claid=<%=classes.getClaid() %>'>删除</a><a href='updatecla.html?claid=<%=classes.getClaid() %>'>更新</a></td>
                <%
                    }
                %>
            </tr>
        </table>
        <%
            if(session.getAttribute("classes") == null)
            {
        %>
        <span>抱歉！没有该班级</span>
        <a href="searchcla.html">重新查找</a>
        <%
            }
        %>
</div>
<div>
        <marquee behavior="alternate">
            <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
            </marquee></div>
</body>
</html>
