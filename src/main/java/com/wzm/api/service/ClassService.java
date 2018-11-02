package com.wzm.api.service;

import com.wzm.api.entity.Class;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26 0026.
 */
public interface ClassService {

    List<Class> selectByPrimaryTeaid(String teacherUid);

    int insert(Class record);

    Class selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(Class record);

    int deleteByPrimaryKey(String key);


}
