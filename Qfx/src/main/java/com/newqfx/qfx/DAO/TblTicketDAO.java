/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblTicket;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblTicketDAO {
    public void insert(TblTicket tblTicket);

    public List<TblTicket> displayTblTicket();

    public void delete(int tblTicketId);

    public TblTicket edit(int tblTicketId);

    public TblTicket getTblTicket(int tblTicketId);

    public void updateTblTicket(TblTicket tblTicket);
}
