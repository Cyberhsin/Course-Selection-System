package com.course.selection.Controller;

import com.course.selection.Entity.AdminEntity;
import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.AdminService;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Shinlee on 2017/1/5.
 */
@Controller
public class LoginController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @Resource(name = "adminService")
    private AdminService adminService;

    //登录验证
    @RequestMapping("/studentLoginCheck")
    public String studentLoginCheck(StudentEntity studentEntity, ModelMap modelMap){
        String studentNum = studentEntity.getStudentNum();
        String studentPwd = studentEntity.getStudentPwd();
        modelMap.addAttribute("studentNum",studentNum);
        boolean flag = studentService.studentLoginCheck(studentNum, studentPwd);
        if (flag)
            return "Student/studentIndex";
        else
            return "Student/studentLogin";
    }

    @RequestMapping("/adminLoginCheck")
    public String adminLoginCheck(AdminEntity adminEntity) {
        String adminName = adminEntity.getAdminName();
        String adminPwd = adminEntity.getAdminPwd();
        boolean flag = adminService.adminLoginCheck(adminName, adminPwd);
        if (flag)
            return "Admin/adminIndex";
        else
            return "Admin/adminLogin";
    }
}
