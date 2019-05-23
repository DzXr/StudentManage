<%@ page import="com.wzm.api.entity.ClassCourse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzm.api.entity.Student" %>
<%@ page import="com.wzm.api.entity.Course" %>
<%@ page import="com.wzm.api.entity.Grade" %>
<%@ page import="com.wzm.api.util.Page" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gradeManage</title>
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
                        <option value="checkCourseGrade.do">查找各科成绩</option>
                        <option value="login.html">退出登录</option>
                    </select>
                        </div>
      <div class="target-2">学生信息管理系统</div>
     
    <div class="target-3">
        <table border=1>
                <th width=6%>学生号</th><th width=5%>学生名</th>
            <%
            List<ClassCourse> classCoursesList = (List)request.getAttribute("classCoursesList");
            List<Student> studentsList = (List)request.getAttribute("studentsList");
            List<Course> courseList = (List)request.getAttribute("courseList");
            List<Grade> gradeList = (List)request.getAttribute("gradeList");
            Page page1 = (Page)request.getAttribute("page");
            String classUid = session.getAttribute("claid").toString();
            int start = page1.getStart();
            int count = page1.getCount();
            int totalPage = page1.getTotalPage();
            int index = 0;
            for (Course b : courseList) {
            %>
                <th width=8%><%=b.getCouname() %></th>

            <%
             }
            %>
                <th width=7%>操作</th>
            <%
            for (Student c : studentsList) {
            %>
                <tr>
                <td><%=c.getStuid() %></td>
                <td><%=c.getStuname() %></td>
                    <%
                    for (ClassCourse b : classCoursesList) {
                        if (gradeList.get(index) != null){
                    %>
                        <td><%=gradeList.get(index).getGrade() %></td>
                    <%
                        }
                        else{
                    %>
                    <td></td>
                    <%
                        }
                        index++;
                    }
                    %>
                <td><a href='addGradePage.do?claid=<%=classUid %>&stuid=<%=c.getStuid() %>'>录入成绩</a></td>
                </tr>
        <%
            }
        %>
        </table>

    <%
        if(page1.isHasPreviouse()){
    %>
    <br>
    <table style="float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;">
        <td style="text-align:center">
            <a href='gradeManage.do?start=<%=(start - count) %>' style="text-decoration:none">
                <div style="font-size: 14px">上一页</div>
            </a>
        </td>
    </table>
    <%
        }
        for (int i = 1; i <= totalPage; i++) {
            if (start == (i - 1) * count) {
    %>
    <table style="float:left; width:23px; height:15px; border:0px solid grey; margin-right:3px;">
        <td style="text-align:center">
            <a href='gradeManage.do?start=<%=((i - 1) * count) %>' style="text-decoration:none">
                <div style="font-size: 14px"><%=i %></div>
            </a>
        </td>
    </table>
    <%
    }
    else{
    %>
    <table style="float:left; width:23px; height:15px; border:1px solid grey; margin-right:3px;">
        <td style="text-align:center">
            <a href='gradeManage.do?start=<%=((i - 1) * count) %>' style="text-decoration:none">
                <div style="font-size: 14px"><%=i %></div>
            </a>
        </td>
    </table>
    <%
            }
        }
        if(page1.isHasNext()) {
    %>
    <table style="float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;">
        <td style="text-align:center">
            <a href='gradeManage.do?start=<%=(start+count) %>' style="text-decoration:none">
                <div style="font-size: 14px">下一页</div>
            </a>
        </td>
    </table>
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
