package com.course.selection.Controller;

import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.CourseService;
import com.course.selection.Service.SelectionService;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/insertSelection/{studentNum}")
    public void insertSelection(@PathVariable String studentNum , @PathVariable String couresNum, HttpServletRequest request) {
        selectionService.insertSelection(studentNum, couresNum);
    }
    //选课统计
    @RequestMapping("/selectionCount")
    public void selectionCount(HttpServletRequest request) {
        List<HashMap<StudentEntity, Integer>> selectionCountList = selectionService.selectionCount();
        request.setAttribute("selectionCountList", selectionCountList);
    }
}
