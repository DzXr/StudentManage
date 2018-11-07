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
    <title>Title</title>
</head>
<body>

<h2>班级管理</h2>
<div style='aligin:center;background-color:#eeeeee'>
  <sup>·+·+</sup><a href='main.html'>首页</a><sup>·+·+</sup><a href='clamanage.do'>班级管理</a><sup>·+·+</sup><a href='login.jsp'>退出登录</a><sup>·+·+</sup><br>
    <sup>.+.+.+.+.+</sup><a href='searchStu.html'>查找学生</a><sup>.+.+.+.+.+</sup><a href='addStu.html '>增加学生</a><sup>.+.+.+.+.+</sup><a href='courseManage.do'>课程管理</a><sup>.+.+.+.+.+</sup><a href='gradeManage.do'>成绩管理</a><br>

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

</body>
</html>
