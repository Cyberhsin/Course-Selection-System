package com.course.selection.Entity;

import javax.persistence.*;

/**
 * Created by Shinlee on 2016/12/31.
 */
@Entity
@Table(name = "course", schema = "course_selection", catalog = "")
public class CourseEntity {
    private String courseId;
    private String courseNum;
    private String courseName;
    private Integer courseCount;

    @Id
    @Column(name = "course_id", nullable = false, length = 30)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_num", nullable = false, length = 20)
    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    @Basic
    @Column(name = "course_name", nullable = true, length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_count", nullable = false)
    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (courseNum != null ? !courseNum.equals(that.courseNum) : that.courseNum != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseCount != null ? !courseCount.equals(that.courseCount) : that.courseCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseNum != null ? courseNum.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseCount != null ? courseCount.hashCode() : 0);
        return result;
    }
}
