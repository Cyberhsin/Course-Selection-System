package com.course.selection.Service.Impl;

import com.course.selection.Dao.SelectionDao;
import com.course.selection.Entity.SelectionEntity;
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
public class SelectionServiceImpl implements SelectionService{

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

    public List<SelectionEntity> selectSelectionByStudentNum (String studentNum) {
        List<SelectionEntity> selectionList = selectionDao.selectSelectionByStudentNum(studentNum);
        return selectionList;
    }

    public List<SelectionEntity> selectSelectionByCourseNum(String courseNum){
        List<SelectionEntity> selectionList = selectionDao.selectSelectionByStudentNum(courseNum);
        return selectionList;
    }

    public List<HashMap<StudentEntity, Integer>> selectionCount(){
        List<HashMap<StudentEntity, Integer>> selectionCountList = selectionDao.selectionCount();
        return selectionCountList;
    }
}
