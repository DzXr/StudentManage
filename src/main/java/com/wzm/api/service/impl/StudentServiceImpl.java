package com.wzm.api.service.impl;

import com.wzm.api.dao.StudentMapper;
import com.wzm.api.entity.Class;
import com.wzm.api.entity.Student;
import com.wzm.api.service.ClassService;
import com.wzm.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassService classService;

    @Override
    public List<Student> selectByPrimaryClaid(String classUid) {
        return studentMapper.selectByPrimaryClaid(classUid);
    }

    @Override
    public List<Student> selectByPrimaryClaidASC(String claid, Integer start, Integer count) {
        return studentMapper.selectByPrimaryClaidASC(claid, start, count);
    }

    @Override
    public int insertSelective(Student student) {

        Class classes = classService.selectByPrimaryKey(student.getClaid());
        Student student1 = new Student(student.getStuid(),student.getStuname(),student.getStusex(),student.getStudate(),classes.getIns(),classes.getMajor(),student.getClaid(),student.getStuadd(),student.getAdmdate(),student.getPolsta());
        return studentMapper.insertSelective(student1);

    }

    @Override
    public int getTotalByClaid(String claid) {
        return studentMapper.getTotalByClaid(claid);
    }

    @Override
    public Student selectByPrimaryStuid(String studentUid) {
        return studentMapper.selectByPrimaryStuid(studentUid);
    }

    @Override
    public int updateByPrimaryKeySelective(Student student) {

        Class classes = classService.selectByPrimaryKey(student.getClaid());
        Student student1 = new Student(student.getStuid(),student.getStuname(),student.getStusex(),student.getStudate(),classes.getIns(),classes.getMajor(),student.getClaid(),student.getStuadd(),student.getAdmdate(),student.getPolsta());
        return studentMapper.updateByPrimaryKeySelective(student1);
    }

    @Override
    public int deleteByPrimaryStuid(String stuid) {
        return studentMapper.deleteByPrimaryStuid(stuid);
    }


}
