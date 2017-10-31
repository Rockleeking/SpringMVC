<%-- 
    Document   : location
    Created on : Aug 12, 2017, 8:55:33 PM
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

           <table class="table"  border="1">
<thead><th>Hall Id</th><th>Hall Name</th><th>Location</th><th>Edit</th><th>Delete</th></thead>
<tbody><c:forEach var="tblLocation1" items="${page}" varStatus="loop"><tr>
<td>${tblLocation1.hallId}</td>
<td>${tblLocation1.hallName}</td>
<td>${tblLocation1.hallLocation}</td>
<td><a onclick='editLocation("${tblLocation1.hallId},${tblLocation1.hallName},${tblLocation1.hallLocation}")'>Edit</a></td>
<td><a href="${pageContext.request.contextPath}/admin/location/delete/${tblLocation1.hallId}">Delete</a></td>
</tr></c:forEach></tbody>
</table>

    </body>
</html>
