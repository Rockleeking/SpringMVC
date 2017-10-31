    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "link", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l")
    , @NamedQuery(name = "Link.findByLinkId", query = "SELECT l FROM Link l WHERE l.linkId = :linkId")})
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "link_id")
    private Integer linkId;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private TblMenu menuId;
    @JoinColumn(name = "menu_item_id", referencedColumnName = "menu_item_id")
    @ManyToOne(optional = false)
    private TblMenuItem menuItemId;

    public Link() {
    }

    public Link(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public TblMenu getMenuId() {
        return menuId;
    }

    public void setMenuId(TblMenu menuId) {
        this.menuId = menuId;
    }

    public TblMenuItem getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(TblMenuItem menuItemId) {
        this.menuItemId = menuItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linkId != null ? linkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Link)) {
            return false;
        }
        Link other = (Link) object;
        if ((this.linkId == null && other.linkId != null) || (this.linkId != null && !this.linkId.equals(other.linkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.Link[ linkId=" + linkId + " ]";
    }
    
}
