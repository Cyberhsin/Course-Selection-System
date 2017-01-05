package com.course.selection.Entity;

import javax.persistence.*;

/**
 * Created by Shinlee on 2016/12/31.
 */
@Entity
@Table(name = "selection", schema = "course_selection", catalog = "")
public class SelectionEntity {
    private String selectionId;
    private StudentEntity studentByStudentNum;
    private CourseEntity courseByCourseNum;

    @Id
    @Column(name = "selection_id", nullable = false, length = 30)
    public String getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(String selectionId) {
        this.selectionId = selectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectionEntity that = (SelectionEntity) o;

        if (selectionId != null ? !selectionId.equals(that.selectionId) : that.selectionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = selectionId != null ? selectionId.hashCode() : 0;
        return result;
    }

    public StudentEntity getStudentByStudentNum() {
        return studentByStudentNum;
    }

    public void setStudentByStudentNum(StudentEntity studentByStudentNum) {
        this.studentByStudentNum = studentByStudentNum;
    }

    public CourseEntity getCourseByCourseNum() {
        return courseByCourseNum;
    }

    public void setCourseByCourseNum(CourseEntity courseByCourseNum) {
        this.courseByCourseNum = courseByCourseNum;
    }
}
