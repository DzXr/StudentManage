package com.wzm.api.entity;

public class Class extends ClassKey {
    private String ins;

    private String major;

    private String teaid;

    private String syn;

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

    public String getTeaid() {
        return teaid;
    }

    public void setTeaid(String teaid) {
        this.teaid = teaid == null ? null : teaid.trim();
    }

    public String getSyn() {
        return syn;
    }

    public void setSyn(String syn) {
        this.syn = syn == null ? null : syn.trim();
    }

    public Class()
    {

    }

    public Class(String claid,String ins,String major,String teaid,String syn)
    {
         this.claid = claid;
         this.ins = ins;
         this.major = major;
         this.teaid = teaid;
         this.syn = syn;
    }
}