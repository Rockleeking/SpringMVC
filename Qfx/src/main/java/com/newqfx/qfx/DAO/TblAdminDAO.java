/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblAdmin;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblAdminDAO {
    public void insert(TblAdmin tblAdmin);

    public List<TblAdmin> displayTblAdmin();

    public void delete(int tblAdminId);

    public TblAdmin edit(int tblAdminId);

    public TblAdmin getTblAdmin(int tblAdminId);

    public void updateTblAdmin(TblAdmin tblAdmin);
}
