package com.course.selection.Controller;

import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shinlee on 2016/12/31.
 */

@Controller
@RequestMapping("/Student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("listAllStudent")
    public String listAllStudent(HttpServletRequest request) {
        request.setAttribute("studentList", studentService.listAllStudent());
        return "/listAll.jsp";
    }

    @RequestMapping(value = "/selectStudent/{studentNum}")
    public String selectStudent(@PathVariable String studentNum, HttpServletRequest request) {
        request.setAttribute("student", studentService.selectStudent(studentNum));
        return "/editStudent";
    }

    @RequestMapping("/toInsertStudent")
    public String toInsertStudent() {
        System.out.println("StudentController.toInsertStudent()");
        return "/insertStudent";
    }

    @RequestMapping("/insertStudent")
    public String insertStudent(StudentEntity studentEntity, HttpServletRequest request) {
        studentService.insertStudent(studentEntity);
        return "redirect:/student/listAllStudent";
    }

    @RequestMapping(value = "/deleteStudent/{studentNum}")
    public String delUser(@PathVariable String studentNum, HttpServletResponse response) {
        studentService.deleteStudent(studentNum);
        return "redirect:/student/listAllStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateUser(String studentNum, StudentEntity studentEntity, HttpServletRequest request) {
        studentService.updateStudent(studentNum, studentEntity);
        return "redirect:/student/selectStudent/{studentNum}";
    }

    @RequestMapping("/studentLoginCheck")
    public void studentLoginCheck(StudentEntity studentEntity, HttpServletRequest request){
        System.out.println("StudentController.studentLoginCheck()");
        String studentNum = studentEntity.getStudentNum();
        String studentPwd = studentEntity.getStudentPwd();
        boolean flag = studentService.studentLoginCheck(studentNum, studentPwd);
        System.out.println(flag);
    }
}
