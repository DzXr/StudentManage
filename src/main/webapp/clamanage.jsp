<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5 0005
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@page import="com.wzm.api.entity.Class" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.wzm.api.util.Page" %>
    <title>Title</title>
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
                        <option value="searchcla.html">查找班级</option>
                        <option value="addcla.html">增加班级</option>
                        <option value="login.html">退出登录</option>
                    </select>
                        </div>
      <div class="target-2">学生信息管理系统</div>
     
    <div class="target-3">
        <table border=1>
            <th width=10%>班级号</th><th width=10%>院系</th><th width=10%>专业</th><th width=10%>操作</th>
        <%
            List<Class> list = (List)request.getAttribute("list");
            Page page1 = (Page)request.getAttribute("page");
            int start = page1.getStart();
            int count = page1.getCount();
            int totalPage = page1.getTotalPage();
            for (Class b : list){
        %>
        <tr>
            <td><a href="classInformationManage.do?claid=<%=b.getClaid()%>"><%=b.getClaid()%></a></td>
            <td><%=b.getIns()%></td>
            <td><%=b.getMajor()%></td>
            <td>
                <a href="deletecla.do?claid=<%=b.getClaid()%>">删除</a>
                <a href="updatecla.html?claid=<%=b.getClaid()%>">更新</a>
            </td>
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
            <a href="clamanage.do?start=<%=(start - count)%>" style="text-decoration:none">
                <span style="font-size:14px">上一页</span>
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
                    <a href="clamanage.do?start=<%=((i - 1) * count)%>" style="text-decoration:none">
                        <span style="font-size:14px"><%=i %></span>
                    </a>
                </td>
            </table>
    <%
            }
            else{
    %>
            <table style="float:left; width:23px; height:15px; border:1px solid grey; margin-right:3px;">
                <td style="text-align:center">
                    <a href="clamanage.do?start=<%=((i - 1) * count)%>" style="text-decoration:none">
                        <span style="font-size:14px"><%=i %></span>
                    </a>
                </td>
            </table>
    <%
            }
        }
        if(page1.isHasNext()){
    %>
            <table style="float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;">
                <td style="text-align:center">
                    <a href="clamanage.do?start=<%=(start + count)%>" style="text-decoration:none">
                        <span style="font-size:14px">下一页</span>
                    </a>
                </td>
            </table>
    <%
        }
    %>
                    </table>                    
    </div>
    
</div>
<div>
        <marquee behavior="alternate">
            <span style="color:red; font-size:18px;font-weight:bold;">欢迎来到学生信息管理系统</span>
            </marquee></div>
</body>
</html>
