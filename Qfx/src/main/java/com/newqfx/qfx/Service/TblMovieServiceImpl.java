/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblMovie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblMovieDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblMovieServiceImpl implements TblMovieService{
    @Autowired
    TblMovieDAO tblMovieDAO;

    @Override
    public TblMovie getTblMovie(int tblMovieId) {
        return tblMovieDAO.getTblMovie(tblMovieId);
    }

    @Override
    public TblMovie edit(int tblMovieId) {
        return tblMovieDAO.edit(tblMovieId);
        
    }

    @Override
    public void delete(int tblMovieId) {
        tblMovieDAO.delete(tblMovieId);
    }

    @Override
    public void insert(TblMovie tblMovie) {
        tblMovieDAO.insert(tblMovie);    }

    @Override
    public List<TblMovie> displayTblMovie() {
        return tblMovieDAO.displayTblMovie();    }

    @Override
    public void updateTblMovie(TblMovie tblMovie) {
        tblMovieDAO.updateTblMovie(tblMovie);    }
    
}
