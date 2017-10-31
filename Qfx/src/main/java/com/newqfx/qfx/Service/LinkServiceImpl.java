/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.Link;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.LinkDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class LinkServiceImpl implements LinkService{
    @Autowired
    LinkDAO linkDAO;

    @Override
    public Link getLink(int linkId) {
        return linkDAO.getLink(linkId);
    }

    @Override
    public Link edit(int linkId) {
        return linkDAO.edit(linkId);
        
    }

    @Override
    public void delete(int linkId) {
        linkDAO.delete(linkId);
    }

    @Override
    public void insert(Link link) {
        linkDAO.insert(link);    }

    @Override
    public List<Link> displayLink() {
        return linkDAO.displayLink();    }

    @Override
    public void updateLink(Link link) {
        linkDAO.updateLink(link);    }
    
}
