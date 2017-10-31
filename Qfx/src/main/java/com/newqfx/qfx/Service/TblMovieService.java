/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblMovie;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblMovieService {
    public void insert(TblMovie tblMovie);
    public TblMovie getTblMovie(int tblMovieId);
    public List<TblMovie> displayTblMovie();
    public TblMovie edit(int tblMovieId);
    public void delete(int tblMovieId);

    public void updateTblMovie(TblMovie tblMovie);
}
