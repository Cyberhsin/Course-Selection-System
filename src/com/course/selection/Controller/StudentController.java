package com.course.selection.Controller;

import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.CourseService;
import com.course.selection.Service.SelectionService;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Shinlee on 2016/12/31.
 */

@Controller
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @Resource(name = "courseService")
    private CourseService courseService;

    @Resource(name = "selectionService")
    private SelectionService selectionService;

    //查看所有课程
    @RequestMapping("/listAllCourse/{studentNum}")
    public String addUser(@PathVariable String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("courseList", courseService.listAllCourse());
        modelMap.addAttribute("studentNum", studentNum);
        return "Student/courseList";
    }

    //查看学生信息
    @RequestMapping(value = "/selectStudentInfo/{studentNum}")
    public String selectStudent(@PathVariable String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("student", studentService.selectStudentInfo(studentNum));
        return "Student/studentInfo";
    }

    //修改学生信息
    @RequestMapping(value = "/toUpdateStudentInfo/{studentNum}")
    public String selectStudentInfo(@PathVariable String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("student", studentService.selectStudentInfo(studentNum));
        return "Student/studentInfoEdit";
    }

    @RequestMapping("/updateStudentInfo/{studentNum}")
    public String updateStudentInfo(@PathVariable String studentNum, StudentEntity studentEntity) {
        studentService.updateStudent(studentNum, studentEntity);
        return "redirect:/selectStudentInfo/{studentNum}";
    }

    //选课操作
    @RequestMapping("/insertSelection/{studentNum}")
    public String insertSelection(@PathVariable String studentNum, @RequestParam(value = "courseNum") String courseNumStr) {
        String courseNum[] = courseNumStr.split(",");
        for(int i = 0 ; i < courseNum.length ; i++){
            selectionService.insertSelection(studentNum, courseNum[i]);
        }
        return "redirect:/listSelection/{studentNum}";
    }

    //查看已选课程
    @RequestMapping("/listSelection/{studentNum}")
    public String selectionList(@PathVariable String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("selectionList", selectionService.selectSelectionByStudentNum(studentNum));
        modelMap.addAttribute("studentNum", studentNum);
        return "/Student/selectionList";
    }
}