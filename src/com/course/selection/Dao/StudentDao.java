package com.course.selection.Dao;

import com.course.selection.Entity.StudentEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */
public interface StudentDao {
    public void insertStudent(StudentEntity studentEntity);
    public void deleteStudent(String studentNum);
    public void updateStudent(String studentNum, StudentEntity studentEntity);
    public List<StudentEntity> listAllStudent();
    public boolean studentLoginCheck(String studentNum, String studentPwd);
    public StudentEntity selectStudentInfo (String studentNum);
    public List<StudentEntity> selectStudentByStudentNum (String studentNum);
    public List<StudentEntity> selectStudentByStudentName (String studentName);
    public HashMap<String, Long> studentNativeCount();
    public HashMap<String, Long>  studentHobbyCount();
}
