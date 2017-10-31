/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblTicket;
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
@Repository("tblTicketService")
public class TblTicketDAOImpl implements TblTicketDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(TblTicket tblTicket) {
        sessionFacory.openSession().save(tblTicket);
    }

    @Override
    public List<TblTicket> displayTblTicket() {
    List<TblTicket> tblTicket = sessionFacory.openSession().createCriteria(TblTicket.class).list();

    return tblTicket;
    }

    @Override
    public void delete(int tblTicketId) {
        Session se =sessionFacory.openSession();
        TblTicket tblTicket = (TblTicket) se.load(TblTicket.class, tblTicketId);
        se.beginTransaction();
        se.delete(tblTicket);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public TblTicket edit(int tblTicketId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblTicket.class);
        cr.add(Restrictions.eq("id",tblTicketId));
        TblTicket tblTicket = (TblTicket)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return tblTicket;
    }

    @Override
    public TblTicket getTblTicket(int tblTicketId) {
        return sessionFacory.getCurrentSession().get(TblTicket.class, tblTicketId);
        }

    @Override
    public void updateTblTicket(TblTicket tblTicket) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(TblTicket.class);
        
        cr.add(Restrictions.eq("id", tblTicket.getTicketId()));
        TblTicket tt = (TblTicket) cr.uniqueResult();
        
          tt.setCId(tblTicket.getCId());
          tt.setShowId(tblTicket.getShowId());
          tt.setTicketId(tblTicket.getTicketId());
          tt.setTicketSeatNo(tblTicket.getTicketSeatNo());
        
        se.saveOrUpdate(tt);
        se.getTransaction().commit();
        se.close();
    }
    
}