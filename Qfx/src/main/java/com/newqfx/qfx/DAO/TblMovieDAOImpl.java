/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblMovie;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */
@Repository("tblMovieService")
public class TblMovieDAOImpl implements TblMovieDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblMovie tblMovie) {
        sessionFacory.openSession().save(tblMovie);
    }

    @Override
    public List<TblMovie> displayTblMovie() {
    List<TblMovie> tblMovie = sessionFacory.openSession().createCriteria(TblMovie.class).list();

    return tblMovie;
    }

    @Override
    public void delete(int tblMovieId) {
        Session se =sessionFacory.openSession();
        TblMovie tblMovie = (TblMovie) se.load(TblMovie.class, tblMovieId);
        se.beginTransaction();
        se.delete(tblMovie);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblMovie edit(int tblMovieId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblMovie.class);
        cr.add(Restrictions.eq("id",tblMovieId));
        TblMovie tblMovie = (TblMovie)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblMovie;
    }

    @Override
    public TblMovie getTblMovie(int tblMovieId) {
        return sessionFacory.getCurrentSession().get(TblMovie.class, tblMovieId);
        }

    @Override
    public void updateTblMovie(TblMovie tblMovie) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblMovie.class);
        
        cr.add(Restrictions.eq("id", tblMovie.getMId()));
        TblMovie tmd = (TblMovie) cr.uniqueResult();
            
            tmd.setMCast(tblMovie.getMCast());
            tmd.setMDesc(tblMovie.getMDesc());
            tmd.setMDirector(tblMovie.getMDirector());
            tmd.setMGenre(tblMovie.getMGenre());
            tmd.setMId(tblMovie.getMId());
            tmd.setMName(tblMovie.getMName());
            tmd.setMPhotoUrl(tblMovie.getMPhotoUrl());
            tmd.setMReleaseDate(tblMovie.getMReleaseDate());
            tmd.setMTime(tblMovie.getMTime());
            tmd.setMTrailerUrl(tblMovie.getMTrailerUrl());
//          l.setTblMovieId(tblMovie.getTblMovieId());
//          l.setMenuId(tblMovie.getMenuId());
//          l.setMenuItemId(tblMovie.getMenuItemId());
        
        se.saveOrUpdate(tmd);
        se.getTransaction().commit();
        se.close();
    }
    
}