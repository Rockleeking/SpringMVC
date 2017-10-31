/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblPageDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblPageServiceImpl implements TblPageService{
    @Autowired
    TblPageDAO tblPageDAO;

    @Override
    public TblPage getTblPage(int tblPageId) {
        return tblPageDAO.getTblPage(tblPageId);
    }

    @Override
    public TblPage edit(int tblPageId) {
        return tblPageDAO.edit(tblPageId);
        
    }

    @Override
    public void delete(int tblPageId) {
        tblPageDAO.delete(tblPageId);
    }

    @Override
    public void insert(TblPage tblPage) {
        tblPageDAO.insert(tblPage);    }

    @Override
    public List<TblPage> displayTblPage() {
        return tblPageDAO.displayTblPage();    }

    @Override
    public void updateTblPage(TblPage tblPage) {
        tblPageDAO.updateTblPage(tblPage);    }
    
}
