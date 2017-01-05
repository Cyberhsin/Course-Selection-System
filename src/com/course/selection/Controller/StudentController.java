package com.course.selection.Controller;

import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;
    //遍历所有学生
    @RequestMapping("/listAllStudent")
    public String listAllStudent(ModelMap modelMap) {
        List<StudentEntity> studentList = studentService.listAllStudent();
        modelMap.addAttribute("studentList", studentList);
        System.out.println("lllllllll");
        return "/studentList";
    }
    //根据学号模糊查询学生
    @RequestMapping("/selectStudentByStudentNum/{studentNum}")
    public String selectStudentByStudentNum(@PathVariable String studentNum, HttpServletRequest request) {
        request.setAttribute("studentList", studentService.selectStudentByStudentNum(studentNum));
        return "/listAll";
    }
    //根据姓名模糊查询学生
    @RequestMapping("/selectStudentByStudentName/{studentName}")
    public String selectStudentByStudentName(@PathVariable String studentName, HttpServletRequest request) {
        request.setAttribute("studentList", studentService.selectStudentByStudentName(studentName));
        return "/listAll";
    }
    //显示学生信息
    @RequestMapping(value = "/selectStudentInfo/{studentNum}")
    public String selectStudent(@PathVariable String studentNum, HttpServletRequest request) {
        request.setAttribute("student", studentService.selectStudentInfo(studentNum));
        return "/editStudent";
    }
    //添加学生前置
    @RequestMapping("/toInsertStudent")
    public String toInsertStudent() {
        System.out.println("StudentController.toInsertStudent()");
        return "/insertStudent";
    }
    //添加学生
    @RequestMapping("/insertStudent")
    public String insertStudent(StudentEntity studentEntity, HttpServletRequest request) {
        studentService.insertStudent(studentEntity);
        return "redirect:/student/listAllStudent";
    }
    //删除学生
    @RequestMapping(value = "/deleteStudent/{studentNum}")
    public String delUser(@PathVariable String studentNum, HttpServletResponse response) {
        studentService.deleteStudent(studentNum);
        return "redirect:/student/listAllStudent";
    }
    //修改学生信息
    @RequestMapping("/updateStudent")
    public String updateUser(String studentNum, StudentEntity studentEntity, HttpServletRequest request) {
        studentService.updateStudent(studentNum, studentEntity);
        return "redirect:/student/selectStudent/{studentNum}";
    }
    //登录验证
    @RequestMapping("/studentLoginCheck")
    public String studentLoginCheck(StudentEntity studentEntity, HttpServletRequest request){
        System.out.println("StudentController.studentLoginCheck()");
        String studentNum = studentEntity.getStudentNum();
        String studentPwd = studentEntity.getStudentPwd();
        boolean flag = studentService.studentLoginCheck(studentNum, studentPwd);
        if (flag)
            return "redirect:index";
        else
            return "redirect:login";
    }
    //学生籍贯统计
    @RequestMapping("/studentNativeCount")
    public String updateUser(HttpServletRequest request) {
        List<HashMap<String, Integer>> studentNativeList = studentService.studentNativeCount();
        request.setAttribute("student", studentNativeList);
        return "redirect:/student/studentNativeCount";
    }
    //学生爱好统计
    @RequestMapping("/studentHobbyCount")
    public String studentLoginCheck(HttpServletRequest request){
        List<HashMap<String, Integer>> studentHobbyList = studentService.studentHobbyCount();
        request.setAttribute("student", studentHobbyList);
        return "redirect:/student/studentHobbyCount";
    }
}
