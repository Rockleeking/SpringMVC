/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblTheatre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblTheatreDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblTheatreServiceImpl implements TblTheatreService{
    @Autowired
    TblTheatreDAO tblTheatreDAO;

    @Override
    public TblTheatre getTblTheatre(int tblTheatreId) {
        return tblTheatreDAO.getTblTheatre(tblTheatreId);
    }

    @Override
    public TblTheatre edit(int tblTheatreId) {
        return tblTheatreDAO.edit(tblTheatreId);
        
    }

    @Override
    public void delete(int tblTheatreId) {
        tblTheatreDAO.delete(tblTheatreId);
    }

    @Override
    public void insert(TblTheatre tblTheatre) {
        tblTheatreDAO.insert(tblTheatre);    }

    @Override
    public List<TblTheatre> displayTblTheatre() {
        return tblTheatreDAO.displayTblTheatre();    }

    @Override
    public void updateTblTheatre(TblTheatre tblTheatre) {
        tblTheatreDAO.updateTblTheatre(tblTheatre);    }
    
}
