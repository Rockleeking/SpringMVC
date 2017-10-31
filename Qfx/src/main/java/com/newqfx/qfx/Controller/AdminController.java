/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newqfx.qfx.Controller;

import com.newqfx.qfx.Entity.Link;
import com.newqfx.qfx.Entity.TblAdmin;
import com.newqfx.qfx.Entity.TblCustomer;
import com.newqfx.qfx.Entity.TblLocation;
import com.newqfx.qfx.Entity.TblMenu;
import com.newqfx.qfx.Entity.TblMenuItem;
import com.newqfx.qfx.Entity.TblMovie;
import com.newqfx.qfx.Entity.TblPage;
import com.newqfx.qfx.Entity.TblShow;
import com.newqfx.qfx.Entity.TblTheatre;
import com.newqfx.qfx.Entity.TblTicket;
import com.newqfx.qfx.Service.LinkService;
import com.newqfx.qfx.Service.TblAdminService;
import com.newqfx.qfx.Service.TblCustomerService;
import com.newqfx.qfx.Service.TblLocationService;
import com.newqfx.qfx.Service.TblMenuItemService;
import com.newqfx.qfx.Service.TblMenuService;
import com.newqfx.qfx.Service.TblMovieService;
import com.newqfx.qfx.Service.TblPageService;
import com.newqfx.qfx.Service.TblShowService;
import com.newqfx.qfx.Service.TblTheatreService;
import com.newqfx.qfx.Service.TblTicketService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author root
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    
    LinkService linkService;
    
    @Autowired
    TblMenuService tblMenuService;
    
    @Autowired
    TblMenuItemService tblMenuItemService;
    
    @Autowired
    
    TblPageService tblPageService;
    
    @Autowired
    
    TblAdminService tblAdminService;
    
    @Autowired
    
    TblCustomerService tblCustomerService;
    
    @Autowired
    
    TblLocationService tblLocationService;
    
    @Autowired
    
    TblMovieService tblMovieService;
    
    @Autowired
    
    TblShowService tblShowService;
    
    @Autowired
    
    TblTheatreService tblTheatreService;
    
    @Autowired
    
    TblTicketService tblTicketService;
    
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
}
   //---------------INSERT CODE---------------------------- 
 @RequestMapping(value="/addPage",method = RequestMethod.POST)
    public String addPage( @ModelAttribute("tblp") TblPage newPage ){ 
        tblPageService.insert(newPage);
        return "redirect:/admin/welcome";
    }
 @RequestMapping(value="/addMenu",method = RequestMethod.POST)  
    public String addMenu(
            @RequestParam("menuName") String menuName,
            @RequestParam("pageId") int pId ){ 
        TblPage tblPage = tblPageService.edit(pId);
        TblMenu tblMenu = new TblMenu();
        tblMenu.setMenuName(menuName);
        tblMenu.setPageId(tblPage);
        tblMenuService.insert(tblMenu);
        return "redirect:/admin/welcome";
    }
 @RequestMapping(value="/addMenuItem",method = RequestMethod.POST)  
    public String addMenuItem( @ModelAttribute("tblmi") TblMenuItem newMenuItem ){ 
        tblMenuItemService.insert(newMenuItem);
        return "redirect:/admin/welcome";
    }
  
 @RequestMapping(value="/addLink",method = RequestMethod.POST)  
    public String addLink( @ModelAttribute("l") Link newLink ){ 
        linkService.insert(newLink);
        return "redirect:/admin/welcome";
    }   
    
 @RequestMapping(value="/addAdmin",method = RequestMethod.POST)  
    public String addAdmin( @ModelAttribute("tbla") TblAdmin newAdmin ){ 
        tblAdminService.insert(newAdmin);
        return "redirect:/admin/welcome";
    }

 @RequestMapping(value="/addCustomer",method = RequestMethod.POST)  
    public String addCustomer(
            @RequestParam("fullName") String adminUname,
            @RequestParam("cEmail") String cEmail,
            @RequestParam("mobileNo") long mobileNo,
            @RequestParam("cPassword") String cPassword,
            @RequestParam("gender") String gender,
            @RequestParam("dob") Date dob,
            @RequestParam("location") String location){ 
        TblCustomer newCustomer = new TblCustomer(adminUname, cEmail, mobileNo, cPassword, gender, dob, location);
        tblCustomerService.insert(newCustomer);
        return "redirect:/admin/welcome";
    }

 @RequestMapping(value="/addLocation",method = RequestMethod.POST)  
    public String addLocation( @ModelAttribute("tbll") TblLocation newLocation ){ 
        tblLocationService.insert(newLocation);
        return "redirect:/admin/welcome";
    }

 @RequestMapping(value="/addMovie",method = RequestMethod.POST)  
    public String addMovie( @ModelAttribute("tblmo") TblMovie newMovie ){ 
        tblMovieService.insert(newMovie);
        return "redirect:/admin/welcome";
    }
    
 @RequestMapping(value="/addShow",method = RequestMethod.POST)  
    public String addShow( @ModelAttribute("tbls") TblShow newShow ){ 
        tblShowService.insert(newShow);
        return "redirect:/admin/welcome";
    }
    
 @RequestMapping(value="/addTheatre",method = RequestMethod.POST)  
    public String addTheatre( @ModelAttribute("tblth") TblTheatre newTheatre ){ 
        tblTheatreService.insert(newTheatre);
        return "redirect:/admin/welcome";
    }    
    
 @RequestMapping(value="/addTicket",method = RequestMethod.POST)  
    public String addTicket( @ModelAttribute("tblti") TblTicket newTicket ){ 
        tblTicketService.insert(newTicket);
        return "redirect:/admin/welcome";
    }    
    
//---------------Delete CODE---------------------------- 
@RequestMapping("/page/delete//{id}")
    public String deleteTblPage(@PathVariable("id") int id) {
        tblPageService.delete(id);
        return "redirect:/admin/welcome";    
    }
    
@RequestMapping("/menu/delete//{id}")
    public String deleteTblMenu(@PathVariable("id") int id) {
        tblMenuService.delete(id);
        return "redirect:/admin/welcome";    
    }    
    
@RequestMapping("/menuItem/delete//{id}")
    public String deleteTblMenuItem(@PathVariable("id") int id) {
        tblMenuItemService.delete(id);
        return "redirect:/admin/welcome";    
    }
    
@RequestMapping("/link/delete//{id}")
    public String deleteLink(@PathVariable("id") int id) {
        linkService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/admin/delete//{id}")
    public String deleteTblAdmin(@PathVariable("id") int id) {
        tblAdminService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/customer/delete//{id}")
    public String deleteTblCustomer(@PathVariable("id") int id) {
        tblCustomerService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/location/delete//{id}")
    public String deleteTblLocation(@PathVariable("id") int id) {
        tblLocationService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/movie/delete//{id}")
    public String deleteTblMovie(@PathVariable("id") int id) {
        tblMovieService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/show/delete//{id}")
    public String deleteTblShow(@PathVariable("id") int id) {
        tblShowService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/theatre/delete//{id}")
    public String deleteTblTheatre(@PathVariable("id") int id) {
        tblTheatreService.delete(id);
        return "redirect:/admin/welcome";    
    }

@RequestMapping("/ticket/delete//{id}")
    public String deleteTblTicket(@PathVariable("id") int id) {
        tblTicketService.delete(id);
        return "redirect:/admin/welcome";    
    }    
    
   
    
    
    
//---------------Update CODE---------------------------- 
    
    
@RequestMapping(value="/UpdatePage", method = RequestMethod.POST)
    public String updatePage(@RequestParam("id") int id,
            @RequestParam("pageName") String pageName,
            @RequestParam("pageContent") String pageContent,
            @RequestParam("pageSlug") String pageSlug)  {
        System.out.println("I AM HERE AT CONTROLLER");
        TblPage tblPage = new TblPage(id, pageName, pageContent, pageSlug);
        tblPageService.updateTblPage(tblPage);
        
        return "redirect:/admin/welcome";
    }


@RequestMapping(value="/UpdateMenu", method = RequestMethod.POST)
    public String updateMenu(@RequestParam("id") int id,
            @RequestParam("menuName") String menuName,
            @RequestParam("pageId") int pId)  {
        TblPage page = tblPageService.edit(pId);
        TblMenu tblMenu = new TblMenu(id, menuName);
        tblMenu.setPageId(page);
        tblMenuService.updateTblMenu(tblMenu);
        
        return "redirect:/admin/welcome";
    }

@RequestMapping(value="/UpdateMenuItem", method = RequestMethod.POST)
    public String updateTicket(@RequestParam("id") int id,
            @RequestParam("MenuItemName") String menuItemName,
            @RequestParam("pageId") int pId )  {
        TblPage page = tblPageService.edit(pId);
        TblMenuItem tblMenuItem = new TblMenuItem(id, menuItemName);

        tblMenuItem.setPageId(page);
        tblMenuItemService.updateTblMenuItem(tblMenuItem);
        
        return "redirect:/admin/welcome";
    }    
    
    
@RequestMapping(value="/UpdateAdmin", method = RequestMethod.POST)
    public String updateAdmin(@RequestParam("id") int id,
            @RequestParam("adminUname") String adminUname,
            @RequestParam("adminPassword") String adminPassword,
            @RequestParam("adminDesignation") String adminDesignation)  {
        TblAdmin tblAdmin = new TblAdmin(id, adminUname, adminPassword);
        tblAdmin.setAdminDesignation(adminDesignation);
        tblAdminService.updateTblAdmin(tblAdmin);
        
        return "redirect:/admin/welcome";
    }

@RequestMapping(value="/UpdateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@RequestParam("id") int id,
            @RequestParam("fullName") String adminUname,
            @RequestParam("cEmail") String cEmail,
            @RequestParam("mobileNo") long mobileNo,
            @RequestParam("cPassword") String cPassword,
            @RequestParam("gender") String gender,
            @RequestParam("dob") Date dob,
            @RequestParam("location") String location)  {
        TblCustomer tblCustomer = new TblCustomer(id, adminUname, cEmail, mobileNo, cPassword, gender, dob, location);
        tblCustomerService.updateTblCustomer(tblCustomer);
        
        return "redirect:/admin/welcome";
    }

@RequestMapping(value="/UpdateLocation", method = RequestMethod.POST)
    public String updateLocation(@RequestParam("id") int id,
            @RequestParam("hallName") String hallName,
            @RequestParam("hallLocation") String hallLocation)  {
        TblLocation tblLocation = new TblLocation(id, hallName, hallLocation);
        tblLocationService.updateTblLocation(tblLocation);
        
        return "redirect:/admin/welcome";
    }    

@RequestMapping(value="/UpdateMovie", method = RequestMethod.POST)
    public String updateMovie(@RequestParam("id") int id,
            @RequestParam("mName") String mName,
            @RequestParam("mDesc") String mDesc,
            @RequestParam("mPhotoUrl") String mPhotoUrl,
            @RequestParam("mReleaseDate") Date dob,
            @RequestParam("mTime") String mTime,
            @RequestParam("mDirector") String mDirector,
            @RequestParam("mGenre") String mGenre,
            @RequestParam("mCast") String mCast,
            @RequestParam("mTrailerUrl") String mtrailerUrl){
        TblMovie tblMovie = new TblMovie(id, mName, mDesc, mPhotoUrl, dob, mTime, mDirector, mGenre, mCast, mtrailerUrl);
        tblMovieService.updateTblMovie(tblMovie);
        
        return "redirect:/admin/welcome";
    }
    
@RequestMapping(value="/UpdateShow", method = RequestMethod.POST)
    public String updateShow(@RequestParam("id") int id,
            @RequestParam("mId") int mId,
            @RequestParam("thId") int thId,
            @RequestParam("showTime") String showTime){
        TblMovie tblMovie = tblMovieService.edit(mId);
        TblTheatre tblTheatre = tblTheatreService.edit(thId);
        TblShow tblShow = new TblShow(id, showTime);
        tblShow.setMId(tblMovie);
        tblShow.setThId(tblTheatre);
        tblShowService.updateTblShow(tblShow);
        
        return "redirect:/admin/welcome";
    }    

@RequestMapping(value="/UpdateTheatre", method = RequestMethod.POST)
    public String updateTheatre(@RequestParam("id") int id,
            @RequestParam("hallId") int hallId,
            @RequestParam("thName") String thName){
        TblLocation tblLocation = tblLocationService.edit(hallId);
        TblTheatre tblTheatre = new TblTheatre(id, thName);
        tblTheatre.setHallId(tblLocation);
        tblTheatreService.updateTblTheatre(tblTheatre);
        
        return "redirect:/admin/welcome";
    }    
    
    
@RequestMapping(value="/UpdateTicket", method = RequestMethod.POST)
    public String updateTicket(@RequestParam("id") int id,
            @RequestParam("cId") int cId,
            @RequestParam("showId") int showId,
            @RequestParam("ticketSeatNo") String ticketSeatNo){
        TblShow tblShow = tblShowService.edit(showId);
        TblCustomer tblCustomer = tblCustomerService.edit(cId);
        TblTicket tblTicket = new TblTicket(id, ticketSeatNo);
        tblTicket.setCId(tblCustomer);
        tblTicket.setShowId(tblShow);
        tblTicketService.updateTblTicket(tblTicket);
        
        return "redirect:/admin/welcome";
    }    
    
//---------------Mapping Controller CODE----------------------------     
 @RequestMapping("/welcome")
    public String admin(Model model){
        List<Link> link = linkService.displayLink();
        List<TblMenu> tblMenu = tblMenuService.displayTblMenu();
        List<TblMenuItem> tblMenuItem = tblMenuItemService.displayTblMenuItem();
        List<TblPage> tblPage = tblPageService.displayTblPage();
        List<TblAdmin> tblAdmin = tblAdminService.displayTblAdmin();
        List<TblCustomer> tblCustomer = tblCustomerService.displayTblCustomer();
        List<TblLocation> tblLocation = tblLocationService.displayTblLocation();
        List<TblMovie> tblMovie = tblMovieService.displayTblMovie();
        List<TblShow> tblShow =tblShowService.displayTblShow();
        List<TblTheatre> tblTheatre = tblTheatreService.displayTblTheatre();
        List<TblTicket> tblTicket = tblTicketService.displayTblTicket();
        model.addAttribute("link", link);
        model.addAttribute("tblMenu",tblMenu);
        model.addAttribute("tblMenuItem", tblMenuItem);
        model.addAttribute("tblPage", tblPage);
        model.addAttribute("tblAdmin", tblAdmin);
        model.addAttribute("tblCustomer",tblCustomer);
        model.addAttribute("pager",tblLocation);
        model.addAttribute("tblMovie", tblMovie);
        model.addAttribute("tblShow", tblShow);
        model.addAttribute("tblTheatre", tblTheatre);
        model.addAttribute("tblTicket", tblTicket);
        TblPage tblp = new TblPage();
        TblMenu tblm = new TblMenu();
        TblMenuItem tblmi = new TblMenuItem();
        Link l = new Link();
        TblAdmin tbla = new TblAdmin();
        TblCustomer tblc = new TblCustomer();
        TblLocation tbll = new TblLocation();
        TblMovie tblmo = new TblMovie();
        TblShow tbls = new TblShow();
        TblTheatre tblth = new TblTheatre();
        TblTicket tblti = new TblTicket();
        model.addAttribute("tblp", tblp);
        model.addAttribute("tblm", tblm);
        model.addAttribute("tblmi", tblmi);
        model.addAttribute("l",l);
        model.addAttribute("tbla",tbla);
        model.addAttribute("tblc", tblc);
        model.addAttribute("tbll", tbll);
        model.addAttribute("tblmo", tblmo);
        model.addAttribute("tbls", tbls);
        model.addAttribute("tblth", tblth);
        model.addAttribute("tblti", tblti);
        return"admin";
    }
    
@RequestMapping("/editPage")
    public String editPage(Model model) {
       List<TblPage> tp = tblPageService.displayTblPage();
       TblPage tblp = new TblPage();
       model.addAttribute("tblPag",tp);
       model.addAttribute("tblp", tblp);
        return "editPage";    
    } 
@RequestMapping("/editTable//{id}")
    public String editPage(@PathVariable("id") int id,Model model) {
       TblPage tblp =tblPageService.edit(id);
       model.addAttribute("tblp", tblp);
        return "editPageTable";    
    }
    
}
