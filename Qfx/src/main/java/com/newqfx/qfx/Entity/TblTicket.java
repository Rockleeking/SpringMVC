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
 * @author root
 */
@Entity
@Table(name = "tbl_ticket", catalog = "db_qfx", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTicket.findAll", query = "SELECT t FROM TblTicket t")
    , @NamedQuery(name = "TblTicket.findByTicketId", query = "SELECT t FROM TblTicket t WHERE t.ticketId = :ticketId")
    , @NamedQuery(name = "TblTicket.findByTicketSeatNo", query = "SELECT t FROM TblTicket t WHERE t.ticketSeatNo = :ticketSeatNo")})
public class TblTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ticket_seat_no")
    private String ticketSeatNo;
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    @ManyToOne(optional = false)
    private TblCustomer cId;
    @JoinColumn(name = "show_id", referencedColumnName = "show_id")
    @ManyToOne(optional = false)
    private TblShow showId;

    public TblTicket() {
    }

    public TblTicket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public TblTicket(Integer ticketId, String ticketSeatNo) {
        this.ticketId = ticketId;
        this.ticketSeatNo = ticketSeatNo;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketSeatNo() {
        return ticketSeatNo;
    }

    public void setTicketSeatNo(String ticketSeatNo) {
        this.ticketSeatNo = ticketSeatNo;
    }

    public TblCustomer getCId() {
        return cId;
    }

    public void setCId(TblCustomer cId) {
        this.cId = cId;
    }

    public TblShow getShowId() {
        return showId;
    }

    public void setShowId(TblShow showId) {
        this.showId = showId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTicket)) {
            return false;
        }
        TblTicket other = (TblTicket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newqfx.qfx.Entity.TblTicket[ ticketId=" + ticketId + " ]";
    }
    
}
