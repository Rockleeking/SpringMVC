/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblTheatre;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblTheatreDAO {
    public void insert(TblTheatre tblTheatre);

    public List<TblTheatre> displayTblTheatre();

    public void delete(int tblTheatreId);

    public TblTheatre edit(int tblTheatreId);

    public TblTheatre getTblTheatre(int tblTheatreId);

    public void updateTblTheatre(TblTheatre tblTheatre);
}
