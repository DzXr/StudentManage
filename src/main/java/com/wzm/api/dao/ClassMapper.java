package com.wzm.api.dao;

import com.wzm.api.entity.Class;
import com.wzm.api.entity.ClassKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {

    int deleteByPrimaryKey(String key);

    int insert(Class record);

    int insertSelective(Class record);

    int getTotalByTeacherUid(String teacherUid);

    Class selectByPrimaryKey(String key);

    List<Class> selectByPrimaryTeaid(String teaid,int start,int count);

    List<Class> selectByCondition(Class record);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}