package com.course.selection.Entity;

import javax.persistence.*;

/**
 * Created by Shinlee on 2016/12/31.
 */
@Entity
@Table(name = "student", schema = "course_selection", catalog = "")
public class StudentEntity {
    private String studentId;
    private String studentNum;
    private String studentName;
    private String studentIdnums;
    private String studentClass;
    private String studentSex;
    private String studentPwd;
    private String studentAddress;
    private String studentNative;
    private String studentTel;
    private String studentHobby;

    @Id
    @Column(name = "student_id", nullable = false, length = 30)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_num", nullable = false, length = 20)
    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Basic
    @Column(name = "student_name", nullable = false, length = 20)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_idnums", nullable = false, length = 20)
    public String getStudentIdnums() {
        return studentIdnums;
    }

    public void setStudentIdnums(String studentIdnums) {
        this.studentIdnums = studentIdnums;
    }

    @Basic
    @Column(name = "student_class", nullable = false, length = 20)
    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Basic
    @Column(name = "student_sex", nullable = false, length = 20)
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    @Basic
    @Column(name = "student_pwd", nullable = false, length = 20)
    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    @Basic
    @Column(name = "student_address", nullable = true, length = 20)
    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Basic
    @Column(name = "student_native", nullable = true, length = 20)
    public String getStudentNative() {
        return studentNative;
    }

    public void setStudentNative(String studentNative) {
        this.studentNative = studentNative;
    }

    @Basic
    @Column(name = "student_tel", nullable = true, length = 20)
    public String getStudentTel() {
        return studentTel;
    }

    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel;
    }

    @Basic
    @Column(name = "student_hobby", nullable = true, length = 20)
    public String getStudentHobby() {
        return studentHobby;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (studentNum != null ? !studentNum.equals(that.studentNum) : that.studentNum != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (studentIdnums != null ? !studentIdnums.equals(that.studentIdnums) : that.studentIdnums != null)
            return false;
        if (studentClass != null ? !studentClass.equals(that.studentClass) : that.studentClass != null) return false;
        if (studentSex != null ? !studentSex.equals(that.studentSex) : that.studentSex != null) return false;
        if (studentPwd != null ? !studentPwd.equals(that.studentPwd) : that.studentPwd != null) return false;
        if (studentAddress != null ? !studentAddress.equals(that.studentAddress) : that.studentAddress != null)
            return false;
        if (studentNative != null ? !studentNative.equals(that.studentNative) : that.studentNative != null)
            return false;
        if (studentTel != null ? !studentTel.equals(that.studentTel) : that.studentTel != null) return false;
        if (studentHobby != null ? !studentHobby.equals(that.studentHobby) : that.studentHobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (studentNum != null ? studentNum.hashCode() : 0);
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentIdnums != null ? studentIdnums.hashCode() : 0);
        result = 31 * result + (studentClass != null ? studentClass.hashCode() : 0);
        result = 31 * result + (studentSex != null ? studentSex.hashCode() : 0);
        result = 31 * result + (studentPwd != null ? studentPwd.hashCode() : 0);
        result = 31 * result + (studentAddress != null ? studentAddress.hashCode() : 0);
        result = 31 * result + (studentNative != null ? studentNative.hashCode() : 0);
        result = 31 * result + (studentTel != null ? studentTel.hashCode() : 0);
        result = 31 * result + (studentHobby != null ? studentHobby.hashCode() : 0);
        return result;
    }
}
