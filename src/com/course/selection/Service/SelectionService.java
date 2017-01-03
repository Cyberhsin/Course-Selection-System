package com.course.selection.Service;

import com.course.selection.Entity.SelectionEntity;
import com.course.selection.Entity.StudentEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */
public interface SelectionService {
    public void insertSelection(String studentNum, String courseNum);
    public List<SelectionEntity> selectSelectionByStudentNum (String studentNum);
    public List<SelectionEntity> selectSelectionByCourseNum(String courseNum);
    public List<HashMap<StudentEntity, Integer>> selectionCount();
}
