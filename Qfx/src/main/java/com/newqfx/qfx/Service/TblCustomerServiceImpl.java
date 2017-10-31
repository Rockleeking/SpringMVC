/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblCustomer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newqfx.qfx.DAO.TblCustomerDAO;

/**
 *
 * @author root
 */
@Service
@Transactional
public class TblCustomerServiceImpl implements TblCustomerService{
    @Autowired
    TblCustomerDAO tblCustomerDAO;

    @Override
    public TblCustomer getTblCustomer(int tblCustomerId) {
        return tblCustomerDAO.getTblCustomer(tblCustomerId);
    }

    @Override
    public TblCustomer edit(int tblCustomerId) {
        return tblCustomerDAO.edit(tblCustomerId);
        
    }

    @Override
    public void delete(int tblCustomerId) {
        tblCustomerDAO.delete(tblCustomerId);
    }

    @Override
    public void insert(TblCustomer tblCustomer) {
        tblCustomerDAO.insert(tblCustomer);    }

    @Override
    public List<TblCustomer> displayTblCustomer() {
        return tblCustomerDAO.displayTblCustomer();    }

    @Override
    public void updateTblCustomer(TblCustomer tblCustomer) {
        tblCustomerDAO.updateTblCustomer(tblCustomer);    }
    
}
