package com.wzm.api.service;

import com.wzm.api.dao.ClassCourseMapper;
import com.wzm.api.entity.ClassCourse;
import com.wzm.api.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17 0017.
 */

public interface ClassCourseService {

    List<ClassCourse> selectByPrimaryKey(String claid);

    int insert(ClassCourse record);

    int deleteByPrimaryKey(String claid,String couid);

}
