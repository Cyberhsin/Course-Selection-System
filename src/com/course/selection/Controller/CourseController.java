package com.course.selection.Controller;

import com.course.selection.Entity.AdminEntity;
import com.course.selection.Entity.CourseEntity;
import com.course.selection.Service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */
@Controller
public class CourseController {

    @Resource(name = "courseService")
    private CourseService courseService;

    @RequestMapping("/listAllCourse")
    public void addUser(AdminEntity adminEntity, HttpServletRequest request) {
        System.out.println("CourseController.tolistAllCourse()");
        List<CourseEntity> courseList = courseService.listAllCourse();
    }
}
