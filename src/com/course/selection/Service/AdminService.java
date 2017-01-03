package com.course.selection.Service;

import com.course.selection.Entity.AdminEntity;

/**
 * Created by Shinlee on 2016/12/31.
 */
public interface AdminService {
    public boolean adminLoginCheck(String adminName, String adminPwd);
    public void insertAdmin(AdminEntity adminEntity);
}
