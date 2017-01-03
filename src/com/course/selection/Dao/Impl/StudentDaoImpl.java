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
import java.util.ArrayList;
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
            String adminPwd = studentEntity.getStudentPwd();
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String encryptPwd = base64Encoder.encode(MD5.digest(adminPwd.getBytes("UTF-8")));
            studentEntity.setStudentPwd(encryptPwd);
        } catch (Exception e){
            System.out.println("MD5加密失败");
        }
        session.save(studentEntity);
    }

    @Transactional
    public void deleteStudent(String studentNum){
        String hql = "delete StudentEntity student where student.studentName = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        query.executeUpdate();
    }

    @Transactional
    public StudentEntity selectStudentInfo (String studentNum){
        String hql = "from StudentEntity student where student.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        return (StudentEntity) query.uniqueResult();
    }

    @Transactional
    public List<StudentEntity> selectStudentByStudentNum (String studentNum){
        String hql = "from StudentEntity student where student.studentNum like :studentNum";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("studentNum", studentNum);
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();
        return studentList;
    }

    @Transactional
    public List<StudentEntity> selectStudentByStudentName (String studentName){
        String hql = "from StudentEntity student where student.studentName like :studentName";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("studentName", studentName);
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();
        return studentList;
    }

    @Transactional
    public void updateStudent(String studentNum, StudentEntity studentEntity){
        this.deleteStudent(studentNum);
        this.insertStudent(studentEntity);
    }

    @Transactional
    public List<StudentEntity> listAllStudent(){
        String hql = "from StudentEntity ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();
        return studentList;
    }

    @Transactional
    public boolean studentLoginCheck(String studentNum, String studentPwd){
        String hql = "from StudentEntity student where student.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        StudentEntity studentEntity = (StudentEntity)query.uniqueResult();
        if (studentEntity != null)
        {
            if (studentEntity.getStudentPwd().equals(studentPwd))
            {
                return true;
            }
            else
                return false;
        }
        else
        {
            return false;
        }
    }

    @Transactional
    public List<HashMap<String, Integer>> studentNativeCount(){
        String hql = "select distinct studentNative from StudentEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<String> nativeList = query.list();
        List<HashMap<String, Integer>> studentNativeList = new ArrayList<HashMap<String, Integer>>();
        for(int i = 0 ; i < nativeList.size() ; i++) {
            hql = "select count(*) from StudentEntity student where student.studentNative = ?";
            query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setString(0, nativeList.get(i));
            int nativeCount = ((Integer)query.uniqueResult()).intValue();
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            hashMap.put(nativeList.get(i), nativeCount);
            studentNativeList.add(hashMap);
        }
        return studentNativeList;
    }

    @Transactional
    public List<HashMap<String, Integer>> studentHobbyCount(){
        String hql = "select distinct studentHobby from StudentEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<String> hobbyList = query.list();
        List<HashMap<String, Integer>> studentHobbyList = new ArrayList<HashMap<String, Integer>>();
        for(int i = 0 ; i < hobbyList.size() ; i++) {
            hql = "select count(*) from StudentEntity student where student.studentHobby = ?";
            query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setString(0, hobbyList.get(i));
            int nativeCount = ((Integer)query.uniqueResult()).intValue();
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            hashMap.put(hobbyList.get(i), nativeCount);
            studentHobbyList.add(hashMap);
        }
        return studentHobbyList;
    }
}