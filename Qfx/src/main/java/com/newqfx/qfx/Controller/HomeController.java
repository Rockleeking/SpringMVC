/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Controller;

import com.newqfx.qfx.Entity.Link;
import com.newqfx.qfx.Entity.TblLocation;
import com.newqfx.qfx.Entity.TblMenu;
import com.newqfx.qfx.Entity.TblMenuItem;
import com.newqfx.qfx.Entity.TblPage;
import com.newqfx.qfx.Service.TblLocationService;
import com.newqfx.qfx.Service.TblMenuService;
import com.newqfx.qfx.Service.TblPageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author root
 */
@Controller
public class HomeController {
    @Autowired
    TblLocationService tls;
    
    
    @Autowired
    TblMenuService tms;
    
    @Autowired
    TblPageService tps;
    
    private int pageno = 1; 
    
    @RequestMapping({"/","/index"})
    public String index(Model model){
       List <TblMenu> menu = tms.displayTblMenu();
       TblPage p = tps.edit(1);
       model.addAttribute("page", p);
       model.addAttribute("menu",menu);
    return "index";
    }
    
    @RequestMapping("/page//{id}")
    public String page(@PathVariable("id") int id,Model model){
        TblPage p = tps.edit(id);
       List <TblMenu> menu = tms.displayTblMenu();
       model.addAttribute("page", p);
       model.addAttribute("menu",menu);
    return "index";
    }
    
    @RequestMapping("/location")
    public String location(Model model){
        List <TblLocation> page = tls.displayTblLocation();
        model.addAttribute("page",page);
        return"location";
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }
    
   
    

    
    
    
        
        
    
    
}
