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
@Table(name = "tbl_menu", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMenu.findAll", query = "SELECT t FROM TblMenu t")
    , @NamedQuery(name = "TblMenu.findByMenuId", query = "SELECT t FROM TblMenu t WHERE t.menuId = :menuId")
    , @NamedQuery(name = "TblMenu.findByMenuName", query = "SELECT t FROM TblMenu t WHERE t.menuName = :menuName")})
public class TblMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "menu_name")
    private String menuName;
    @JoinColumn(name = "page_id", referencedColumnName = "page_id")
    @ManyToOne(optional = false)
    private TblPage pageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuId")
    private Set<Link> linkSet;

    public TblMenu() {
    }

    public TblMenu(Integer menuId) {
        this.menuId = menuId;
    }

    public TblMenu(Integer menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMenu)) {
            return false;
        }
        TblMenu other = (TblMenu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblMenu[ menuId=" + menuId + " ]";
    }
    
}
