package com.course.selection.Service.Impl;

import com.course.selection.Dao.StudentDao;
import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void insertStudent(StudentEntity studentEntity){
        studentDao.insertStudent(studentEntity);
    }

    public void deleteStudent(String studentNum){
        studentDao.deleteStudent(studentNum);
    }

    public void updateStudent(String studentNum, StudentEntity studentEntity){
        studentDao.updateStudent(studentNum, studentEntity);
    }

    public List<StudentEntity> listAllStudent(){
        List<StudentEntity> studentList = studentDao.listAllStudent();
        return studentList;
    }

    public boolean studentLoginCheck(String studentNum, String studentPwd){
        boolean flag = studentDao.studentLoginCheck(studentNum, studentPwd);
        return  flag;
    }

    public StudentEntity selectStudentInfo (String studentNum){
        StudentEntity studentEntity = studentDao.selectStudentInfo(studentNum);
        return studentEntity;
    }

    public List<StudentEntity> selectStudentByStudentNum (String studentNum){
        List<StudentEntity> studentList = studentDao.selectStudentByStudentNum(studentNum);
        return studentList;
    }

    public List<StudentEntity> selectStudentByStudentName (String studentName){
        List<StudentEntity> studentList = studentDao.selectStudentByStudentName(studentName);
        return studentList;
    }

    public List<HashMap<String, Integer>> studentNativeCount(){
        List<HashMap<String, Integer>> studentNativeList = studentDao.studentNativeCount();
        return studentNativeList;
    }

    public List<HashMap<String, Integer>> studentHobbyCount(){
        List<HashMap<String, Integer>> studentHobbyList = studentDao.studentNativeCount();
        return studentHobbyList;
    }
}
