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
                <input type="submit" value="提交" style="width: 80px;height: 30px;border-radius: 8px;opacity: 0.8;font-size:19px; cursor: pointer; outline:none;"/>
                                    </form>
                        </table>               
                </div>
                <div>
                        <marquee behavior="alternate">
                            <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
                            </marquee></div>
                            </div>
        </body>
        </html>
