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
@Table(name = "tbl_theatre", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTheatre.findAll", query = "SELECT t FROM TblTheatre t")
    , @NamedQuery(name = "TblTheatre.findByThId", query = "SELECT t FROM TblTheatre t WHERE t.thId = :thId")
    , @NamedQuery(name = "TblTheatre.findByThName", query = "SELECT t FROM TblTheatre t WHERE t.thName = :thName")})
public class TblTheatre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "th_id")
    private Integer thId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "th_name")
    private String thName;
    @JoinColumn(name = "hall_id", referencedColumnName = "hall_id")
    @ManyToOne(optional = false)
    private TblLocation hallId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thId")
    private Set<TblShow> tblShowSet;

    public TblTheatre() {
    }

    public TblTheatre(Integer thId) {
        this.thId = thId;
    }

    public TblTheatre(Integer thId, String thName) {
        this.thId = thId;
        this.thName = thName;
    }

    public Integer getThId() {
        return thId;
    }

    public void setThId(Integer thId) {
        this.thId = thId;
    }

    public String getThName() {
        return thName;
    }

    public void setThName(String thName) {
        this.thName = thName;
    }

    public TblLocation getHallId() {
        return hallId;
    }

    public void setHallId(TblLocation hallId) {
        this.hallId = hallId;
    }

    @XmlTransient
    public Set<TblShow> getTblShowSet() {
        return tblShowSet;
    }

    public void setTblShowSet(Set<TblShow> tblShowSet) {
        this.tblShowSet = tblShowSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thId != null ? thId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTheatre)) {
            return false;
        }
        TblTheatre other = (TblTheatre) object;
        if ((this.thId == null && other.thId != null) || (this.thId != null && !this.thId.equals(other.thId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblTheatre[ thId=" + thId + " ]";
    }
    
}
