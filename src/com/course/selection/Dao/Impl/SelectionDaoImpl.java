package com.course.selection.Dao.Impl;

import com.course.selection.Dao.SelectionDao;
import org.springframework.stereotype.Repository;
import com.course.selection.Entity.CourseEntity;
import com.course.selection.Entity.SelectionEntity;
import com.course.selection.Entity.StudentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */

@Repository
public class SelectionDaoImpl implements SelectionDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<CourseEntity> selectSelectionByStudentNum (String studentNum){
        List<CourseEntity> studentCourseList = new ArrayList<CourseEntity>();
        String hql = "select courseNum from SelectionEntity selection where selection.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        studentCourseList = (List<CourseEntity>)query.list();
        return studentCourseList;
    }

    @Transactional
    public HashMap<StudentEntity, Long> selectionCount(){
        HashMap<StudentEntity, Long> studentSelectionCount = new HashMap<StudentEntity, Long>();
        String hql = "from StudentEntity ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<StudentEntity> studentList = (List<StudentEntity>)query.list();

        hql = "select count(*) from SelectionEntity selection where selection.studentNum.studentNum = ?";
        query = sessionFactory.getCurrentSession().createQuery(hql);

        for(int i = 0 ; i < studentList.size() ; i++) {
            query.setString(0, studentList.get(i).getStudentNum());
            long count = (Long) query.uniqueResult();
            studentSelectionCount.put(studentList.get(i),count);
        }
        return studentSelectionCount;
    }

    @Transactional
    public void insertSelection(String studentNum, String courseNum){
        Session session = sessionFactory.getCurrentSession();

        String courseHql = "from CourseEntity course where course.courseNum = ?";
        Query courseQuery = session.createQuery(courseHql);
        courseQuery.setString(0, courseNum);
        CourseEntity courseEntity = (CourseEntity) courseQuery.uniqueResult();
        int courseCount = courseEntity.getCourseCount();
        courseCount = courseCount + 1;
        courseEntity.setCourseCount(courseCount);
        session.merge(courseEntity);

        String studentHql = "from StudentEntity student where student.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(studentHql);
        query.setString(0, studentNum);
        StudentEntity studentEntity = (StudentEntity) query.uniqueResult();

        SelectionEntity selectionEntity = new SelectionEntity();
        selectionEntity.setStudentNum(studentEntity);
        selectionEntity.setCourseNum(courseEntity);
        session.save(selectionEntity);
    }
}