package com.course.selection.Service.Impl;

import com.course.selection.Dao.SelectionDao;
import com.course.selection.Entity.SelectionEntity;
import com.course.selection.Service.SelectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shinlee on 2017/1/1.
 */

@Service
public class SelectionServiceImpl implements SelectionService{

    @Resource
    private SelectionDao selectionDao;

    public SelectionDao getSelectionDao() {
        return selectionDao;
    }

    public void setSelectionDao(SelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    public void insertSelection(SelectionEntity selectionEntity){
        selectionDao.insertSelection(selectionEntity);
    }

    public List<SelectionEntity> selectSelection (String studentNum){
        List<SelectionEntity> selectionList = selectionDao.selectSelection(studentNum);
        return selectionList;
    }

    public List<SelectionEntity> listAllStudent(){
        List<SelectionEntity> selectionList = selectionDao.listAllSelection();
        return selectionList;
    }
}
