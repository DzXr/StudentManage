package com.wzm.api.entity;

public class Grade {
    private Integer num;

    private String stuid;

    private String claid;

    private String couid;

    private Integer grade;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Grade()
    {

    }
    public Grade(String stuid,String claid,String couid,Integer grade)
    {
        this.stuid = stuid;
        this.claid  =claid;
        this.couid = couid;
        this.grade = grade;
    }
}