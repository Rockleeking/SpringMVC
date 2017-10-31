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
@Table(name = "tbl_location", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLocation.findAll", query = "SELECT t FROM TblLocation t")
    , @NamedQuery(name = "TblLocation.findByHallId", query = "SELECT t FROM TblLocation t WHERE t.hallId = :hallId")})
public class TblLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hall_id")
    private Integer hallId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "hall_name")
    private String hallName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "hall_location")
    private String hallLocation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hallId")
    private Set<TblTheatre> tblTheatreSet;

    public TblLocation() {
    }

    public TblLocation(Integer hallId) {
        this.hallId = hallId;
    }

    public TblLocation(Integer hallId, String hallName, String hallLocation) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.hallLocation = hallLocation;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallLocation() {
        return hallLocation;
    }

    public void setHallLocation(String hallLocation) {
        this.hallLocation = hallLocation;
    }

    @XmlTransient
    public Set<TblTheatre> getTblTheatreSet() {
        return tblTheatreSet;
    }

    public void setTblTheatreSet(Set<TblTheatre> tblTheatreSet) {
        this.tblTheatreSet = tblTheatreSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hallId != null ? hallId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLocation)) {
            return false;
        }
        TblLocation other = (TblLocation) object;
        if ((this.hallId == null && other.hallId != null) || (this.hallId != null && !this.hallId.equals(other.hallId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblLocation[ hallId=" + hallId + " ]";
    }
    
}
