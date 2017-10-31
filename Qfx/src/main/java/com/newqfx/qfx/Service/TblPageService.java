/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Service;

import com.newqfx.qfx.Entity.TblPage;
import java.util.List;

/**
 *
 * @author root
 */
public interface TblPageService {
    public void insert(TblPage tblPage);
    public TblPage getTblPage(int tblPageId);
    public List<TblPage> displayTblPage();
    public TblPage edit(int tblPageId);
    public void delete(int tblPageId);

    public void updateTblPage(TblPage tblPage);
}
