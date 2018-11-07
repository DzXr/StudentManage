<%@ page import="com.wzm.api.entity.ClassCourse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzm.api.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addGradePage</title>
</head>
<body>
<h1>学生信息管理系统</h1>
<div style='align:center;background-color:#eeeeee'>
    <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
    <table border=1>
        <div align ="center" style="text-align:center;background-color:#eeeeee">
            <form action="addGrade.do" method="post">
                <%
                    List<ClassCourse> classCoursesList = (List)request.getAttribute("classCoursesList");
                    List<Course> courseList = (List)request.getAttribute("courseList");
                    char text = 'a';
                    int index = 0;
                    for (ClassCourse b : classCoursesList) {
                        text = (char) (text + 1);
                        String coursename = courseList.get(index).getCouname();
                %>
                        <p><%=coursename %> :<input type="text" name="<%=text %>"/></p>
                    <%

                        index++;
                    }
                    %>
                <input type="submit" value="提交"/>
            </form>
        </div>
    </table>
</div>

</body>
</html>
