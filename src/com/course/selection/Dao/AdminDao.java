package com.course.selection.Dao;
import com.course.selection.Entity.AdminEntity;

/**
 * Created by Shinlee on 2016/12/31.
 */
public interface AdminDao {
    public boolean adminLoginCheck(String adminName, String adminPwd);
    public void insertAdmin(AdminEntity adminEntity);
}
