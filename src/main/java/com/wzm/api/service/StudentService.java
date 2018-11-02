package com.wzm.api.service;


import com.wzm.api.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14 0014.
 */

public interface StudentService {

    List<Student> selectByPrimaryClaid(String claid);

    List<Student> selectByPrimaryClaidASC(String claid,Integer start,Integer count);

    int insertSelective(Student record);

    int getTotalByClaid(String claid);

    Student selectByPrimaryStuid(String stuid);

    int updateByPrimaryKeySelective(Student record);

    int deleteByPrimaryStuid(String stuid);
}
