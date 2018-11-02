package com.wzm.api.entity;

public class TeacherKey {
    private Integer teanum;

    private String teaid;

    public Integer getTeanum() {
        return teanum;
    }

    public void setTeanum(Integer teanum) {
        this.teanum = teanum;
    }

    public String getTeaid() {
        return teaid;
    }

    public void setTeaid(String teaid) {
        this.teaid = teaid == null ? null : teaid.trim();
    }
}