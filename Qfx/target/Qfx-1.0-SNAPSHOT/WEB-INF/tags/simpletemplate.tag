<%-- 
    Document   : simpletemplate
    Created on : Jul 4, 2017, 10:21:51 AM
    Author     : root
--%>

<%@tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="title" required="true" rtexprvalue="true"%>
<%@attribute name="content" fragment="true" %>
<%--<%@attribute name="menu" fragment="true" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
        <title>${title}</title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        
          
    </head>
    
    <body>
        <div class="container-fluid">
            <div class="row">
                <jsp:invoke fragment="content"></jsp:invoke>
                
            </div>
        </div>
                <script>
                        function page(){
                            str='<form:form action="addPage" method="POST" modelAttribute="tblp">\n\
                                <table>\n\
                                <tr><td>Page Name</td><td><form:input path="pageName"/></td> </tr>\n\
                                <tr><td>Content:</td><td><form:input path="pageContent"/></td></tr>\n\
                                <tr><td>slug:</td><td><form:input path="pageSlug"/></td></tr>\n\
                                </table>\n\
                                <input type="submit" value="Add Page">\n\
                                </form:form>\n\
                                            \n\
\n\
\n\
\n\
';
                        document.getElementById("demo").innerHTML=str;
                        document.getElementById("edit").innerHTML="";
                        
                    }
                    function menu(){
                            str='<form:form action="addMenu" method="POST" modelAttribute="tblm">\n\
                                <table>\n\
                                <tr><td>Menu Name</td><td><form:input path="menuName"/></td> </tr>\n\
                                <tr><td>Page Id:</td><td><form:select path="pageId" ><c:forEach var="tblPage1" items="${tblPage}"><form:option value="${tblPage1.pageId}" label="${tblPage1.pageId} ${tblPage1.pageName}"/></c:forEach></form:select></td></tr>\n\
                                </table>\n\
                                <input type="submit" value="Add Menu"></form:form>\n\
                                            \n\
\n\
\n\
\n\
<table class="table"  border="1"><thead><th>Menu Id</th><th>Menu Name</th><th>Menu padgeId</th><th>Edit</th><th>Delete</th></thead>\n\
<tbody><c:forEach var="tblMenu1" items="${tblMenu}"><tr><td>${tblMenu1.menuId}</td>\n\
<td>${tblMenu1.menuName}</td>\n\
<td>${tblMenu1.pageId.pageId}</td>\n\
<td><a onclick=\'editMenu(\"${tblMenu1.menuId}\",\"${tblMenu1.menuName}\",\"${tblMenu1.pageId.pageId}\")\'>Edit</a></td>\n\
<td><a href="${pageContext.request.contextPath}/admin/menu/delete/${tblMenu1.menuId}">Delete</a></td>\n\
</tr></c:forEach></tbody>\n\
</table>';
                        document.getElementById("demo").innerHTML=str;
                        document.getElementById("edit").innerHTML="";
                        
                    }
                    
                    function editMenu($a,$b,$c){
                        str = '\n\
                <form method="post" action="UpdateMenu"><table class="table"  border="1 solid"><tr><td><input type="hidden" value="'+$a+'" name="id"></td></tr>\n\
                <tr><td>Menu Name:</td><td><input type="text" name="menuName" value="'+$b+'"/></td></tr>\n\
                <tr><td> Page Id</td><td><select name="pageId"><option value="'+$c+'">'+$c+'</option><c:forEach var="tblPage1" items="${tblPage}"><option value="${tblPage1.pageId}" > ${tblPage1.pageId} ${tblPage1.pageName}</option></c:forEach></select></td></tr>\n\
                <tr><td> <input type="submit" value="Submit"/></td></tr></table></form>';
                        document.getElementById("edit").innerHTML=str;
                    }
                    
                    function menuItem(){
                            str='<form:form action="addMenuItem" method="POST" modelAttribute="tblmi">\n\
                                <table>\n\
                                <tr><td>Menu Item Name</td><td><form:input path="menuItemName"/></td> </tr>\n\
                                <tr><td>Page Id:</td><td><form:select path="pageId">\n\
                                <c:forEach var="tblPage1" items="${tblPage}">\n\
                                <option value="${tblPage1.pageId}">${tblPage1.pageId}  ${tblPage1.pageName}</option>\n\
                                </c:forEach></form:select></td></tr>\n\
                                </table>\n\
                                <input type="submit" value="Add Menu Item"></form:form>\n\
                                            \n\
\n\
\n\
\n\
<table class="table"  border="1"><thead><th>Menu Item Id</th><th>Menu Item Name</th><th>Page Id</th><th>Edit</th><th>Delete</th></thead>\n\
<tbody><c:forEach var="tblMenuItem1" items="${tblMenuItem}" begin="0" varStatus="loop"><tr><td>${tblMenuItem1.menuItemId}</td>\n\
<td>${tblMenuItem1.menuItemName}</td>\n\
<td>${tblMenuItem1.pageId.pageId}</td>\n\
<td><a onclick=\'editPage(\"${tblMenuItem1.menuItemId}\",\"${tblMenuItem1.menuItemName}\",\"${tblMenuItem1.pageId.pageId}\")\'>Edit</a></td>\n\
<td><a href="${pageContext.request.contextPath}/admin/menuItem/delete/${tblMenuItem1.menuItemId}">Delete</a></td>\n\
</tr></c:forEach></tbody>\n\
</table>';
                        document.getElementById("demo").innerHTML=str;
                        document.getElementById("edit").innerHTML="";
                        
                    }
                    
                    function editMenuItem($a,$b,$c){
                        str = '\n\
                <form method="post" action="UpdateMenuItem"><table class="table"  border="1"><tr><td><input type="hidden" value="'+$a+'" name="id"></td></tr>\n\
                <tr><td>Menu Name:</td><td><input type="text" name="menuItemName" value="'+$b+'"/></td></tr>\n\
                <tr><td> Page Id</td><td><input type="text" name="pageId" value = "'+$c+'" /></td></tr>\n\
                <tr><td> <input type="submit" value="Submit"/></td></tr></table></form>';
                        document.getElementById("edit").innerHTML=str;
                    }
                    
                    function link(){
                            str='<form:form action="addMenuItem" method="POST" modelAttribute="l">\n\
                                <table>\n\
                                <tr><td>Menu Id:</td><td><form:select path="menuId">\n\
                                <c:forEach var="tblMenu1" items="${tblMenu}">\n\
                                <option value="${tblMenu1.menuId}">${tblMenu1.menuId} ${tblMenu1.menuName}</option>\n\
                                </c:forEach></form:select></td></tr>\n\
                                <tr><td>MenuItem Id:</td><td><form:select path="menuItemId">\n\
                                <c:forEach var="tblMenuItem1" items="${tblMenuItem}">\n\
                                <option value="${tblMenuItem1.menuItemId}">${tblMenuItem1.menuItemId}  ${tblMenuItem1.menuItemName}</option>\n\
                                </c:forEach></form:select></td></tr>\n\
                                </table>\n\
                                <input type="submit" value="Add link Item"></form:form>\n\
\n\
\n\
\n\
<table class="table"  border="1"><thead><th>link Id</th><th>Menu Item id</th><th>menu Id</th><th>Edit</th><th>Delete</th></thead>\n\
<tbody><c:forEach var="link1" items="${link}" begin="0" varStatus="loop"><tr><td>${link1.linkId}</td>\n\
<td>${link1.menuItemId}</td>\n\
<td>${link1.menuId}</td>\n\
<td><a onclick=\'editLink(\"${link1.menuItemId}\",\"${link1.menuItemId}\",\"${link1.menuId}\")\'>Edit</a></td>\n\
<td><a href="${pageContext.request.contextPath}/admin/link/delete/${link1.linkId}">Delete</a></td>\n\
</tr></c:forEach></tbody>\n\
</table>';
                        document.getElementById("demo").innerHTML=str;
                        document.getElementById("edit").innerHTML="";
                        
                    }
                    function editLink($a,$b,$c){
                        str = '\n\
                <form method="post" action="UpdateLink"><table class="table"  border="1"><tr><td><input type="hidden" value="'+$a+'" name="id"></td></tr>\n\
                <tr><td>MenuItem  ID:</td><td><input type="text" name="menuItemName" value="'+$b+'"/></td></tr>\n\
                <tr><td> Menu Id</td><td><input type="text" name="pageId" value = "'+$c+'" /></td></tr>\n\
                <tr><td> <input type="submit" value="Submit"/></td></tr></table></form>';
                        document.getElementById("edit").innerHTML=str;
                    }
                    
                    function admin(){
                            str='<form:form action="addAdmin" method="POST" modelAttribute="tbla">\n\
                                <table>\n\
                                <tr><td>Admin User Name</td><td><form:input path="adminUname"/></td> </tr>\n\
                                <tr><td>Password:</td><td><form:input path="adminPassword"/></td></tr>\n\
                                <tr><td>Designation:</td><td><form:input path="adminDesignation"/></td></tr>\n\
                                </table>\n\
                                <input type="submit" value="Add Admin"></form:form>\n\
                                            \n\
\n\
\n\
\n\
<table class="table"  border="1"><thead><th>Admin Id</th><th>Admin User Name</th><th>Admin Password</th><th>Deginationg</th><th>Edit</th><th>Delete</th></thead>\n\
<tbody><c:forEach var="tblAdmin1" items="${tblAdmin}" begin="0" varStatus="loop"><tr><td>${tblAdmin1.adminId}</td>\n\
<td>${tblAdmin1.adminUname}</td>\n\
<td>${tblAdmin1.adminPassword}</td>\n\
<td>${tblAdmin1.adminDesignation}</td>\n\
<td><a onclick=\'editAdmin(\"${tblAdmin1.adminId}\",\"${tblAdmin1.adminUname}\",\"${tblAdmin1.adminPassword}\",\"${tblAdmin1.adminDesignation}\" )\'>Edit</a></td>\n\
<td><a href="${pageContext.request.contextPath}/admin/admin/delete/${tblAdmin1.adminId}">Delete</a></td>\n\
</tr></c:forEach></tbody>\n\
</table>';
                        document.getElementById("demo").innerHTML=str;
                        document.getElementById("edit").innerHTML="";
                        
                    }
    function editAdmin($a,$b,$c,$d){
        str = '<form method="post" action="UpdateAdmin"><table class="table"  border="1">\n\
                <tr style="border: none;"><td><input type="hidden" value="'+$a+'" name="id"></td></tr>\n\
                <tr><td>Admin User Name:</td><td><input type="text" name="adminUname" value="'+$b+'"/></td></tr>\n\
                <tr><td>Admin Password:</td><td> <textarea name="adminPassword" rows="4" cols="50">'+$c+'</textarea></td></tr>\n\
                <tr><td>Admin Designation </td><td><input type="text" name="adminDesignation" value = "'+$d+'" /></td></tr>\n\
                <tr><td> <input type="submit" value="Submit"/></td></tr></table></form>';
                        document.getElementById("edit").innerHTML=str;
                        
                    }
                    
                    function customer(){
                            str='<form action="addCustomer" method="POST">\n\
                                <table>\n\
                                <tr><td>Full Name</td><td><input type="text" name="fullName"/></td> </tr>\n\
                                <tr><td>Email:</td><td><input type="text" name="cEmail"/></td></tr>\n\
                                <tr><td>mobile No:</td><td><input type="text" name="mobileNo"/></td></tr>\n\
                                <tr><td>Password:</td><td><input type="text" name="cPassword"/></td></tr>\n\
                                <tr><td>Gender:</td><td><input type="text" name="gender"/></td></tr>\n\
                                <tr><td>Date of birth:</td><td><input name="dob" type="date"/></td></tr>\n\
                                <tr><td>Location:</td><td><input type="text" name="location"/></td></tr>\n\
                                </table>\n\
                                <input type="submit" value="Add member"></form>\n\
\n\
\n\
\n\
<table class="table"  border="1"><thead><th>Customer Id</th><th>Customer Name</th><th>Customer Password</th><th>Gender</th><th>Email</th><th>location</th><th>mobile NO</th><th>DOB</th><th>Edit</th><th>Delete</th></thead>\n\
<tbody><c:forEach var="tblCustomer1" items="${tblCustomer}" begin="0" varStatus="loop"><tr><td>${tblCustomer1.cId}</td>\n\
<td>${tblCustomer1.fullName}</td>\n\
<td>${tblCustomer1.cPassword}</td>\n\
<td>${tblCustomer1.location}</td>\n\
<td>${tblCustomer1.mobileNo}</td>\n\
<td>${tblCustomer1.dob}</td>\n\
<td>${tblCustomer1.cEmail}</td>\n\
<td>${tblCustomer1.gender}</td> \n\
<td><a onclick= \'editAdmin(\"${tblCustomer1.cId}\",\"${tblCustomer1.fullName}\",\"${tblCustomer1.cPassword}\",\"${tblCustomer1.cEmail}\",\"${tblCustomer1.location}\",\"${tblCustomer1.mobileNo}\",\"${tblCustomer1.dob}\",\"${tblCustomer1.gender}\")\'>Edit</a></td>\n\
<td><a href="${pageContext.request.contextPath}/admin/customer/delete/${tblCustomer1.cId}">Delete</a></td>\n\
</tr></c:forEach></tbody>\n\</table>';
                        document.getElementById("demo").innerHTML=str;
                        document.getElementById("edit").innerHTML="";
                        
                    }
    function editCustomer($a,$b,$c,$d,$e,$f,$g,$h){
        str = '<form method="post" action="UpdateAdmin"><table class="table"  border="1">\n\
                <tr style="border: none;"><td><input type="hidden" value="'+$a+'" name="id"></td></tr>\n\
                <tr><td>full Name:</td><td><input type="text" name="fullName" value="'+$b+'"/></td></tr>\n\
                <tr><td>Password:</td><td> <input type ="text" name="cPassword">'+$c+'</textarea></td></tr>\n\
                <tr><td>Email </td><td><input type="text" name="cEmail" value = "'+$d+'" /></td></tr>\n\
                <tr><td>Email </td><td><input type="text" name="location" value = "'+$e+'" /></td></tr>\n\
                <tr><td>Email </td><td><input type="text" name="mobileNo" value = "'+$f+'" /></td></tr>\n\
                <tr><td>Email </td><td><input type="date" name="dob" value = "'+$g+'" /></td></tr>\n\
                <tr><td>Email </td><td><input type="text" name="gender" value = "'+$h+'" /></td></tr>\n\
                <tr><td> <input type="submit" value="Submit"/></td></tr></table></form>';
                        document.getElementById("edit").innerHTML=str;
                        
                    }
                    
                       
                </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-min.js"></script>
<!--        <div class="nav-pills" >
        <div class="header-wrap">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/resources/img/qfx-logo.gif" alt="QFX"/>
            </a>
        </div>
    </div>
        <nav class="navbar navbar-inverse">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/ticket/addticket">Add Ticket</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/ticket/display">Display records</a></li>
            </ul>
        </nav>-->
<!--        <a href="${pageContext.request.contextPath}/index">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/ticket/addticket">Add Ticket</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/ticket/display">Display records</a>-->

            
        
          
            
    </body>
</html>
