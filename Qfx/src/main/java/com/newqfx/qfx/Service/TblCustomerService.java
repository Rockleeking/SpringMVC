/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblCustomer;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblCustomerService {
    public void insert(TblCustomer tblCustomer);
    public TblCustomer getTblCustomer(int tblCustomerId);
    public List<TblCustomer> displayTblCustomer();
    public TblCustomer edit(int tblCustomerId);
    public void delete(int tblCustomerId);

    public void updateTblCustomer(TblCustomer tblCustomer);
}