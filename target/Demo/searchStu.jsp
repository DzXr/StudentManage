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
    <meta charset="utf-8">
    <link rel="stylesheet" href="searchCla.css">
</head>
<body>
        <div class="target">
                <div class="target-1">     
                        <select name="" id="select-nav" onchange="window.location=this.value;">
                            <option value="main.html">首页</option>
                            <option value="clamanage.do">班级管理</option>
                            <option value="searchStu.html">查找学生</option>
                            <option value="addStu.html">增加学生</option>
                            <option value="courseManage.do">课程管理</option>
                            <option value="gradeManage.do">成绩管理</option>
                            <option value="login.html">退出登录</option>
                        </select>
                            </div>
          <div class="target-2">学生信息管理系统</div>
         
        <div class="target-3">
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
        <div>
                <marquee behavior="alternate">
                    <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
                    </marquee></div>
    </div>
</body>
</html>

