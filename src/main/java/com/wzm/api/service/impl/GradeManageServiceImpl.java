package com.wzm.api.service.impl;

import com.wzm.api.dao.GradeMapper;
import com.wzm.api.entity.Grade;
import com.wzm.api.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
@Service
public class GradeManageServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Grade selectGradeByPrimarySelective(String stuid, String couid) {
        return gradeMapper.selectGradeByPrimarySelective(stuid,couid);
    }

    @Override
    public int insert(Grade record) {
        return gradeMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Grade record) {
        return gradeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectCourseAVG(String claid, String couid) {
        return gradeMapper.selectCourseAVG(claid, couid);
    }

    @Override
    public int selectCourseGradeMax(String claid, String couid) {
        return gradeMapper.selectCourseGradeMax(claid, couid);
    }

    @Override
    public int selectCourseGradeMix(String claid, String couid) {
        return gradeMapper.selectCourseGradeMix(claid, couid);
    }
}
