/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblMenuItem;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblMenuItemDAO {
    public void insert(TblMenuItem tblMenuItem);

    public List<TblMenuItem> displayTblMenuItem();

    public void delete(int tblMenuItemId);

    public TblMenuItem edit(int tblMenuItemId);

    public TblMenuItem getTblMenuItem(int tblMenuItemId);

    public void updateTblMenuItem(TblMenuItem tblMenuItem);
}
