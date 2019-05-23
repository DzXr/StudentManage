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
    <title>addClassCourse</title>
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
                        <option value="addCourse.html">开设课程</option>
                        <option value="searchCourse.html">查询课程</option>
                        <option value="login.html">退出登录</option>
                    </select>
                        </div>
      <div class="target-2">学生信息管理系统</div>
     
    <div class="target-3">
        <table border=1>
                <th width=10%>课程号</th><th width=10%>课程名</th><th width=10%>学分</th><th width=5%>操作</th>
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
    </div>
    <div>
            <marquee behavior="alternate">
                <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
                </marquee></div>
</div>

</body>
</html>
