package com.course.selection.Controller;

import com.course.selection.Service.CourseService;
import com.course.selection.Service.SelectionService;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Shinlee on 2017/1/1.
 */

@Controller
@RequestMapping("/Selection")
public class SelectionController {

    private StudentService studentService;
    private CourseService courseService;

    @Resource(name = "selectionService")
    private SelectionService selectionService;
}
