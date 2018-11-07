<%@ page import="com.wzm.api.entity.Class" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息管理系统</h1>
    <div style='aligin:center;background-color:#eeeeee'>
        <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
        <sup>.+.+.+.+.+</sup><a href='searchcla.html'>查找班级</a><sup>.+.+.+.+.+</sup><a href='addcla.html'>增加班级</a><sup>.+.+.+.+.+</sup><br>
        <table border=1>
            <th width=10%>班级号</th><th width=10%>院系</th><th width=10%>专业</th><th width=10%>操作</th>
            <tr>
                <%
                    if(session.getAttribute("classes") != null)
                    {
                        Class classes = (Class)session.getAttribute("classes");
                %>
                    <td><a href='classInformationManage.do?claid=<%=classes.getClaid() %>'><%=classes.getClaid() %></a></td>
                    <td><%=classes.getIns() %></td>
                    <td><%=classes.getMajor() %></td>
                    <td><a href='deletecla.do?claid=<%=classes.getClaid() %>'>删除</a><a href='updatecla.html?claid=<%=classes.getClaid() %>'>更新</a></td>
                <%
                    }
                %>
            </tr>
        </table>
        <%
            if(session.getAttribute("classes") == null)
            {
        %>
        <span>抱歉！没有该班级</span>
        <a href="searchcla.html">重新查找</a>
        <%
            }
        %>
    </div>
</body>
</html>
