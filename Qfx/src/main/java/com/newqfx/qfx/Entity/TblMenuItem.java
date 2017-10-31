/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_menu_item", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMenuItem.findAll", query = "SELECT t FROM TblMenuItem t")
    , @NamedQuery(name = "TblMenuItem.findByMenuItemId", query = "SELECT t FROM TblMenuItem t WHERE t.menuItemId = :menuItemId")
    , @NamedQuery(name = "TblMenuItem.findByMenuItemName", query = "SELECT t FROM TblMenuItem t WHERE t.menuItemName = :menuItemName")})
public class TblMenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_item_id")
    private Integer menuItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "menu_item_name")
    private String menuItemName;
    @JoinColumn(name = "page_id", referencedColumnName = "page_id")
    @ManyToOne(optional = false)
    private TblPage pageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuItemId")
    private Set<Link> linkSet;

    public TblMenuItem() {
    }

    public TblMenuItem(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public TblMenuItem(Integer menuItemId, String menuItemName) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
    }

    public Integer getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public TblPage getPageId() {
        return pageId;
    }

    public void setPageId(TblPage pageId) {
        this.pageId = pageId;
    }

    @XmlTransient
    public Set<Link> getLinkSet() {
        return linkSet;
    }

    public void setLinkSet(Set<Link> linkSet) {
        this.linkSet = linkSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuItemId != null ? menuItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMenuItem)) {
            return false;
        }
        TblMenuItem other = (TblMenuItem) object;
        if ((this.menuItemId == null && other.menuItemId != null) || (this.menuItemId != null && !this.menuItemId.equals(other.menuItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblMenuItem[ menuItemId=" + menuItemId + " ]";
    }
    
}
