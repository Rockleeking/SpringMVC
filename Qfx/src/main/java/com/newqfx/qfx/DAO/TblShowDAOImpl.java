/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblShow;
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
@Repository("tblShowService")
public class TblShowDAOImpl implements TblShowDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblShow tblShow) {
        sessionFacory.openSession().save(tblShow);
    }

    @Override
    public List<TblShow> displayTblShow() {
    List<TblShow> tblShow = sessionFacory.openSession().createCriteria(TblShow.class).list();

    return tblShow;
    }

    @Override
    public void delete(int tblShowId) {
        Session se =sessionFacory.openSession();
        TblShow tblShow = (TblShow) se.load(TblShow.class, tblShowId);
        se.beginTransaction();
        se.delete(tblShow);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblShow edit(int tblShowId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblShow.class);
        cr.add(Restrictions.eq("id",tblShowId));
        TblShow tblShow = (TblShow)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblShow;
    }

    @Override
    public TblShow getTblShow(int tblShowId) {
        return sessionFacory.getCurrentSession().get(TblShow.class, tblShowId);
        }

    @Override
    public void updateTblShow(TblShow tblShow) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblShow.class);
        
        cr.add(Restrictions.eq("id", tblShow.getShowId()));
        TblShow tsd = (TblShow) cr.uniqueResult();
        
            tsd.setMId(tblShow.getMId());
            tsd.setShowId(tblShow.getShowId());
            tsd.setShowTime(tblShow.getShowTime());
            tsd.setThId(tblShow.getThId());
            
//          l.setTblShowId(tblShow.getTblShowId());
//          l.setMenuId(tblShow.getMenuId());
//          l.setMenuItemId(tblShow.getMenuItemId());
        
        se.saveOrUpdate(tsd);
        se.getTransaction().commit();
        se.close();
    }
    
}