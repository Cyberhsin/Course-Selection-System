package com.course.selection.Service.Impl;

import com.course.selection.Dao.AdminDao;
import com.course.selection.Entity.AdminEntity;
import com.course.selection.Service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Shinlee on 2016/12/31.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public boolean adminLoginCheck(String adminName, String adminPwd) {
        boolean flag = adminDao.adminLoginCheck(adminName, adminPwd);
        return flag;
    }

    public void insertAdmin(AdminEntity adminEntity){
        adminDao.insertAdmin(adminEntity);
    }
}
