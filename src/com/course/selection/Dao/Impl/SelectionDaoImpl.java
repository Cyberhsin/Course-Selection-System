package com.course.selection.Dao.Impl;

import com.course.selection.Dao.SelectionDao;
import com.course.selection.Entity.SelectionEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public void insertSelection(SelectionEntity selectionEntity){
        Session session = sessionFactory.getCurrentSession();
        session.save(selectionEntity);
    }

    @Transactional
    public List<SelectionEntity> selectSelection (String studentNum){
        String hql = "from SelectionEntity selection where selection.studentByStudentNum.studentNum = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, studentNum);
        List<SelectionEntity> selectionList = (List<SelectionEntity>)query.list();
        return selectionList;
    }

    @Transactional
    public List<SelectionEntity> listAllSelection(){
        String hql = "from SelectionEntity ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<SelectionEntity> selectionList = (List<SelectionEntity>)query.list();
        return selectionList;
    }
}
