package com.wzm.api.dao;

import com.wzm.api.entity.ClassCourse;

import java.util.List;

public interface ClassCourseMapper {

    int deleteByPrimaryKey(String claid,String couid);
    //这里是传递的是多参数所以在.xml中就不能使用parameterType， 改用#｛index｝是第几个就用第几个的索引，索引从0开始
    //或者可以使用注解方式
    // int deleteByPrimaryKey(@Param("claid")String claid,@Param("couid")String couid);

    int insert(ClassCourse record);

    int insertSelective(ClassCourse record);

    List<ClassCourse> selectByPrimaryKey(String claid);

    List<ClassCourse> selectByPrimaryKeySelective(String claid);

    int updateByPrimaryKeySelective(ClassCourse record);

    int updateByPrimaryKey(ClassCourse record);
}