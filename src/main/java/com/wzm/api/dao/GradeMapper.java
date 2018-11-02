package com.wzm.api.dao;

import com.wzm.api.entity.Grade;

public interface GradeMapper {


    int deleteByPrimaryKey(Integer num);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer num);

    int selectCourseAVG(String claid,String couid);

    int selectCourseGradeMax(String claid,String couid);

    int selectCourseGradeMix(String claid,String couid);

    Grade selectGradeByPrimarySelective(String stuid,String couid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}