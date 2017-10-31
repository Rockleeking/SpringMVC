/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblMenu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblMenuDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblMenuServiceImpl implements TblMenuService{
    @Autowired
    TblMenuDAO tblMenuDAO;

    @Override
    public TblMenu getTblMenu(int tblMenuId) {
        return tblMenuDAO.getTblMenu(tblMenuId);
    }

    @Override
    public TblMenu edit(int tblMenuId) {
        return tblMenuDAO.edit(tblMenuId);
        
    }

    @Override
    public void delete(int tblMenuId) {
        tblMenuDAO.delete(tblMenuId);
    }

    @Override
    public void insert(TblMenu tblMenu) {
        tblMenuDAO.insert(tblMenu);    }

    @Override
    public List<TblMenu> displayTblMenu() {
        return tblMenuDAO.displayTblMenu();    }

    @Override
    public void updateTblMenu(TblMenu tblMenu) {
        tblMenuDAO.updateTblMenu(tblMenu);    }
    
}
