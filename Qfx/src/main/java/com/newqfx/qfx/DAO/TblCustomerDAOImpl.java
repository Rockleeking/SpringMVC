/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblCustomer;
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
@Repository("tblCustomerService")
public class TblCustomerDAOImpl implements TblCustomerDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblCustomer tblCustomer) {
        sessionFacory.openSession().save(tblCustomer);
    }

    @Override
    public List<TblCustomer> displayTblCustomer() {
    List<TblCustomer> tblCustomer = sessionFacory.openSession().createCriteria(TblCustomer.class).list();

    return tblCustomer;
    }

    @Override
    public void delete(int tblCustomerId) {
        Session se =sessionFacory.openSession();
        TblCustomer tblCustomer = (TblCustomer) se.load(TblCustomer.class, tblCustomerId);
        se.beginTransaction();
        se.delete(tblCustomer);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblCustomer edit(int tblCustomerId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblCustomer.class);
        cr.add(Restrictions.eq("id",tblCustomerId));
        TblCustomer tblCustomer = (TblCustomer)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblCustomer;
    }

    @Override
    public TblCustomer getTblCustomer(int tblCustomerId) {
        return sessionFacory.getCurrentSession().get(TblCustomer.class, tblCustomerId);
        }

    @Override
    public void updateTblCustomer(TblCustomer tblCustomer) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblCustomer.class);
        
        cr.add(Restrictions.eq("id", tblCustomer.getCId()));
        TblCustomer tc = (TblCustomer) cr.uniqueResult();
            
            tc.setCEmail(tblCustomer.getCEmail());
            tc.setCId(tblCustomer.getCId());
            tc.setCPassword(tblCustomer.getCPassword());
            tc.setDob(tblCustomer.getDob());
            tc.setFullName(tblCustomer.getFullName());
            tc.setGender(tblCustomer.getGender());
            tc.setLocation(tblCustomer.getLocation());
            tc.setMobileNo(tblCustomer.getMobileNo());
//          l.setTblCustomerId(tblCustomer.getTblCustomerId());
//          l.setMenuId(tblCustomer.getMenuId());
//          l.setMenuItemId(tblCustomer.getMenuItemId());
        
        se.saveOrUpdate(tc);
        se.getTransaction().commit();
        se.close();
    }
    
}