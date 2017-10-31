/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblMenuItem;
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
@Repository("tblMenuItemService")
public class TblMenuItemDAOImpl implements TblMenuItemDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblMenuItem tblMenuItem) {
        sessionFacory.openSession().save(tblMenuItem);
    }

    @Override
    public List<TblMenuItem> displayTblMenuItem() {
    List<TblMenuItem> tblMenuItem = sessionFacory.openSession().createCriteria(TblMenuItem.class).list();

    return tblMenuItem;
    }

    @Override
    public void delete(int tblMenuItemId) {
        Session se =sessionFacory.openSession();
        TblMenuItem tblMenuItem = (TblMenuItem) se.load(TblMenuItem.class, tblMenuItemId);
        se.beginTransaction();
        se.delete(tblMenuItem);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblMenuItem edit(int tblMenuItemId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblMenuItem.class);
        cr.add(Restrictions.eq("id",tblMenuItemId));
        TblMenuItem tblMenuItem = (TblMenuItem)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblMenuItem;
    }

    @Override
    public TblMenuItem getTblMenuItem(int tblMenuItemId) {
        return sessionFacory.getCurrentSession().get(TblMenuItem.class, tblMenuItemId);
        }

    @Override
    public void updateTblMenuItem(TblMenuItem tblMenuItem) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblMenuItem.class);
        
        cr.add(Restrictions.eq("id", tblMenuItem.getMenuItemId()));
        TblMenuItem tmi = (TblMenuItem) cr.uniqueResult();
            tmi.setMenuItemId(tblMenuItem.getMenuItemId());
            tmi.setMenuItemName(tblMenuItem.getMenuItemName());
            tmi.setPageId(tblMenuItem.getPageId());
        
        
//          l.setTblMenuItemId(tblMenuItem.getTblMenuItemId());
//          l.setMenuId(tblMenuItem.getMenuId());
//          l.setMenuItemId(tblMenuItem.getMenuItemId());
        
        se.saveOrUpdate(tmi);
        se.getTransaction().commit();
        se.close();
    }
    
}