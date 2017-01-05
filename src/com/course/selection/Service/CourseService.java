package com.course.selection.Service;

import com.course.selection.Entity.CourseEntity;

import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */
public interface CourseService {
    public List<CourseEntity> listAllCourse();
    public CourseEntity selectCourse(String courseNum);
}
