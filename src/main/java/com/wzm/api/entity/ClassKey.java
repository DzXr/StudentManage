package com.wzm.api.entity;

public class ClassKey {

    private Integer clanum;

    protected String claid;

    public Integer getClanum() {
        return clanum;
    }

    public void setClanum(Integer clanum) {
        this.clanum = clanum;
    }

    public String getClaid() {
        return claid;
    }

    public void setClaid(String claid) {
        this.claid = claid == null ? null : claid.trim();
    }
}