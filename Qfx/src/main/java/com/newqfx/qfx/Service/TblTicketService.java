/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblTicket;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblTicketService {
    public void insert(TblTicket tblTicket);
    public TblTicket getTblTicket(int tblTicketId);
    public List<TblTicket> displayTblTicket();
    public TblTicket edit(int tblTicketId);
    public void delete(int tblTicketId);

    public void updateTblTicket(TblTicket tblTicket);
}
