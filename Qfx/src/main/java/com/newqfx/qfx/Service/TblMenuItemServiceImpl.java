/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblMenuItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblMenuItemDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblMenuItemServiceImpl implements TblMenuItemService{
    @Autowired
    TblMenuItemDAO tblMenuItemDAO;

    @Override
    public TblMenuItem getTblMenuItem(int tblMenuItemId) {
        return tblMenuItemDAO.getTblMenuItem(tblMenuItemId);
    }

    @Override
    public TblMenuItem edit(int tblMenuItemId) {
        return tblMenuItemDAO.edit(tblMenuItemId);
        
    }

    @Override
    public void delete(int tblMenuItemId) {
        tblMenuItemDAO.delete(tblMenuItemId);
    }

    @Override
    public void insert(TblMenuItem tblMenuItem) {
        tblMenuItemDAO.insert(tblMenuItem);    }

    @Override
    public List<TblMenuItem> displayTblMenuItem() {
        return tblMenuItemDAO.displayTblMenuItem();    }

    @Override
    public void updateTblMenuItem(TblMenuItem tblMenuItem) {
        tblMenuItemDAO.updateTblMenuItem(tblMenuItem);    }
    
}
