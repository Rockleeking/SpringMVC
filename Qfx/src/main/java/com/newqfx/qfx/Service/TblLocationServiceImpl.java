/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblLocation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblLocationDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblLocationServiceImpl implements TblLocationService{
    @Autowired
    TblLocationDAO tblLocationDAO;

    @Override
    public TblLocation getTblLocation(int tblLocationId) {
        return tblLocationDAO.getTblLocation(tblLocationId);
    }

    @Override
    public TblLocation edit(int tblLocationId) {
        return tblLocationDAO.edit(tblLocationId);
        
    }

    @Override
    public void delete(int tblLocationId) {
        tblLocationDAO.delete(tblLocationId);
    }

    @Override
    public void insert(TblLocation tblLocation) {
        tblLocationDAO.insert(tblLocation);    }

    @Override
    public List<TblLocation> displayTblLocation() {
        return tblLocationDAO.displayTblLocation();    }

    @Override
    public void updateTblLocation(TblLocation tblLocation) {
        tblLocationDAO.updateTblLocation(tblLocation);    }
    
}
