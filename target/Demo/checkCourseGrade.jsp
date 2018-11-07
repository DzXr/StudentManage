<%@ page import="com.wzm.api.entity.CourseGrade" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息管理系统</h1>
<div style='align:center;background-color:#eeeeee'>
    <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
    <table border=1>
        <th width=7%>课程</th><th width=5%>平均成绩</th><th width=5%>最高分</th><th width=5%>最低分</th>
        <%
            List<CourseGrade> courseGradeList = (List)request.getAttribute("courseGradeList");
            for (CourseGrade b : courseGradeList) {
        %>
            <tr>
                <td><%= b.getCourserName()%></td>
                <td><%= b.getCourseAVG()%></td>
                <td><%= b.getCourseMax()%></td>
                <td><%= b.getCourseMin()%></td>
            </tr>
        <%
            }
        %>
        </table>
    </div>
</body>
</html>
