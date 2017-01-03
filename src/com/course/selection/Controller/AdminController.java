package com.course.selection.Controller;

import com.course.selection.Entity.AdminEntity;
import com.course.selection.Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shinlee on 2016/12/31.
 */

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminService adminService;

    @RequestMapping("/adminLoginCheck")
    public void adminLoginCheck(AdminEntity adminEntity, HttpServletRequest request) {
        System.out.println("AdminController.adminLoginCheck()");
        String adminName = adminEntity.getAdminName();
        String adminPwd = adminEntity.getAdminPwd();
        boolean flag = adminService.adminLoginCheck(adminName, adminPwd);
        System.out.println(flag);
    }

    @RequestMapping("/insertAdmin")
    public void insertAdmin(AdminEntity adminEntity, HttpServletRequest request) {
        System.out.println("AdminController.insertAdmin()");
        adminService.insertAdmin(adminEntity);
    }
}
