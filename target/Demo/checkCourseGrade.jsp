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
    <title>checkCourseGrade</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="searchCla.css">
</head>
<body>
     <div class="target">
            <div class="target-1">     
                    <select name="" id="select-nav" onchange="window.location=this.value;">
                        <option value="main.html">首页</option>
                        <option value="main.html">首页</option>
                        <option value="clamanage.do">班级管理</option>
                        <option value="login.html">退出登录</option>
                    </select>
                        </div>
      <div class="target-2">学生信息管理系统</div>
     
    <div class="target-3">
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
    <div>
            <marquee behavior="alternate">
                <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
                </marquee></div>
</div>

</body>
</html>

