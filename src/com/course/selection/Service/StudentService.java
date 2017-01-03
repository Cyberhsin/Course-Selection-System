package com.course.selection.Service;

import com.course.selection.Entity.StudentEntity;

import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */
public interface StudentService {
    public void insertStudent(StudentEntity studentEntity);
    public void deleteStudent(String studentNum);
    public StudentEntity selectStudent (String studentNum);
    public void updateStudent(String studentNum, StudentEntity studentEntity);
    public List<StudentEntity> listAllStudent();
    public boolean studentLoginCheck(String studentNum, String studentPwd);
}
