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
</head>
<body>

<h1>学生信息管理系统</h1>
<div style="align :center; background-color:#eeeeee">
    <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
    <sup>.+.+.+.+.+</sup><a href='searchcla.html'>查找班级</a><sup>.+.+.+.+.+</sup><a href='addcla.html'>增加班级</a><sup>.+.+.+.+.+</sup><br>
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
</body>
</html>
