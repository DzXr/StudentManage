package com.wzm.api.service.impl;

import com.wzm.api.dao.ClassCourseMapper;
import com.wzm.api.entity.ClassCourse;
import com.wzm.api.service.ClassCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
@Service
public class ClassCourseServiceImpl implements ClassCourseService{

    @Autowired
    private ClassCourseMapper classCourseMapper;

    @Override
    public List<ClassCourse> selectByPrimaryKey(String claid) {
        return classCourseMapper.selectByPrimaryKey(claid);
    }

    @Override
    public int insert(ClassCourse record) {
        return classCourseMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String claid, String couid) {
        return classCourseMapper.deleteByPrimaryKey(claid,couid);
    }


}
