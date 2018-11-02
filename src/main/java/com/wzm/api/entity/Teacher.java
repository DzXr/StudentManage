package com.wzm.api.entity;

public class Teacher extends TeacherKey {

    private String teaname;

    private String sex;

    private String ins;

    private String teapass;

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins == null ? null : ins.trim();
    }

    public String getTeapass() {
        return teapass;
    }

    public void setTeapass(String teapass) {
        this.teapass = teapass == null ? null : teapass.trim();
    }
}