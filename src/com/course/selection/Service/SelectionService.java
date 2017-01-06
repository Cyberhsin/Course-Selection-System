package com.course.selection.Service;

import com.course.selection.Entity.CourseEntity;
import com.course.selection.Entity.StudentEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */
public interface SelectionService {
    public void insertSelection(String studentNum, String courseNum);
    public List<CourseEntity> selectSelectionByStudentNum (String studentNum);
    public HashMap<StudentEntity, Long> selectionCount();
}
