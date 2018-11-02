package com.wzm.api.dao;

import com.wzm.api.entity.Teacher;
import com.wzm.api.entity.TeacherKey;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

    Teacher selectpassByPrimaryid(String teaid);

    int deleteByPrimaryKey(TeacherKey key);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(TeacherKey key);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}