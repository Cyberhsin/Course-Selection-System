package com.course.selection.Dao.Impl;

import com.course.selection.Dao.CourseDao;
import com.course.selection.Entity.CourseEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shinlee on 2016/12/31.
 */
@Repository
public class CourseDaoImpl implements CourseDao{

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<CourseEntity> listAllCourse(){
        String hql = "from CourseEntity ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<CourseEntity> courseList = (List<CourseEntity>)query.list();
        return courseList;
    }

    @Transactional
    public CourseEntity selectCourse(String courseNum){
        String hql = "from CourseEntity course where course.courseNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, courseNum);
        return (CourseEntity) query.uniqueResult();
    }
}