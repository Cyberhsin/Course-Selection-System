package com.course.selection.Dao.Impl;

import com.course.selection.Dao.StudentDao;
import com.course.selection.Entity.StudentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */
@Repository
public class StudentDaoImpl implements StudentDao{

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void insertStudent(StudentEntity studentEntity){
        Session session = sessionFactory.getCurrentSession();
        try {
            String studertPwd = studentEntity.getStudentPwd();
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String encryptPwd = base64Encoder.encode(MD5.digest(studertPwd.getBytes("UTF-8")));
            studentEntity.setStudentPwd(encryptPwd);
        } catch (Exception e){
            System.out.println("MD5加密失败");
        }
        session.save(studentEntity);
        session.flush();
    }

    @Transactional
    public void deleteStudent(String studentNum){
        String hql = "from StudentEntity student where student.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        StudentEntity studentEntity = (StudentEntity) query.uniqueResult();
        Session session = sessionFactory.getCurrentSession();
        session.delete(studentEntity);
        session.flush();
    }

    @Transactional
    public StudentEntity selectStudentInfo (String studentNum){
        String hql = "from StudentEntity student where student.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        return (StudentEntity) query.uniqueResult();
    }

    @Transactional
    public List<StudentEntity> listAllStudent(){
        String hql = "from StudentEntity ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return  (List<StudentEntity>)query.list();
    }

    @Transactional
    public List<StudentEntity> selectStudentByStudentNum (String studentNum){
        String hql = "from StudentEntity student where student.studentNum like :studentNum";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("studentNum", "%"+studentNum+"%");
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();
        return studentList;
    }

    @Transactional
    public List<StudentEntity> selectStudentByStudentName (String studentName){
        String hql = "from StudentEntity student where student.studentName like :studentName";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("studentName", "%"+studentName+"%");
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();
        return studentList;
    }

    @Transactional
    public void updateStudent(String studentNum, StudentEntity studentEntity){
        Session session = sessionFactory.getCurrentSession();
        StudentEntity studentOriginal = this.selectStudentInfo(studentNum);
        studentEntity.setStudentId(studentOriginal.getStudentId());
        try {
            String studertPwd = studentEntity.getStudentPwd();
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String encryptPwd = base64Encoder.encode(MD5.digest(studertPwd.getBytes("UTF-8")));
            studentEntity.setStudentPwd(encryptPwd);
        } catch (Exception e){
            System.out.println("MD5加密失败");
        }
        session.merge(studentEntity);
    }

    @Transactional
    public boolean studentLoginCheck(String studentNum, String studentPwd){
        boolean flag = false;
        String hql = "from StudentEntity student where student.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        StudentEntity studentEntity = (StudentEntity) query.uniqueResult();
        if (studentEntity != null) {
            try {
                MessageDigest MD5 = MessageDigest.getInstance("MD5");
                BASE64Encoder base64Encoder = new BASE64Encoder();
                String encryptPwd = base64Encoder.encode(MD5.digest(studentPwd.getBytes("UTF-8")));
                if (encryptPwd.equals(studentEntity.getStudentPwd())) {
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("MD5加密失败");
            }
        }
        return flag;
    }

    @Transactional
    public HashMap<String, Long> studentNativeCount(){
        HashMap<String, Long> studentNativeCount = new HashMap<String, Long>();

        String hql = "select distinct studentNative from StudentEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<String> nativeList = query.list();

        hql = "select count(*) from StudentEntity student where student.studentNative = :nativeList";
        query = sessionFactory.getCurrentSession().createQuery(hql);
        for(int i = 0 ; i < nativeList.size() ; i++) {
            query.setString("nativeList", nativeList.get(i));
            long count = (Long) query.uniqueResult();
            studentNativeCount.put(nativeList.get(i), count);
        }
        return studentNativeCount;
    }

    @Transactional
    public HashMap<String, Long> studentHobbyCount(){
        HashMap<String, Long> studentHobbyCount = new HashMap<String, Long>();

        String hql = "select distinct studentHobby from StudentEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<String> hobbyList = query.list();

        hql = "select count(*) from StudentEntity student where student.studentHobby = :nativeList";
        query = sessionFactory.getCurrentSession().createQuery(hql);
        for(int i = 0 ; i < hobbyList.size() ; i++) {
            query.setString("nativeList", hobbyList.get(i));
            long count = (Long) query.uniqueResult();
            studentHobbyCount.put(hobbyList.get(i), count);
        }
        return studentHobbyCount;
    }
}