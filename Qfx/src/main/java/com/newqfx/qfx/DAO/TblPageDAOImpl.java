/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblPage;
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
@Repository("tblPageService")
public class TblPageDAOImpl implements TblPageDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblPage tblPage) {
        
        
        sessionFacory.openSession().save(tblPage);
    }

    @Override
    public List<TblPage> displayTblPage() {
    List<TblPage> tblPage = sessionFacory.openSession().createCriteria(TblPage.class).list();

    return tblPage;
    }

    @Override
    public void delete(int tblPageId) {
        Session se =sessionFacory.openSession();
        TblPage tblPage = (TblPage) se.load(TblPage.class, tblPageId);
        se.beginTransaction();
        se.delete(tblPage);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblPage edit(int tblPageId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblPage.class);
        cr.add(Restrictions.eq("id",tblPageId));
        TblPage tblPage = (TblPage)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblPage;
    }

    @Override
    public TblPage getTblPage(int tblPageId) {
        return sessionFacory.getCurrentSession().get(TblPage.class, tblPageId);
        }

    @Override
    public void updateTblPage(TblPage tblPage) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblPage.class);
        
        cr.add(Restrictions.eq("id", tblPage.getPageId()));
        TblPage tp = (TblPage) cr.uniqueResult();
        
            tp.setPageId(tblPage.getPageId());
            tp.setPageName(tblPage.getPageName());
            tp.setPageContent(tblPage.getPageContent());
            tp.setPageSlug(tblPage.getPageSlug());
            
//          l.setTblPageId(tblPage.getTblPageId());
//          l.setMenuId(tblPage.getMenuId());
//          l.setMenuItemId(tblPage.getMenuItemId());
        
        se.saveOrUpdate(tp);
        se.getTransaction().commit();
        se.close();
    }
    
}