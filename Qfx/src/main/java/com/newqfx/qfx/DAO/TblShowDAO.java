/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.DAO;

import com.newqfx.qfx.Entity.TblShow;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblShowDAO {
    public void insert(TblShow tblShow);

    public List<TblShow> displayTblShow();

    public void delete(int tblShowId);

    public TblShow edit(int tblShowId);

    public TblShow getTblShow(int tblShowId);

    public void updateTblShow(TblShow tblShow);
}
