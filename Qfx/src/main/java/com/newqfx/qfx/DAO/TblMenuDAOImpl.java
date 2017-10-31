/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblMenu;
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
@Repository("tblMenuService")
public class TblMenuDAOImpl implements TblMenuDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblMenu tblMenu) {
        sessionFacory.openSession().save(tblMenu);
    }

    @Override
    public List<TblMenu> displayTblMenu() {
    List<TblMenu> tblMenu = sessionFacory.openSession().createCriteria(TblMenu.class).list();

    return tblMenu;
    }

    @Override
    public void delete(int tblMenuId) {
        Session se =sessionFacory.openSession();
        TblMenu tblMenu = (TblMenu) se.load(TblMenu.class, tblMenuId);
        se.beginTransaction();
        se.delete(tblMenu);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblMenu edit(int tblMenuId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblMenu.class);
        cr.add(Restrictions.eq("id",tblMenuId));
        TblMenu tblMenu = (TblMenu)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblMenu;
    }

    @Override
    public TblMenu getTblMenu(int tblMenuId) {
        return sessionFacory.getCurrentSession().get(TblMenu.class, tblMenuId);
        }

    @Override
    public void updateTblMenu(TblMenu tblMenu) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblMenu.class);
        
        cr.add(Restrictions.eq("id", tblMenu.getMenuId()));
        TblMenu tm = (TblMenu) cr.uniqueResult();
        
            tm.setMenuId(tblMenu.getMenuId());
            tm.setMenuName(tblMenu.getMenuName());
            tm.setPageId(tblMenu.getPageId());
        
//          l.setTblMenuId(tblMenu.getTblMenuId());
//          l.setMenuId(tblMenu.getMenuId());
//          l.setMenuItemId(tblMenu.getMenuItemId());
        
        se.saveOrUpdate(tm);
        se.getTransaction().commit();
        se.close();
    }
    
}