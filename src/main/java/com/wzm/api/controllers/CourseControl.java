package com.wzm.api.controllers;

import com.wzm.api.entity.ClassCourse;
import com.wzm.api.entity.Course;
import com.wzm.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/17 0017.
 */

@RestController
@RequestMapping("")
public class CourseControl {

    @Autowired
    private CourseManageService courseManageService;

    @Autowired
    private ClassCourseService classCourseService;



//    课程管理查询该班级选修的课程
    @RequestMapping("/courseManage.do")
    public String courseManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        List<Course> courseList = new ArrayList<Course>();
        List<ClassCourse> list = classCourseService.selectByPrimaryKey(classUid);
        for (ClassCourse b : list){
            Course course = courseManageService.selectByPrimaryKey(b.getCouid());
            courseList.add(course);
        }
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("/courseManage.jsp").forward(request,response);

        return null;
    }


//    选择添加班级课程界面
    @RequestMapping("/addClassCourse.do")
    public String addClassCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        List<ClassCourse> classCourseList = classCourseService.selectByPrimaryKey(classUid);
        List<Course> courseList = courseManageService.selectByPrimarySelective();
        session.setAttribute("classCourseList",classCourseList);
        session.setAttribute("courseList",courseList);
        request.getRequestDispatcher("/addClassCourse.jsp").forward(request,response);

        /*PrintWriter out = response.getWr  iter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.jsp'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<table border=1>");
        out.println("<th width=10%>课程号</th><th width=10%>课程名</th><th width=10%>学分</th><th width=5%>操作</th>");
        out.println("<sup>·+·+</sup><a href='/addCourse.html'>开设课程</a><sup>·+·+</sup><a href='/searchCourse.html'>查询课程</a><br>");
        for (Course b : courseList) {
            out.println("<tr>");
            course = courseManageService.selectByPrimaryKey(b.getCouid());
            int judge = 0;
            for(ClassCourse c : classCourseList)
            {

                if(b.getCouid().equals(c.getCouid()))
                {

                    judge = 1;
                    break;
                }
            }
            if(judge == 1 )
                continue;
            out.println("<td>" + course.getCouid() + "</td>");
            out.println("<td>" + course.getCouname() + "</td>");
            out.println("<td>" + course.getCredit() + "</td>");
            out.println("<td><a href='/addCourseToClass.do?claid="+classUid+"&couid="+ b.getCouid()+"'>添加</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<html></body>");*/

        return null;
    }


//    添加班级选修的课程
    @RequestMapping("/addCourseToClass.do")
    public String addCourseToClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();
        String courseUid = request.getParameter("couid");
        classCourseService.insert(new ClassCourse(classUid,courseUid));
        response.sendRedirect("/addClassCourse.do");
        return null;
    }


//    开设新的课程
    @RequestMapping("/addCourse.do")
    public String addNewCuorse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        String courseUid = request.getParameter("couid");
        String courseName  = request.getParameter("couname");
        Integer credit = Integer.parseInt(request.getParameter("credit"));
        String remark =  request.getParameter("remark");
        Course course = new Course(courseUid,courseName,credit,remark);
        courseManageService.insert(course);
        response.sendRedirect("/addClassCourse.do");
        return null;
    }



//    在班级未选修的课程中查询课程
    @RequestMapping("/searchCourse.do")
    public String searchCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        String courseName =  request.getParameter("couname");
        HttpSession session = request.getSession();
        String classUid = session.getAttribute("claid").toString();

        List<ClassCourse> classCourseList = classCourseService.selectByPrimaryKey(classUid);
        List<Course> courseList = courseManageService.selectByPrimaryCouname(courseName);
        session.setAttribute("courseList",courseList);
        session.setAttribute("classCourseList",classCourseList);
        request.getRequestDispatcher("/searchCourse.jsp").forward(request,response);

        /*PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.jsp'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<table border=1>");
        out.println("<th width=10%>课程号</th><th width=10%>课程名</th><th width=10%>学分</th><th width=5%>操作</th>");
        out.println("<sup>·+·+</sup><a href='/addCourse.html'>开设课程</a><sup>·+·+</sup><br>");
        for (Course b : courseList) {
            out.println("<tr>");
            course = courseManageService.selectByPrimaryKey(b.getCouid());
            int judge = 0;
            for(ClassCourse c : classCourseList)
            {

                if(b.getCouid().equals(c.getCouid()))
                {

                    judge = 1;
                    break;
                }
            }
            if(judge == 1 )
                continue;
            out.println("<td>" + course.getCouid() + "</td>");
            out.println("<td>" + course.getCouname() + "</td>");
            out.println("<td>" + course.getCredit() + "</td>");
            out.println("<td><a href='/addCourseToClass.do?claid="+classUid+"&couid="+ b.getCouid()+"'>添加</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<html></body>");*/
        return null;
    }


//    删除班级选修课程
    @RequestMapping("/deleteclasscourse.do")
    public String deleteClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String classUid = request.getParameter("claid");
        String courseUid = request.getParameter("couid");
        classCourseService.deleteByPrimaryKey(classUid,courseUid);
        response.sendRedirect("/courseManage.do");
        return null;
    }




}
