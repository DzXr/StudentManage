package com.wzm.api.entity;

import java.util.Date;

public class Student extends StudentKey {
    private String stuname;

    private String stusex;

    private Date studate;

    private String ins;

    private String major;

    private String claid;

    private String stuadd;

    private Date admdate;

    private String polsta;

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
    }

    public Date getStudate() {
        return studate;
    }

    public void setStudate(Date studate) {
        this.studate = studate;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins == null ? null : ins.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getClaid() {
        return claid;
    }

    public void setClaid(String claid) {
        this.claid = claid == null ? null : claid.trim();
    }

    public String getStuadd() {
        return stuadd;
    }

    public void setStuadd(String stuadd) {
        this.stuadd = stuadd == null ? null : stuadd.trim();
    }

    public Date getAdmdate() {
        return admdate;
    }

    public void setAdmdate(Date admdate) {
        this.admdate = admdate;
    }

    public String getPolsta() {
        return polsta;
    }

    public void setPolsta(String polsta) {
        this.polsta = polsta == null ? null : polsta.trim();
    }


    public Student(String stuid, String stuname, String stusex, Date studate, String ins, String maior, String claid, String stuadd, Date admdate, String polsta) {

        this.stuid = stuid;
        this.stuname = stuname;
        this.stusex = stusex;
        this.studate = studate;
        this.ins = ins;
        this.major = maior;
        this.claid = claid;
        this.stuadd = stuadd;
        this.admdate = admdate;
        this.polsta = polsta;

    }
    public Student(String stuid, String stuname, String stusex, Date studate,String claid,String stuadd, Date admdate, String polsta) {

        this.stuid = stuid;
        this.stuname = stuname;
        this.stusex = stusex;
        this.studate = studate;
        this.claid = claid;
        this.stuadd = stuadd;
        this.admdate = admdate;
        this.polsta = polsta;

    }

    public Student()
    {

    }
}