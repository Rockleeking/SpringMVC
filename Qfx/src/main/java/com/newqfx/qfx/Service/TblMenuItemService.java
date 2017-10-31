/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblMenuItem;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblMenuItemService {
    public void insert(TblMenuItem tblMenuItem);
    public TblMenuItem getTblMenuItem(int tblMenuItemId);
    public List<TblMenuItem> displayTblMenuItem();
    public TblMenuItem edit(int tblMenuItemId);
    public void delete(int tblMenuItemId);

    public void updateTblMenuItem(TblMenuItem tblMenuItem);
}
