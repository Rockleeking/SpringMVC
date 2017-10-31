/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblMovie;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblMovieDAO {
    public void insert(TblMovie tblMovie);

    public List<TblMovie> displayTblMovie();

    public void delete(int tblMovieId);

    public TblMovie edit(int tblMovieId);

    public TblMovie getTblMovie(int tblMovieId);

    public void updateTblMovie(TblMovie tblMovie);
}
