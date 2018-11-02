package com.wzm.api.service;


import com.wzm.api.entity.Grade;

/**
 * Created by Administrator on 2018/10/19 0019.
 */

public interface GradeService  {

    Grade selectGradeByPrimarySelective(String stuid, String couid);

    int insert(Grade record);

    int updateByPrimaryKey(Grade record);

    int selectCourseAVG(String claid,String couid);

    int selectCourseGradeMax(String claid,String couid);

    int selectCourseGradeMix(String claid,String couid);
}
