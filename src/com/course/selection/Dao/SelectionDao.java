package com.course.selection.Dao;

import com.course.selection.Entity.SelectionEntity;

import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */
public interface SelectionDao {
    public void insertSelection(String studentNum, String courseNum);
    public List<SelectionEntity> selectSelectionByStudentNum (String studentNum);
}
