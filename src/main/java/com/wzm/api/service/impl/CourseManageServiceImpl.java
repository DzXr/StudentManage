package com.wzm.api.service.impl;

import com.wzm.api.dao.CourseMapper;
import com.wzm.api.entity.Course;
import com.wzm.api.service.CourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
@Service
public class CourseManageServiceImpl implements CourseManageService{

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public Course selectByPrimaryKey(String couid) {
        return courseMapper.selectByPrimaryKey(couid);
    }

    @Override
    public List<Course> selectByPrimarySelective() {
        return courseMapper.selectByPrimarySelective();
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public List<Course> selectByPrimaryCouname(String couname) {
        return courseMapper.selectByPrimaryCouname(couname);
    }
}
