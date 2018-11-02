package com.wzm.api.entity;

public class StudentKey {
     Integer stunum;

     String stuid;

    public Integer getStunum() {
        return stunum;
    }

    public void setStunum(Integer stunum) {
        this.stunum = stunum;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }
}