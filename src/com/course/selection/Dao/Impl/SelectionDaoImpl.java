package com.course.selection.Dao.Impl;

import com.course.selection.Dao.SelectionDao;
import com.course.selection.Entity.CourseEntity;
import com.course.selection.Entity.SelectionEntity;
import com.course.selection.Entity.StudentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */

@Repository
public class SelectionDaoImpl implements SelectionDao{

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<SelectionEntity> selectSelectionByStudentNum (String studentNum){
        String hql = "from SelectionEntity selection where selection.studentByStudentNum.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        List<SelectionEntity> selectionList = (List<SelectionEntity>)query.list();
        return selectionList;
    }

    @Transactional
    public List<SelectionEntity> selectSelectionByCourseNum(String courseNum){
        String hql = "from SelectionEntity selection where selection.courseByCourseNum.courseNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, courseNum);
        List<SelectionEntity> selectionList = (List<SelectionEntity>)query.list();
        return selectionList;
    }

    @Transactional
    public void insertSelection(String studentNum, String courseNum){
        Session session = sessionFactory.getCurrentSession();

        String courseHql = "from CourseEntity course where course.courseNum = ?";
        Query courseQuery = sessionFactory.getCurrentSession().createQuery(courseHql);
        courseQuery.setString(0, courseNum);
        CourseEntity courseEntity = (CourseEntity) courseQuery.uniqueResult();
        Integer courseCount = courseEntity.getCourseCount();
        courseCount = courseCount + 1;
        session.update(courseCount);

        String studentHql = "from StudentEntity student where student.studentNum = ?";
        Query studentQuery = sessionFactory.getCurrentSession().createQuery(studentHql);
        studentQuery.setString(0, studentNum);
        StudentEntity studentEntity = (StudentEntity) studentQuery.uniqueResult();

        SelectionEntity selectionEntity = new SelectionEntity();
        selectionEntity.setCourseByCourseNum(courseEntity);
        selectionEntity.setStudentByStudentNum(studentEntity);
        session.save(selectionEntity);
    }

    @Transactional
    public List<HashMap<StudentEntity, Integer>> selectionCount(){
        String hql = "from StudentEntity ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();
        List<HashMap<StudentEntity, Integer>> selectionCountList = new ArrayList<HashMap<StudentEntity, Integer>>();
        for(int i = 0 ; i < studentList.size() ; i++) {
            hql = "select count(*) from SelectionEntity selection where selection.studentByStudentNum = ?";
            query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setEntity(0, studentList.get(i));
            int courseCount = ((Integer)query.uniqueResult()).intValue();
            HashMap<StudentEntity, Integer> hashMap = new HashMap<StudentEntity, Integer>();
            hashMap.put(studentList.get(i), courseCount);
            selectionCountList.add(hashMap);
        }
        return selectionCountList;
    }
}
