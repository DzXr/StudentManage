package com.wzm.api.service.impl;

import com.wzm.api.dao.TeacherMapper;
import com.wzm.api.entity.Teacher;
import com.wzm.api.service.TeacherUpdatePasswordService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
@Service
public class TeacherUpdatePasswordServiceImpl implements TeacherUpdatePasswordService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public boolean updatePassword(String teacherUid,String password,String newPassword,String reNewPassword)
    {
        if((StringUtils.isEmpty(teacherUid) || StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(reNewPassword)))
        {
            return false;
        }
            Teacher newTeacher = new Teacher();
            newTeacher.setTeaid(teacherUid);
            newTeacher.setTeapass(newPassword);
            Teacher teacher = teacherMapper.selectpassByPrimaryid(teacherUid);
            if (teacher.getTeapass().equals(password) && newPassword.equals(reNewPassword)) {
                teacherMapper.updateByPrimaryKeySelective(newTeacher);
                return true;
            } else
                return false;
    }
}
