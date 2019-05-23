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
                        <option value="addClassCourse.do">添加班级课程</option>
                        <option value="login.html">退出登录</option>
                    </select>
                        </div>
      <div class="target-2">学生信息管理系统</div>
     
    <div class="target-3">
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
    <div>
            <marquee behavior="alternate">
                <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
                </marquee></div>
</div>

</body>
</html>

