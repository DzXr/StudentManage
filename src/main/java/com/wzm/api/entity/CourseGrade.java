package com.wzm.api.entity;

/**
 * Created by Administrator on 2018/11/6 0006.
 */
public class CourseGrade {

    private String courserName;

    private Integer courseAVG;

    private Integer courseMax;

    private Integer courseMin;

    public String getCourserName() {
        return courserName;
    }

    public void setCourserName(String courserName) {
        this.courserName = courserName;
    }

    public Integer getCourseAVG() {
        return courseAVG;
    }

    public void setCourseAVG(Integer courseAVG) {
        this.courseAVG = courseAVG;
    }

    public Integer getCourseMax() {
        return courseMax;
    }

    public void setCourseMax(Integer courseMax) {
        this.courseMax = courseMax;
    }

    public Integer getCourseMin() {
        return courseMin;
    }

    public void setCourseMin(Integer courseMin) {
        this.courseMin = courseMin;
    }


}
