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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_admin", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmin.findAll", query = "SELECT t FROM TblAdmin t")
    , @NamedQuery(name = "TblAdmin.findByAdminId", query = "SELECT t FROM TblAdmin t WHERE t.adminId = :adminId")
    , @NamedQuery(name = "TblAdmin.findByAdminUname", query = "SELECT t FROM TblAdmin t WHERE t.adminUname = :adminUname")
    , @NamedQuery(name = "TblAdmin.findByAdminPassword", query = "SELECT t FROM TblAdmin t WHERE t.adminPassword = :adminPassword")
    , @NamedQuery(name = "TblAdmin.findByAdminDesignation", query = "SELECT t FROM TblAdmin t WHERE t.adminDesignation = :adminDesignation")})
public class TblAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "admin_uname")
    private String adminUname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "admin_password")
    private String adminPassword;
    @Size(max = 30)
    @Column(name = "admin_designation")
    private String adminDesignation;

    public TblAdmin() {
    }

    public TblAdmin(Integer adminId) {
        this.adminId = adminId;
    }

    public TblAdmin(Integer adminId, String adminUname, String adminPassword) {
        this.adminId = adminId;
        this.adminUname = adminUname;
        this.adminPassword = adminPassword;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUname() {
        return adminUname;
    }

    public void setAdminUname(String adminUname) {
        this.adminUname = adminUname;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminDesignation() {
        return adminDesignation;
    }

    public void setAdminDesignation(String adminDesignation) {
        this.adminDesignation = adminDesignation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmin)) {
            return false;
        }
        TblAdmin other = (TblAdmin) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblAdmin[ adminId=" + adminId + " ]";
    }
    
}
