<%@ page import="com.wzm.api.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzm.api.entity.ClassCourse" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 12:27
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
        <th width=10%>课程号</th><th width=10%>课程名</th><th width=10%>学分</th><th width=5%>操作</th>
        <sup>·+·+</sup><a href='addCourse.html'>开设课程</a><sup>·+·+</sup><a href='searchCourse.html'>查询课程</a><br>
        <%
            List<Course> courseList = (List)session.getAttribute("courseList");
            List<ClassCourse> classCourseList = (List)session.getAttribute("classCourseList");
            String classUid = session.getAttribute("claid").toString();
            for (Course b : courseList) {
                int judge = 0;
                for(ClassCourse c : classCourseList)
                {

                    if(b.getCouid().equals(c.getCouid()))
                    {

                        judge = 1;
                        break;
                    }
                }
                if(judge == 1 )
                    continue;
        %>
                <tr>
                    <td><%=b.getCouid() %></td>
                    <td><%=b.getCouname() %></td>
                    <td><%=b.getCredit() %></td>
                    <td><a href='addCourseToClass.do?claid=<%=classUid %>&couid=<%=b.getCouid() %>'>添加</a></td>
                </tr>
        <%
            }
        %>
        </table>
</body>
</html>
