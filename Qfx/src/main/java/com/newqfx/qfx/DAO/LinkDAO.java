/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;


import com.newqfx.qfx.Entity.Link;
import java.util.List;

/**
 *
 * @author root
 */
public interface LinkDAO {
    public void insert(Link link);

    public List<Link> displayLink();

    public void delete(int linkId);

    public Link edit(int linkId);

    public Link getLink(int linkId);

    public void updateLink(Link link);
}
