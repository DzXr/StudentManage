package com.wzm.api.entity;

public class ClassCourse {
    private Integer coursenum;

    private String claid;

    private String couid;

    public Integer getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(Integer coursenum) {
        this.coursenum = coursenum;
    }

    public String getClaid() {
        return claid;
    }

    public void setClaid(String claid) {
        this.claid = claid == null ? null : claid.trim();
    }

    public String getCouid() {
        return couid;
    }

    public void setCouid(String couid) {
        this.couid = couid == null ? null : couid.trim();
    }

    public ClassCourse()
    {

    }

    public ClassCourse(String claid,String couid)
    {
        this.claid = claid;
        this.couid = couid;

    }
}