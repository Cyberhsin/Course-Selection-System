package com.course.selection.Dao.Impl;

import com.course.selection.Dao.AdminDao;
import com.course.selection.Entity.AdminEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.security.MessageDigest;

/**
 * Created by Shinlee on 2016/12/30.
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void insertAdmin(AdminEntity adminEntity){
        Session session = sessionFactory.getCurrentSession();
        try {
            String adminPwd = adminEntity.getAdminPwd();
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String encryptPwd = base64Encoder.encode(MD5.digest(adminPwd.getBytes("UTF-8")));
            adminEntity.setAdminPwd(encryptPwd);
        } catch (Exception e){
            System.out.println("MD5加密失败");
        }
        session.save(adminEntity);
    }

    @Transactional
    public boolean adminLoginCheck(String adminName, String adminPwd){
        boolean flag = false;
        String hql = "from AdminEntity admin where admin.adminName = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, adminName);
        AdminEntity adminEntity = (AdminEntity) query.uniqueResult();
        if (adminEntity != null) {
            try {
                MessageDigest MD5 = MessageDigest.getInstance("MD5");
                BASE64Encoder base64Encoder = new BASE64Encoder();
                String encryptPwd = base64Encoder.encode(MD5.digest(adminPwd.getBytes("UTF-8")));
                if (encryptPwd.equals(adminEntity.getAdminPwd())) {
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("MD5加密失败");
            }
        }
        return flag;
    }
}
