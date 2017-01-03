package com.course.selection.Dao;

import com.course.selection.Entity.SelectionEntity;

import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */
public interface SelectionDao {
    public void insertSelection(SelectionEntity selectionEntity);
    public List<SelectionEntity> selectSelection (String studentNum);
    public List<SelectionEntity> listAllSelection();
}
