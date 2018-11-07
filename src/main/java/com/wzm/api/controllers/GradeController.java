package com.wzm.api.controllers;

import com.wzm.api.entity.*;
import com.wzm.api.service.*;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */


@RestController
@RequestMapping("")
public class GradeController {

    @Autowired
    private ClassCourseService classCourseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseManageService courseManageService;
    @Autowired
    private GradeService gradeService;


    @RequestMapping("/gradeManage.do")
    public String searchClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        int start=0,count=7;
        try{
            start = Integer.parseInt(request.getParameter("start"));
        }catch (Exception e){
        }
        Page page = new Page(start,count);
        int total = studentService.getTotalByClaid(classUid);
        page.setTotal(total);
        List<ClassCourse> classCoursesList = classCourseService.selectByPrimaryKey(classUid);
        List<Student> studentsList = studentService.selectByPrimaryClaidASC(classUid,start,count);
        List<Course> courseList =  new ArrayList<Course>();
        List<Grade> gradeList = new ArrayList<Grade>();
        for (ClassCourse b : classCoursesList){
            Course course = courseManageService.selectByPrimaryKey(b.getCouid());
            courseList.add(course);
        }
        for (Student c : studentsList){
            for (ClassCourse b : classCoursesList){
                Grade grade = gradeService.selectGradeByPrimarySelective(c.getStuid(), b.getCouid());
                gradeList.add(grade);
            }
        }
        request.setAttribute("classCoursesList",classCoursesList);
        request.setAttribute("studentsList",studentsList);
        request.setAttribute("courseList",courseList);
        request.setAttribute("gradeList",gradeList);
        request.setAttribute("page",page);
        request.getRequestDispatcher("gradeManage.jsp").forward(request,response);


        /*PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.jsp'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<sup>·+·+</sup><a href='/checkCourseGrade.do'>查看各科成绩</a>");
        out.println("<table border=1>");
        out.print("<th width=6%>学生号</th><th width=5%>学生名</th>");
        for (ClassCourse b : classCoursesList) {

            String couid = b.getCouid();
            String coursename = courseManageService.selectByPrimaryKey(couid).getCouname();
            out.print("<th width=8%>" + coursename + "</th>");
        }
        out.println("<th width=7%>操作</th>");
        for (Student c : studentsList) {
            out.println("<tr>");
            out.println("<td>" + c.getStuid() + "</td>");
            out.println("<td>" + c.getStuname() + "</td>");
            for (ClassCourse b : classCoursesList) {
                String stuid = c.getStuid();
                String couid = b.getCouid();
                if (gradeService.selectGradeByPrimarySelective(stuid, couid) != null)
                    out.println("<td> " + gradeService.selectGradeByPrimarySelective(stuid, couid).getGrade() + "</td>");
                else
                    out.println("<td></td>");


            }
            out.println("<td><a href='/addGradeHtml.do?claid=" + classUid + "&stuid=" + c.getStuid() + "'>录入成绩</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br>");
        if(page.isHasPreviouse()){
            out.print("<table style=\"float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/gradeManage.do?start="+(start-count)+"' style=\"text-decoration:none\"><font size=\"2\">上一页</font></a></td></table>");
        }
        for (int i = 1; i <= totalPage; i++) {
            if (start == (i - 1) * count) {
                out.print("<table style=\"float:left; width:23px; height:15px; border:0px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/gradeManage.do?start=" + ((i - 1) * count) + "' style=\"text-decoration:none\"><font size=\"2\">" + i + "</font></a></td></table>");
            }
            else{
                out.print("<table style=\"float:left; width:23px; height:15px; border:1px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/gradeManage.do?start=" + ((i - 1) * count) + "' style=\"text-decoration:none\"><font size=\"2\">" + i + "</font></a></td></table>");
            }
        }
        if(page.isHasNext()) {
            out.print("<table style=\"float:left; width:50px; height:20px; border:1px solid grey; margin-right:3px;\"><td style=\"text-align:center\"><a href='/gradeManage.do?start="+(start+count)+"' style=\"text-decoration:none\"><font size=\"2\">下一页</font></a></td></table>");
        }
        out.println("</div>");
        out.println("<html></body>");*/

        return null;
    }





    @RequestMapping("/addGradePage.do")
    public String addGradeHtml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        String classUid = request.getParameter("claid");
        String studentUid = request.getParameter("stuid");
        HttpSession session = request.getSession();
        session.setAttribute("stuid", studentUid);
        List<ClassCourse> classCoursesList = classCourseService.selectByPrimaryKey(classUid);
        List<Course> courseList = new ArrayList<Course>();
        for (ClassCourse b : classCoursesList){
            courseList.add(courseManageService.selectByPrimaryKey(b.getCouid()));
        }
        request.setAttribute("classCoursesList",classCoursesList);
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("addGradePage.jsp").forward(request,response);

        /*PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/jsp.html'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<table border=1>");
        out.println("<div align =\"center\" style=\"text-align:center;background-color:#eeeeee\">");
        out.println("<form action=\"/addGrade.do\" method=\"post\">");
        char text = 'a';
        for (ClassCourse b : classCoursesList) {
            String couid = b.getCouid();
            String coursename = courseManageService.selectByPrimaryKey(couid).getCouname();
            text = (char) (text + 1);
            out.println("<p>" + coursename + "：<input type=\"text\" name=\"" + text + "\"/>" + "</p>");
            System.out.println(text);
        }
        out.println("<input type=\"submit\" value=\"提交\"/>");
        out.println("</form>");
        out.println("</div>");
        out.println("<html></body>");*/
        return null;

    }




    @RequestMapping("/addGrade.do")
    public String addGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        String studentUid = session.getAttribute("stuid").toString();
        List<ClassCourse> classCoursesList = classCourseService.selectByPrimaryKey(classUid);
        char text = 'a';
        for (ClassCourse b : classCoursesList){
            text = (char) (text + 1);
            Integer grade = Integer.parseInt(request.getParameter(String.valueOf(text)));
            if(gradeService.selectGradeByPrimarySelective(studentUid, b.getCouid()) != null){
                gradeService.updateByPrimaryKey(new Grade(studentUid, classUid, b.getCouid(), grade));
            }else
                gradeService.insert(new Grade(studentUid, classUid, b.getCouid(), grade));
        }
        response.sendRedirect("/gradeManage.do");
        return null;
    }




    @RequestMapping("/checkCourseGrade.do")
    public String checkCourseGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        List<ClassCourse> classCoursesList = classCourseService.selectByPrimaryKey(classUid);
        List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
        for (ClassCourse b : classCoursesList){
            CourseGrade courseGrade = new CourseGrade();
            courseGrade.setCourserName(courseManageService.selectByPrimaryKey(b.getCouid()).getCouname());
            courseGrade.setCourseAVG(gradeService.selectCourseAVG(classUid,b.getCouid()));
            courseGrade.setCourseMax(gradeService.selectCourseGradeMax(classUid,b.getCouid()));
            courseGrade.setCourseMin(gradeService.selectCourseGradeMix(classUid,b.getCouid()));
            courseGradeList.add(courseGrade);
        }
        request.setAttribute("courseGradeList",courseGradeList);
        request.getRequestDispatcher("checkCourseGrade.jsp").forward(request,response);


        /*PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='align:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.jsp'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<table border=1>");
        out.print("<th width=7%>课程</th><th width=5%>平均成绩</th><th width=5%>最高分</th><th width=5%>最低分</th>");
        for (ClassCourse b : classCoursesList) {
            out.println("<tr>");
            out.println("<td>" + courseManageService.selectByPrimaryKey(b.getCouid()).getCouname()+ "</td>");
            out.println("<td>" + gradeService.selectCourseAVG(classUid,b.getCouid()) + "</td>");
            out.println("<td>" + gradeService.selectCourseGradeMax(classUid,b.getCouid()) + "</td>");
            out.println("<td>" + gradeService.selectCourseGradeMix(classUid,b.getCouid()) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<html></body>");*/

        return null;


    }


}