package com.course.selection.Service.Impl;

import com.course.selection.Dao.CourseDao;
import com.course.selection.Entity.CourseEntity;
import com.course.selection.Service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */

@Service
public class CourseServiceImpl implements CourseService{

    @Resource
    private CourseDao courseDao;

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<CourseEntity> listAllCourse(){
        List<CourseEntity> courseList = courseDao.listAllCourse();
        return courseList;
    }

    public CourseEntity selectCourse(String courseNum){
        CourseEntity courseEntity = courseDao.selectCourse(courseNum);
        return courseEntity;
    }
}
