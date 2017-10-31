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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rocklee
 */
@Entity
@Table(name = "tbl_show", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblShow.findAll", query = "SELECT t FROM TblShow t")
    , @NamedQuery(name = "TblShow.findByShowId", query = "SELECT t FROM TblShow t WHERE t.showId = :showId")
    , @NamedQuery(name = "TblShow.findByShowTime", query = "SELECT t FROM TblShow t WHERE t.showTime = :showTime")})
public class TblShow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "show_id")
    private Integer showId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "show_time")
    private String showTime;
    @JoinColumn(name = "th_id", referencedColumnName = "th_id")
    @ManyToOne(optional = false)
    private TblTheatre thId;
    @JoinColumn(name = "m_id", referencedColumnName = "m_id")
    @ManyToOne(optional = false)
    private TblMovie mId;

    public TblShow() {
    }

    public TblShow(Integer showId) {
        this.showId = showId;
    }

    public TblShow(Integer showId, String showTime) {
        this.showId = showId;
        this.showTime = showTime;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public TblTheatre getThId() {
        return thId;
    }

    public void setThId(TblTheatre thId) {
        this.thId = thId;
    }

    public TblMovie getMId() {
        return mId;
    }

    public void setMId(TblMovie mId) {
        this.mId = mId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showId != null ? showId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblShow)) {
            return false;
        }
        TblShow other = (TblShow) object;
        if ((this.showId == null && other.showId != null) || (this.showId != null && !this.showId.equals(other.showId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblShow[ showId=" + showId + " ]";
    }
    
}
