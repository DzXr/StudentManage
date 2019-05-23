package com.wzm.api.controllers;

import com.wzm.api.entity.Class;
import com.wzm.api.service.ClassService;
import com.wzm.api.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        int start=0,count=7;
        try{
            start = Integer.parseInt(request.getParameter("start"));
        }catch (Exception e){
        }
        Page page = new Page(start,count);
        int total = classService.getTotalByTeacherUid(teacherUid);
        page.setTotal(total);
        int totalPage = page.getTotalPage();


        List<Class> list = classService.selectByPrimaryTeaid(teacherUid,start,count);
        request.setAttribute("list",list);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/clamanage.jsp").forward(request,response);


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
        HttpSession session = request.getSession();
        session.setAttribute("classes",classes);
        request.getRequestDispatcher("/searchCla.jsp").forward(request,response);


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
