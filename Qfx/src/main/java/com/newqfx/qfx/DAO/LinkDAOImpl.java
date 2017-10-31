/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.Link;
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
@Repository("linkService")
public class LinkDAOImpl implements LinkDAO{

    @Autowired
    SessionFactory sessionFacory;
    
    @Override
    public void insert(Link link) {
        sessionFacory.openSession().save(link);
    }

    @Override
    public List<Link> displayLink() {
    List<Link> link = sessionFacory.openSession().createCriteria(Link.class).list();

    return link;
    }

    @Override
    public void delete(int linkId) {
        Session se =sessionFacory.openSession();
        Link link = (Link) se.load(Link.class, linkId);
        se.beginTransaction();
        se.delete(link);
        se.getTransaction().commit();
        se.close();
    }

    @Override
    public Link edit(int linkId) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(Link.class);
        cr.add(Restrictions.eq("id",linkId));
        Link link = (Link)cr.uniqueResult();
        se.getTransaction().commit();
        se.close();
        return link;
    }

    @Override
    public Link getLink(int linkId) {
        return sessionFacory.getCurrentSession().get(Link.class, linkId);
        }

    @Override
    public void updateLink(Link link) {
        Session se = sessionFacory.openSession();
        se.beginTransaction();
        Criteria cr = se.createCriteria(Link.class);
        
        cr.add(Restrictions.eq("id", link.getLinkId()));
        Link l = (Link) cr.uniqueResult();
        
          l.setLinkId(link.getLinkId());
          l.setMenuId(link.getMenuId());
          l.setMenuItemId(link.getMenuItemId());
        
        se.saveOrUpdate(l);
        se.getTransaction().commit();
        se.close();
    }
    
}