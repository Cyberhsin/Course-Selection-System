package com.course.selection.Controller;

import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.SelectionService;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/5.
 */
@Controller
public class AdminController {
    @Resource
    private StudentService studentService;

    @Resource
    private SelectionService selectionService;


    //遍历所有学生
    @RequestMapping("/listAllStudent")
    public String listAllStudent(ModelMap modelMap) {
        List<StudentEntity> studentList = studentService.listAllStudent();
        modelMap.addAttribute("studentList", studentList);
        return "Admin/studentList";
    }

    //根据学号模糊查询学生
    @RequestMapping("/selectStudentByStudentNum")
    public String selectStudentByStudentNum(String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("studentList", studentService.selectStudentByStudentNum(studentNum));
        return "Admin/studentList";
    }

    //根据姓名模糊查询学生
    @RequestMapping("/selectStudentByStudentName")
    public String selectStudentByStudentName(String studentName, ModelMap modelMap) {
        modelMap.addAttribute("studentList", studentService.selectStudentByStudentName(studentName));
        return "Admin/studentList";
    }

    //添加学生
    @RequestMapping("/insertStudent")
    public String insertStudent(StudentEntity studentEntity) {
        studentService.insertStudent(studentEntity);
        return "redirect:/listAllStudent";
    }

    //删除学生
    @RequestMapping(value = "/deleteStudent/{studentNum}")
    public String deleteStudent(@PathVariable String studentNum) {
        studentService.deleteStudent(studentNum);
        return "redirect:/listAllStudent";
    }

    //查看学生信息
    @RequestMapping(value = "/toUpdateStudent/{studentNum}")
    public String selectStudent(@PathVariable String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("student", studentService.selectStudentInfo(studentNum));
        return "Admin/studentEdit";
    }

    //修改学生信息
    @RequestMapping(value = "/updateStudent/{studentNum}")
    public String updateStudent(@PathVariable String studentNum, StudentEntity studentEntity) {
        studentService.updateStudent(studentNum, studentEntity);
        return "redirect:/listAllStudent";
    }

    //查看学生选课信息
    @RequestMapping("/studentSelection/{studentNum}")
    public String selectionList(@PathVariable String studentNum, ModelMap modelMap) {
        modelMap.addAttribute("studentCourseList", selectionService.selectSelectionByStudentNum(studentNum));
        return "/Admin/studentSelection";
    }
}