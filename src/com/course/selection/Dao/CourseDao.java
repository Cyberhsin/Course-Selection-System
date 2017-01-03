package com.course.selection.Dao;

import com.course.selection.Entity.CourseEntity;

import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */
public interface CourseDao {
    public List<CourseEntity> listAllCourse();
    public CourseEntity selectCourse(String courseNum);
}
