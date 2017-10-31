/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblAdmin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblAdminDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblAdminServiceImpl implements TblAdminService{
    @Autowired
    TblAdminDAO tblAdminDAO;

    @Override
    public TblAdmin getTblAdmin(int tblAdminId) {
        return tblAdminDAO.getTblAdmin(tblAdminId);
    }

    @Override
    public TblAdmin edit(int tblAdminId) {
        return tblAdminDAO.edit(tblAdminId);
        
    }

    @Override
    public void delete(int tblAdminId) {
        tblAdminDAO.delete(tblAdminId);
    }

    @Override
    public void insert(TblAdmin tblAdmin) {
        tblAdminDAO.insert(tblAdmin);    }

    @Override
    public List<TblAdmin> displayTblAdmin() {
        return tblAdminDAO.displayTblAdmin();    }

    @Override
    public void updateTblAdmin(TblAdmin tblAdmin) {
        tblAdminDAO.updateTblAdmin(tblAdmin);    }
    
}
