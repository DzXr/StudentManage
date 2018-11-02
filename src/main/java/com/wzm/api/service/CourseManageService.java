package com.wzm.api.service;

import com.wzm.api.entity.ClassCourse;
import com.wzm.api.entity.Course;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
public interface CourseManageService {

    Course selectByPrimaryKey(String couid);

    List<Course> selectByPrimarySelective();

    int insert(Course record);

    List<Course> selectByPrimaryCouname(String couname);

}
