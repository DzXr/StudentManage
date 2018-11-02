package com.wzm.api.controllers;


import com.wzm.api.service.TeacherLoginService;
import com.wzm.api.service.TeacherUpdatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Administrator on 2018/10/11 0011.
 */

@RestController
@RequestMapping("")
public class TeacherController {

    @Autowired
    private TeacherLoginService teacherLoginService;

    @RequestMapping("/login.do")
    public String teacherLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");  //细节解决乱码 防止存入数据库中时为乱码
        request.setCharacterEncoding("utf-8");//解决乱码问题
        String teacherUid = request.getParameter("teaid");
        String passWord = request.getParameter("teapass");
        if(teacherLoginService.login(teacherUid,passWord))
        {
            HttpSession session = request.getSession();
            session.setAttribute("teaid",teacherUid);///将teaid保存在session中
            response.sendRedirect("/main.html");
        }
        else
            response.sendRedirect("/login.html");

        return null;
    }



    @Autowired
    private TeacherUpdatePasswordService teacherUpdatePasswordService;


    @RequestMapping("/updateteapassword.do")
    public String updateTeacherPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");  //细节解决乱码 防止存入数据库中时为乱码
        request.setCharacterEncoding("utf-8");//解决乱码问题
        String teacherUid = request.getParameter("teaid");
        String oldPassword= request.getParameter("oldpassword");
        String newPassword = request.getParameter("password");
        String reNewPassword = request.getParameter("password1");

        if(teacherUpdatePasswordService.updatePassword(teacherUid,oldPassword,newPassword,reNewPassword))
            response.sendRedirect("/login.html");
        else
            response.sendRedirect("/updateteapassword.html");

        return null;
    }




}
