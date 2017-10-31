/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblTheatre;
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
@Repository("tblTheatreService")
public class TblTheatreDAOImpl implements TblTheatreDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblTheatre tblTheatre) {
        sessionFacory.openSession().save(tblTheatre);
    }

    @Override
    public List<TblTheatre> displayTblTheatre() {
    List<TblTheatre> tblTheatre = sessionFacory.openSession().createCriteria(TblTheatre.class).list();

    return tblTheatre;
    }

    @Override
    public void delete(int tblTheatreId) {
        Session se =sessionFacory.openSession();
        TblTheatre tblTheatre = (TblTheatre) se.load(TblTheatre.class, tblTheatreId);
        se.beginTransaction();
        se.delete(tblTheatre);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblTheatre edit(int tblTheatreId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblTheatre.class);
        cr.add(Restrictions.eq("id",tblTheatreId));
        TblTheatre tblTheatre = (TblTheatre)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblTheatre;
    }

    @Override
    public TblTheatre getTblTheatre(int tblTheatreId) {
        return sessionFacory.getCurrentSession().get(TblTheatre.class, tblTheatreId);
        }

    @Override
    public void updateTblTheatre(TblTheatre tblTheatre) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblTheatre.class);
        
        cr.add(Restrictions.eq("id", tblTheatre.getThId()));
        TblTheatre tt = (TblTheatre) cr.uniqueResult();
        
          tt.setHallId(tblTheatre.getHallId());
          tt.setThId(tblTheatre.getThId());
          tt.setThName(tblTheatre.getThName());
          
        
        se.saveOrUpdate(tt);
        se.getTransaction().commit();
        se.close();
    }
    
}