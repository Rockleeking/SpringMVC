/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblTheatre;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblTheatreService {
    public void insert(TblTheatre tblTheatre);
    public TblTheatre getTblTheatre(int tblTheatreId);
    public List<TblTheatre> displayTblTheatre();
    public TblTheatre edit(int tblTheatreId);
    public void delete(int tblTheatreId);

    public void updateTblTheatre(TblTheatre tblTheatre);
}
