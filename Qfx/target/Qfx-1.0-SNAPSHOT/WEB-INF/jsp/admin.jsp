<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags/" %>
<mt:simpletemplate title="admin">
    <jsp:attribute name="content">
        
        <div class="col-sm-2" style="background-color: #fde09d; padding: 10px;">
            
            <div >

                <a href= "${pageContext.request.contextPath}/admin/editPage"><button id="pagebtn" class="btn-block " style="padding: auto; margin-bottom: 10px; " 
                                                                                     autofocus="true">Page Mangement</button></a>
                <button class="btn-block" onclick="menu()" style="padding: auto; margin-bottom: 10px;">Menu Management</button>
                <button class="btn-block" onclick="menuItem()" style="padding: auto; margin-bottom: 10px;">Menu Item Mangent</button>
                <button class="btn-block" onclick="link()" style="padding: auto; margin-bottom: 10px;">Link Management</button>
                </div>
            <div>
                <fieldset>
                    <legend style="font-size: large; border: 1px palegoldenrod   ; margin-top:20px; margin-bottom: 10px; ;text-align: center; font-style: oblique;">Content management:</legend>
                    <button class="btn-block" onclick="admin()" style="padding: auto; margin-bottom: 10px;">Admin Management</button>
                    <button class="btn-block" onclick="customer()" style="padding: auto; margin-bottom: 10px;">Customer Management</button>
                    <button class="btn-block" onclick="" style="padding: auto; margin-bottom: 10px;">Location Management</button>
                    <button class="btn-block" onclick="movie()" style="padding: auto; margin-bottom: 10px;">Movie Management</button>
                    <button class="btn-block" onclick="show()" style="padding: auto; margin-bottom: 10px;">Show Management</button>
                    <button class="btn-block" onclick="theatre()" style="padding: auto; margin-bottom: 10px;">Theatre Management</button>
                    <button class="btn-block" onclick="ticket()" style="padding: auto; margin-bottom: 10px;">Ticket Management</button>
                    

                    
                </fieldset>    
            </div>
            
        </div>
        <div class="col-sm-10" style=" ">
            <span class="col-sm-10" style="background-color: #f2a0a0; padding-left: 5px; padding: 5px; width: 100% "><b>Hello QFX admin . Welcome to the admin page</b></span>
                <div class="col-sm-10" style="background-color: #ffffff" >
                    <p id="demo">
                        
                        <p id="edit">
                            
                        
                            </p>
                    </p>
                    
                </div>
                    
        </div>
           
        
        
    </jsp:attribute>
</mt:simpletemplate>

