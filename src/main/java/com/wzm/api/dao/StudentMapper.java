package com.wzm.api.dao;

import com.wzm.api.entity.Student;

import java.util.List;

public interface StudentMapper {

    int deleteByPrimaryStuid(String stuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryStuid(String stuid);

    List<Student> selectByPrimaryClaid(String claid);

    List<Student> selectByPrimaryClaidASC(String claid,Integer start,Integer count);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int getTotalByClaid(String claid);
}