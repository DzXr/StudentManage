<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.wzm.api.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息管理系统</h1>
<h2>班级管理</h2>
<div style='aligin:cener;background-color:#eeeeee'>
    <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
    <sup>.+.+.+.+.+</sup><a href='searchStu.html'>查找学生</a><sup>.+.+.+.+.+</sup><a href='addStu.html '>增加学生</a><sup>.+.+.+.+.+</sup><a href='courseManage.do'>课程管理</a><sup>.+.+.+.+.+</sup><a href='gradeManage.do '>成绩管理</a><br>
    <table border=1>
        <th width=8%>学号</th><th width=5%>姓名</th><th width=5%>性别</th><th width=15%>出生日期</th><th width=15%>家庭住址</th><th width=8%>政治面貌</th><th width=8%>操作</th>

        <%
            if(session.getAttribute("student") != null){
                Student student = (Student)session.getAttribute("student");
                String date = new SimpleDateFormat("yyyy-MM-dd").format(student.getStudate());
        %>
        <tr>
            <td><%=student.getStuid() %></td>
            <td><%=student.getStuname() %></td>
            <td><%=student.getStusex() %></td>
            <td><%=date %></td>
            <td><%=student.getStuadd() %></td>
            <td><%=student.getPolsta() %></td>
            <td><a href='deleteStu.do?stuid=<%=student.getStuid() %>'>删除</a>
                <a href='updateStu.html?stuid=<%=student.getStuid() %>'>更新</a>
            </td>
        </tr>
        <%
            }
        %>

    </table>
    <%
        if(session.getAttribute("student") == null)
        {
    %>
    <span>抱歉！没有要查找到这位同学</span>
    <a href="searchStu.html">重新查找</a>
    <%
        }
    %>
</div>
</body>
</html>
