/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_customer", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCustomer.findAll", query = "SELECT t FROM TblCustomer t")
    , @NamedQuery(name = "TblCustomer.findByCId", query = "SELECT t FROM TblCustomer t WHERE t.cId = :cId")
    , @NamedQuery(name = "TblCustomer.findByFullName", query = "SELECT t FROM TblCustomer t WHERE t.fullName = :fullName")
    , @NamedQuery(name = "TblCustomer.findByCEmail", query = "SELECT t FROM TblCustomer t WHERE t.cEmail = :cEmail")
    , @NamedQuery(name = "TblCustomer.findByMobileNo", query = "SELECT t FROM TblCustomer t WHERE t.mobileNo = :mobileNo")
    , @NamedQuery(name = "TblCustomer.findByCPassword", query = "SELECT t FROM TblCustomer t WHERE t.cPassword = :cPassword")
    , @NamedQuery(name = "TblCustomer.findByGender", query = "SELECT t FROM TblCustomer t WHERE t.gender = :gender")
    , @NamedQuery(name = "TblCustomer.findByDob", query = "SELECT t FROM TblCustomer t WHERE t.dob = :dob")})
public class TblCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_email")
    private String cEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobile_no")
    private long mobileNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "c_password")
    private String cPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private Set<TblTicket> tblTicketSet;

    public TblCustomer() {
    }

    public TblCustomer(Integer cId) {
        this.cId = cId;
    }

    public TblCustomer(Integer cId, String fullName, String cEmail, long mobileNo, String cPassword, String gender, Date dob, String location) {
        this.cId = cId;
        this.fullName = fullName;
        this.cEmail = cEmail;
        this.mobileNo = mobileNo;
        this.cPassword = cPassword;
        this.gender = gender;
        this.dob = dob;
        this.location = location;
    }

    public TblCustomer(String fullName, String cEmail, long mobileNo, String cPassword, String gender, Date dob, String location) {
        this.fullName = fullName;
        this.cEmail = cEmail;
        this.mobileNo = mobileNo;
        this.cPassword = cPassword;
        this.gender = gender;
        this.dob = dob;
        this.location = location;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCPassword() {
        return cPassword;
    }

    public void setCPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Set<TblTicket> getTblTicketSet() {
        return tblTicketSet;
    }

    public void setTblTicketSet(Set<TblTicket> tblTicketSet) {
        this.tblTicketSet = tblTicketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCustomer)) {
            return false;
        }
        TblCustomer other = (TblCustomer) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblCustomer[ cId=" + cId + " ]";
    }

    
    
}
