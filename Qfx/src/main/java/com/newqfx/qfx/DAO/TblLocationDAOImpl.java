/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblLocation;
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
@Repository("tblLocationService")
public class TblLocationDAOImpl implements TblLocationDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblLocation tblLocation) {
        sessionFacory.openSession().save(tblLocation);
    }

    @Override
    public List<TblLocation> displayTblLocation() {
    List<TblLocation> tblLocation = sessionFacory.openSession().createCriteria(TblLocation.class).list();
    return tblLocation;
    }

    @Override
    public void delete(int tblLocationId) {
        Session se =sessionFacory.openSession();
        TblLocation tblLocation = (TblLocation) se.load(TblLocation.class, tblLocationId);
        se.beginTransaction();
        se.delete(tblLocation);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblLocation edit(int tblLocationId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblLocation.class);
        cr.add(Restrictions.eq("id",tblLocationId));
        TblLocation tblLocation = (TblLocation)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblLocation;
    }

    @Override
    public TblLocation getTblLocation(int tblLocationId) {
        return sessionFacory.getCurrentSession().get(TblLocation.class, tblLocationId);
        }

    @Override
    public void updateTblLocation(TblLocation tblLocation) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblLocation.class);
        
        cr.add(Restrictions.eq("id", tblLocation.getHallId()));
        TblLocation tl = (TblLocation) cr.uniqueResult();
            tl.setHallId(tblLocation.getHallId());
            tl.setHallLocation(tblLocation.getHallLocation());
            tl.setHallName(tblLocation.getHallName());
        
        se.saveOrUpdate(tl);
        se.getTransaction().commit();
        se.close();
    }
    
}