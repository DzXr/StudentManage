package com.wzm.api.entity;

public class Course {
    private String couid;

    private String couname;

    private Integer credit;

    private String remark;


    public String getCouid() {
        return couid;
    }

    public void setCouid(String couid) {
        this.couid = couid == null ? null : couid.trim();
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname == null ? null : couname.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


    public Course()
    {

    }
    public Course(String couid,String couname,Integer credit,String remark)
    {
        this.couid = couid;
        this.couname = couname;
        this.credit = credit;
        this.remark = remark;
    }
}