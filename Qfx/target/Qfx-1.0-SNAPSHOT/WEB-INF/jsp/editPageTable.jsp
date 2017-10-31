<%-- 
    Document   : edit page
    Created on : Aug 13, 2017, 12:17:58 PM
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            
        </title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <div name="edit">
    

            <form method="post" action="UpdatePage"><table class="table"  border="1">
                <tr style="border: none;"><td><input type="hidden" value="${tblp.pageId}" name="id"></td></tr>
                <tr><td>Page Name:</td><td><input type="text" name="pageName" value="${tblp.pageName}"/></td></tr>
                <tr><td>Page Content:</td><td> <textarea name="pageContent" rows="4" cols="50">${tblp.pageContent}</textarea></td></tr>
                <tr><td> Page Slug</td><td><input type="text" name="pageSlug" value = "${tblp.pageSlug}" /></td></tr>
                <tr><td> <input type="submit" value="Submit"/></td></tr></table></form>
        
</div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-min.js"></script>
    </body>
</html>
