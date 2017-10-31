/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblTicket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblTicketDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblTicketServiceImpl implements TblTicketService{
    @Autowired
    TblTicketDAO tblTicketDAO;

    @Override
    public TblTicket getTblTicket(int tblTicketId) {
        return tblTicketDAO.getTblTicket(tblTicketId);
    }

    @Override
    public TblTicket edit(int tblTicketId) {
        return tblTicketDAO.edit(tblTicketId);
        
    }

    @Override
    public void delete(int tblTicketId) {
        tblTicketDAO.delete(tblTicketId);
    }

    @Override
    public void insert(TblTicket tblTicket) {
        tblTicketDAO.insert(tblTicket);    }

    @Override
    public List<TblTicket> displayTblTicket() {
        return tblTicketDAO.displayTblTicket();    }

    @Override
    public void updateTblTicket(TblTicket tblTicket) {
        tblTicketDAO.updateTblTicket(tblTicket);    }
    
}
