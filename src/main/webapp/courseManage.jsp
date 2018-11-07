<%@ page import="com.wzm.api.entity.ClassCourse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzm.api.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>courseManage</title>
</head>
<body>
<h1>学生信息管理系统</h1>
<div style='align:center;background-color:#eeeeee'>
    <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
    <sup>·+·+</sup><a href='addClassCourse.do'>添加班级课程</a><sup>·+·+</sup><br>
    <table border=1>
        <th width=10%>课程号</th><th width=10%>课程名</th><th width=10%>学分</th><th width=5%>操作</th>
        <%
            List<Course> courseList = (List)request.getAttribute("courseList");
            String classUid = (String)session.getAttribute("claid");
            for (Course b : courseList) {
        %>
        <tr>
            <td><%=b.getCouid() %></td>
            <td><%=b.getCouname() %></td>
            <td><%=b.getCredit()%></td>
            <td><a href='deleteclasscourse.do?claid=<%=classUid %>&couid=<%=b.getCouid() %>'>删除</a></td>
        </tr>
        <%
            }
        %>
        </table>
    </div>
</body>
</html>
