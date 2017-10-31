/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblLocation;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblLocationDAO {
    public void insert(TblLocation tblLocation);

    public List<TblLocation> displayTblLocation();

    public void delete(int tblLocationId);

    public TblLocation edit(int tblLocationId);

    public TblLocation getTblLocation(int tblLocationId);

    public void updateTblLocation(TblLocation tblLocation);
}
