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
