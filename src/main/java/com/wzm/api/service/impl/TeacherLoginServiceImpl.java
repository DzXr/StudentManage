package com.wzm.api.service.impl;

import com.wzm.api.dao.TeacherMapper;
import com.wzm.api.entity.Teacher;
import com.wzm.api.service.TeacherLoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by DING on 18/10/21.
 */
@Service
public class TeacherLoginServiceImpl implements TeacherLoginService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public boolean login(String teacherUid, String password) {
        // 1 校验参数
        if(StringUtils.isEmpty(teacherUid) || StringUtils.isEmpty(password)){
            return false;
        }
        // 2 逻辑判断
        Teacher teacher = teacherMapper.selectpassByPrimaryid(teacherUid);
        if(teacher != null && Objects.equals(teacher.getTeapass(), password)){
            return true;
        }
        return false;
    }
}
