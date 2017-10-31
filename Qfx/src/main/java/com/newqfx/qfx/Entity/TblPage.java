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
import javax.persistence.Lob;
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
@Table(name = "tbl_page", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPage.findAll", query = "SELECT t FROM TblPage t")
    , @NamedQuery(name = "TblPage.findByPageId", query = "SELECT t FROM TblPage t WHERE t.pageId = :pageId")
    , @NamedQuery(name = "TblPage.findByPageName", query = "SELECT t FROM TblPage t WHERE t.pageName = :pageName")
    , @NamedQuery(name = "TblPage.findByPageSlug", query = "SELECT t FROM TblPage t WHERE t.pageSlug = :pageSlug")})
public class TblPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "page_id")
    private Integer pageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "page_name")
    private String pageName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "page_content")
    private String pageContent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "page_slug")
    private String pageSlug;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private Set<TblMenu> tblMenuSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private Set<TblMenuItem> tblMenuItemSet;

    public TblPage() {
    }

    public TblPage(Integer pageId) {
        this.pageId = pageId;
    }

    public TblPage(Integer pageId, String pageName, String pageContent, String pageSlug) {
        this.pageId = pageId;
        this.pageName = pageName;
        this.pageContent = pageContent;
        this.pageSlug = pageSlug;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public String getPageSlug() {
        return pageSlug;
    }

    public void setPageSlug(String pageSlug) {
        this.pageSlug = pageSlug;
    }

    @XmlTransient
    public Set<TblMenu> getTblMenuSet() {
        return tblMenuSet;
    }

    public void setTblMenuSet(Set<TblMenu> tblMenuSet) {
        this.tblMenuSet = tblMenuSet;
    }

    @XmlTransient
    public Set<TblMenuItem> getTblMenuItemSet() {
        return tblMenuItemSet;
    }

    public void setTblMenuItemSet(Set<TblMenuItem> tblMenuItemSet) {
        this.tblMenuItemSet = tblMenuItemSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPage)) {
            return false;
        }
        TblPage other = (TblPage) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblPage[ pageId=" + pageId + " ]";
    }
    
}
