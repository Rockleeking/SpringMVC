/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblAdmin;
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
@Repository("tblAdminService")
public class TblAdminDAOImpl implements TblAdminDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblAdmin tblAdmin) {
        sessionFacory.openSession().save(tblAdmin);
    }

    @Override
    public List<TblAdmin> displayTblAdmin() {
    List<TblAdmin> tblAdmin = sessionFacory.openSession().createCriteria(TblAdmin.class).list();

    return tblAdmin;
    }

    @Override
    public void delete(int tblAdminId) {
        Session se =sessionFacory.openSession();
        TblAdmin tblAdmin = (TblAdmin) se.load(TblAdmin.class, tblAdminId);
        se.beginTransaction();
        se.delete(tblAdmin);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblAdmin edit(int tblAdminId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblAdmin.class);
        cr.add(Restrictions.eq("id",tblAdminId));
        TblAdmin tblAdmin = (TblAdmin)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblAdmin;
    }

    @Override
    public TblAdmin getTblAdmin(int tblAdminId) {
        return sessionFacory.getCurrentSession().get(TblAdmin.class, tblAdminId);
        }

    @Override
    public void updateTblAdmin(TblAdmin tblAdmin) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblAdmin.class);
        
        cr.add(Restrictions.eq("id", tblAdmin.getAdminId()));
        TblAdmin ta = (TblAdmin) cr.uniqueResult();
        
            ta.setAdminDesignation(tblAdmin.getAdminDesignation());
            ta.setAdminId(tblAdmin.getAdminId());
            ta.setAdminPassword(tblAdmin.getAdminPassword());
            ta.setAdminUname(tblAdmin.getAdminUname());
        
//          l.setTblAdminId(tblAdmin.getTblAdminId());
//          l.setMenuId(tblAdmin.getMenuId());
//          l.setMenuItemId(tblAdmin.getMenuItemId());
        
        se.saveOrUpdate(ta);
        se.getTransaction().commit();
        se.close();
    }
    
}