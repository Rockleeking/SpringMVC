/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;


import com.newqfx.qfx.Entity.TblShow;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblShowDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblShowServiceImpl implements TblShowService{
    @Autowired
    TblShowDAO tblShowDAO;

    @Override
    public TblShow getTblShow(int tblShowId) {
        return tblShowDAO.getTblShow(tblShowId);
    }

    @Override
    public TblShow edit(int tblShowId) {
        return tblShowDAO.edit(tblShowId);
        
    }

    @Override
    public void delete(int tblShowId) {
        tblShowDAO.delete(tblShowId);
    }

    @Override
    public void insert(TblShow tblShow) {
        tblShowDAO.insert(tblShow);    }

    @Override
    public List<TblShow> displayTblShow() {
        return tblShowDAO.displayTblShow();    }

    @Override
    public void updateTblShow(TblShow tblShow) {
        tblShowDAO.updateTblShow(tblShow);    }
    
}
