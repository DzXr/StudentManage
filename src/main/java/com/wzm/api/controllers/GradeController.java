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
 * Created by Administrator on 2019/10/19 0019.
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
        return null;


    }


}