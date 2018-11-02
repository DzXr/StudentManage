package com.wzm.api.dao;

import com.wzm.api.entity.Course;

import java.util.List;

public interface CourseMapper {


    int deleteByPrimaryKey(String couid);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByPrimarySelective();

    List<Course> selectByPrimaryCouname(String couname);

    Course selectByPrimaryKey(String couid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}