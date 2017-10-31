/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblMenu;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblMenuDAO {
    public void insert(TblMenu tblMenu);

    public List<TblMenu> displayTblMenu();

    public void delete(int tblMenuId);

    public TblMenu edit(int tblMenuId);

    public TblMenu getTblMenu(int tblMenuId);

    public void updateTblMenu(TblMenu tblMenu);
}
