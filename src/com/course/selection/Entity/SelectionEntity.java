package com.course.selection.Entity;

import com.course.selection.Entity.CourseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Created by Shinlee on 2016/12/31.
 */
@Entity
@Table(name = "selection", schema = "course_selection", catalog = "")
public class SelectionEntity {
    private String selectionId;
    private StudentEntity studentNum;
    private CourseEntity courseNum;

    @Id
    @Column(name = "selection_id", nullable = false, length = 50)
    public String getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(String selectionId) {
        this.selectionId = selectionId;
    }

    @Column(name = "course_num", nullable = false, length = 20)
    public CourseEntity getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(CourseEntity courseNum) {
        this.courseNum = courseNum;
    }

    @Column(name = "student_num", nullable = false, length = 20)
    public StudentEntity getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(StudentEntity studentNum) {
        this.studentNum = studentNum;
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
}
