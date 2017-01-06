package com.course.selection.Service.Impl;

import com.course.selection.Dao.SelectionDao;
import com.course.selection.Entity.CourseEntity;
import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.SelectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */

@Service
public class SelectionServiceImpl implements SelectionService {

    @Resource
    private SelectionDao selectionDao;

    public SelectionDao getSelectionDao() {
        return selectionDao;
    }

    public void setSelectionDao(SelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    public void insertSelection(String studentNum, String courseNum) {
        selectionDao.insertSelection(studentNum, courseNum);
    }

    public List<CourseEntity> selectSelectionByStudentNum (String studentNum) {
        List<CourseEntity> studentCourseList = selectionDao.selectSelectionByStudentNum(studentNum);
        return studentCourseList;
    }

    public HashMap<StudentEntity, Long> selectionCount(){
        HashMap<StudentEntity, Long> selectionCountList = selectionDao.selectionCount();
        return selectionCountList;
    }
}