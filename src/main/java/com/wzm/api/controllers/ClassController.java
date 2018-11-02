package com.wzm.api.controllers;

import com.wzm.api.entity.Class;
import com.wzm.api.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@RestController
@RequestMapping("")
public class ClassController {



    @Autowired
    private ClassService classService;


    //    班级管理界面查询该用户管理的所有班级
    @RequestMapping("/clamanage.do")
    public String  selectClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String teacherUid = session.getAttribute("teaid").toString();
        List<Class> list = classService.selectByPrimaryTeaid(teacherUid);
        PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.html'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<sup>.+.+.+.+.+</sup><a href='searchcla.html'>查找班级</a><sup>.+.+.+.+.+</sup><a href='addcla.html'>增加班级</a><sup>.+.+.+.+.+</sup><br>");
        out.println("<table border=1>");
        out.println("<th width=10%>班级号</th><th width=10%>院系</th><th width=10%>专业</th><th width=10%>操作</th>");
        for (Class b : list) {
            out.println("<tr>");
            out.println("<td><a href='/classInformationManage.do?claid=" + b.getClaid() + "'>" + b.getClaid() + "</a></td>");
            out.println("<td>" + b.getIns() + "</td>");
            out.println("<td>" + b.getMajor() + "</td>");
            out.println("<td><a href='/deletecla.do?claid=" + b.getClaid() + "'>删除</a><a href='/updatecla.html?claid=" + b.getClaid() + "'>更新</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<html></body>");

        return null;
    }



//    添加班级

    @RequestMapping("/addcla.do")
    public String addClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题

        HttpSession session = request.getSession();
        String teacherUid = session.getAttribute("teaid").toString();
        String classUid = request.getParameter("claid");
        String ins  = request.getParameter("ins");
        String major = request.getParameter("major");
        String syn = request.getParameter("syn");
        Class classes = new Class(classUid,ins,major,teacherUid,syn);
        classService.insert(classes);

        response.sendRedirect("/clamanage.do");


        return null;
    }



//    查询班级
    @RequestMapping("/searchcla.do")
    public String searchClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");//解决乱码问题
        String classUid =  request.getParameter("claid");
        Class classes = classService.selectByPrimaryKey(classUid);
        PrintWriter out = response.getWriter();
        out.println("<html></body>");
        out.println("<h1>学生信息管理系统</h1>");
        out.println("<div style='aligin:center;background-color=#eeeeee'>");
        out.println("<sup>·+·+</sup><a href='/main.html'>首页</a><sup>·+·+</sup><a href='/clamanage.do'>班级管理</a><sup>·+·+</sup><a href='/login.html'>退出登录</a><sup>·+·+</sup><br>");
        out.println("<sup>.+.+.+.+.+</sup><a href='searchcla.html'>查找班级</a><sup>.+.+.+.+.+</sup><a href='addcla.html'>增加班级</a><sup>.+.+.+.+.+</sup><br>");
        out.println("<table border=1>");
        out.println("<th width=10%>班级号</th><th width=10%>院系</th><th width=10%>专业</th><th width=10%>操作</th>");
        out.println("<tr>");
        out.println("<td><a href='/classInformationManage.do?claid=" + classes.getClaid() + "'>" + classes.getClaid() + "</a></td>");
        out.println("<td>" + classes.getIns() + "</td>");
        out.println("<td>" + classes.getMajor() + "</td>");
        out.println("<td><a href='/deletecla.do?claid=" + classes.getClaid() + "'>删除</a><a href='/updatecla.html?claid=" + classes.getClaid() + "'>更新</a></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</div>");
        out.println("<html></body>");

        return null;

    }



//    更新班级信息
    @RequestMapping("/updatecla.do")
    public String updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");  //细节  解决乱码 防止存入数据库中时为乱码
        request.setCharacterEncoding("utf-8");//解决乱码问题
        String classUid = request.getParameter("claid");
        String ins  = request.getParameter("ins");
        String major = request.getParameter("major");
        String teacherUid =request.getParameter("teaid");
        String syn = request.getParameter("syn");
        Class classes = new Class(classUid,ins,major,teacherUid,syn);

        classService.updateByPrimaryKeySelective(classes);
        response.sendRedirect("/clamanage.do");
        return null;
    }



    @RequestMapping("/deletecla.do")
    public String deleteClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String classUid = request.getParameter("claid");
        System.out.println(classUid);
        classService.deleteByPrimaryKey(classUid);
        response.sendRedirect("/clamanage.do");
        return null;
    }



}
