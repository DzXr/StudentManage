package com.wzm.api.controllers;



import com.wzm.api.entity.Student;
import com.wzm.api.service.StudentService;
import com.wzm.api.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/14 0014.
 */
@RestController
@RequestMapping("")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //    班级信息管理页面  查询该班级所有学生
    @RequestMapping("/classInformationManage.do")
    public String classInformationManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        int start=0,count=7;
        try{
            start = Integer.parseInt(request.getParameter("start"));
        }catch (Exception e){
        }
        Page page = new Page(start,count);
        String classUid = request.getParameter("claid");
        int total = studentService.getTotalByClaid(classUid);
        page.setTotal(total);
        List<Student> list = studentService.selectByPrimaryClaidASC(classUid,start,count);


        HttpSession session = request.getSession();
        session.setAttribute("claid",classUid);///将claid保存在session中
        request.setAttribute("page",page);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/classInformationManage.jsp").forward(request,response);


        /*PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h2>班级管理</h2>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.jsp'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<sup>.+.+.+.+.+</sup><a href='searchStu.html'>查找学生</a><sup>.+.+.+.+.+</sup><a href='/addStu.html '>增加学生</a><sup>.+.+.+.+.+</sup><a href='/courseManage.do'>课程管理</a><sup>.+.+.+.+.+</sup><a href='/gradeManage.do'>成绩管理</a><br>");
        out.println("<table border=1>");
        out.println("<th width=8%>学号</th><th width=5%>姓名</th><th width=5%>性别</th><th width=15%>出生日期</th><th width=15%>家庭住址</th><th width=8%>政治面貌</th><th width=8%>操作</th>");
        for (Student b : list) {
            out.println("<tr>");
            out.println("<td>" + b.getStuid() + "</td>");
            out.println("<td>" + b.getStuname() + "</td>");
            out.println("<td>" + b.getStusex() + "</td>");
            String date = new SimpleDateFormat("yyyy-MM-dd").format(b.getStudate());
            out.println("<td>" + date + "</td>");
            out.println("<td>" + b.getStuadd() + "</td>");
            out.println("<td>" + b.getPolsta() + "</td>");
            out.println("<td><a href='/deleteStu.do?stuid=" + b.getStuid() + "'>删除</a><a href='/updateStu.html?stuid=" + b.getStuid() + "'>更新</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br>");
        if(page.isHasPreviouse()){
            out.print("<table style=\"float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/classInformationManage.do?start="+(start-count)+"&claid="+classUid+"' style=\"text-decoration:none\"><font size=\"2\">上一页</font></a></td></table>");
        }
        for (int i = 1; i <= totalPage; i++) {
            if (start == (i - 1) * count) {
                out.print("<table style=\"float:left; width:23px; height:15px; border:0px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/classInformationManage.do?start=" + ((i - 1) * count) + "&claid=" + classUid + "' style=\"text-decoration:none\"><font size=\"2\">" + i + "</font></a></td></table>");
            }
            else{
                out.print("<table style=\"float:left; width:23px; height:15px; border:1px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/classInformationManage.do?start=" + ((i - 1) * count) + "&claid=" + classUid + "' style=\"text-decoration:none\"><font size=\"2\">" + i + "</font></a></td></table>");
            }
        }
        if(page.isHasNext()) {
            out.print("<table style=\"float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/classInformationManage.do?start="+(start+count)+"&claid="+classUid+"' style=\"text-decoration:none\"><font size=\"2\">下一页</font></a></td></table>");
        }
        out.println("</div>");
        out.println("<html></body>");*/
        return null;
    }


    //    添加学生
    @RequestMapping("/addStu.do")
    public String addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        String studentUid = request.getParameter("stuid");
        String studentName = request.getParameter("stuname");
        String studentSex = request.getParameter("stusex");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date studentDate =  format.parse(request.getParameter("studate"));
        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        String studentAddress = request.getParameter("stuadd");
        Date admdate =  format.parse(request.getParameter("admdate"));
        String polsta = request.getParameter("polsta");
        Student student = new Student(studentUid,studentName,studentSex,studentDate,classUid,studentAddress,admdate,polsta);
        studentService.insertSelective(student);
        response.sendRedirect("/classInformationManage.do?claid="+classUid);
        return null;

    }


//    查询学生
    @RequestMapping("/searchStu.do")
    public String searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        String studentUid =  request.getParameter("stuid");
        Student student = studentService.selectByPrimaryStuid(studentUid);
        HttpSession session = request.getSession();
        session.setAttribute("student",student);
        request.getRequestDispatcher("/searchStu.jsp").forward(request,response);
        /*PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<h2>班级管理</h2>");
        out.println("<div style='aligin:cener;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.jsp'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<sup>.+.+.+.+.+</sup><a href='searchStu.html'>查找学生</a><sup>.+.+.+.+.+</sup><a href='/addStu.html '>增加学生</a><sup>.+.+.+.+.+</sup><a href='courseManage.do'>课程管理</a><sup>.+.+.+.+.+</sup><a href='gradeManage.html'>成绩管理</a><br>");
        out.println("<table border=1>");
        out.println("<th width=8%>学号</th><th width=5%>姓名</th><th width=5%>性别</th><th width=15%>出生日期</th><th width=15%>家庭住址</th><th width=8%>政治面貌</th><th width=8%>操作</th>");

        out.println("<tr>");
        out.println("<td>" + student.getStuid() + "</td>");
        out.println("<td>" + student.getStuname() + "</td>");
        out.println("<td>" + student.getStusex() + "</td>");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(student.getStudate());
        out.println("<td>" + date + "</td>");
        out.println("<td>" + student.getStuadd() + "</td>");
        out.println("<td>" + student.getPolsta() + "</td>");
        out.println("<td><a href='/deleteStu.do?stuid=" + student.getStuid() + "'>删除</a><a href='/updateStu.html?stuid=" + student.getStuid() + "'>更新</a></td>");
        out.println("</tr>");

        out.println("</table>");
        out.println("</div>");
        out.println("<html></body>");*/

        return null;

    }


//    更新学生信息
    @RequestMapping("/updateStu.do")
    public String updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {


        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题



        String studentUid = request.getParameter("stuid");
        String studentName = request.getParameter("stuname");
        String studentSex = request.getParameter("stusex");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date studentDate =  format.parse(request.getParameter("studate"));
        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        String studentAddress = request.getParameter("stuadd");
        Date admdate =  format.parse(request.getParameter("admdate"));
        String polsta = request.getParameter("polsta");
        Student student = new Student(studentUid,studentName,studentSex,studentDate,classUid,studentAddress,admdate,polsta);


        studentService.updateByPrimaryKeySelective(student);
        response.sendRedirect("/classInformationManage.do?claid=" + classUid +" ");
        return null;
    }


//    删除学生
    @RequestMapping("/deleteStu.do")
    public String deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();

        String Stuid=request.getParameter("stuid");
        studentService.deleteByPrimaryStuid(Stuid);
        response.sendRedirect("/classInformationManage.do?claid=" + classUid +" ");
        return null;
    }


}
