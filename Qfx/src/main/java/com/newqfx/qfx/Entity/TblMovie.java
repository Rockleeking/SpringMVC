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
@Table(name = "tbl_movie", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMovie.findAll", query = "SELECT t FROM TblMovie t")
    , @NamedQuery(name = "TblMovie.findByMId", query = "SELECT t FROM TblMovie t WHERE t.mId = :mId")
    , @NamedQuery(name = "TblMovie.findByMName", query = "SELECT t FROM TblMovie t WHERE t.mName = :mName")
    , @NamedQuery(name = "TblMovie.findByMReleaseDate", query = "SELECT t FROM TblMovie t WHERE t.mReleaseDate = :mReleaseDate")
    , @NamedQuery(name = "TblMovie.findByMTime", query = "SELECT t FROM TblMovie t WHERE t.mTime = :mTime")})
public class TblMovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "m_id")
    private Integer mId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "m_name")
    private String mName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "m_desc")
    private String mDesc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "m_photo_url")
    private String mPhotoUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_release_date")
    @Temporal(TemporalType.DATE)
    private Date mReleaseDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "m_time")
    private String mTime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "m_director")
    private String mDirector;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "m_genre")
    private String mGenre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "m_cast")
    private String mCast;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "m_trailer_url")
    private String mTrailerUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mId")
    private Set<TblShow> tblShowSet;

    public TblMovie() {
    }

    public TblMovie(Integer mId) {
        this.mId = mId;
    }

    public TblMovie(Integer mId, String mName, String mDesc, String mPhotoUrl, Date mReleaseDate, String mTime, String mDirector, String mGenre, String mCast, String mTrailerUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mDesc = mDesc;
        this.mPhotoUrl = mPhotoUrl;
        this.mReleaseDate = mReleaseDate;
        this.mTime = mTime;
        this.mDirector = mDirector;
        this.mGenre = mGenre;
        this.mCast = mCast;
        this.mTrailerUrl = mTrailerUrl;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMDesc() {
        return mDesc;
    }

    public void setMDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public String getMPhotoUrl() {
        return mPhotoUrl;
    }

    public void setMPhotoUrl(String mPhotoUrl) {
        this.mPhotoUrl = mPhotoUrl;
    }

    public Date getMReleaseDate() {
        return mReleaseDate;
    }

    public void setMReleaseDate(Date mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getMTime() {
        return mTime;
    }

    public void setMTime(String mTime) {
        this.mTime = mTime;
    }

    public String getMDirector() {
        return mDirector;
    }

    public void setMDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public String getMGenre() {
        return mGenre;
    }

    public void setMGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getMCast() {
        return mCast;
    }

    public void setMCast(String mCast) {
        this.mCast = mCast;
    }

    public String getMTrailerUrl() {
        return mTrailerUrl;
    }

    public void setMTrailerUrl(String mTrailerUrl) {
        this.mTrailerUrl = mTrailerUrl;
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
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMovie)) {
            return false;
        }
        TblMovie other = (TblMovie) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblMovie[ mId=" + mId + " ]";
    }
    
}
