<%@ page import="com.wzm.api.util.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzm.api.entity.Student" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>classInformaticaManage</title>
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
            Page page1 = (Page)request.getAttribute("page");
            List<Student> list = (List)request.getAttribute("list");
            int start = page1.getStart();
            int count = page1.getCount();
            String classUid = (String) session.getAttribute("claid");
            int totalPage = page1.getTotalPage();
        for (Student b : list) {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(b.getStudate());
        %>

        <tr>
            <td><%=b.getStuid() %></td>
            <td><%=b.getStuname() %></td>
            <td><%=b.getStusex() %></td>
            <td><%=date %></td>
            <td><%=b.getStuadd() %></td>
            <td><%=b.getPolsta() %></td>
            <td><a href='deleteStu.do?stuid=<%=b.getStuid() %>'>删除</a><a href='updateStu.html?stuid=<%=b.getStuid() %>'>更新</a></td>
            </tr>

        <%
        }
        %>
    </table>
    <br>
    <%
        if(page1.isHasPreviouse()){
    %>

            <table style="float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;">
                <td style="text-align:center">
                    <a href='classInformationManage.do?start=<%=(start - count) %>&claid=<%=classUid %>' style="text-decoration:none">
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
                        <a href='classInformationManage.do?start=<%=((i - 1) * count) %>&claid=<%=classUid %>' style="text-decoration:none">
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
                        <a href='classInformationManage.do?start=<%=((i - 1) * count) %>&claid=<%=classUid %>' style="text-decoration:none">
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
                        <a href='classInformationManage.do?start=<%=(start+count) %>&claid=<%=classUid %>' style="text-decoration:none">
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

