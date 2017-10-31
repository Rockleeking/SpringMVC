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
    <p id="edit">
        
    </p>
    

        <form:form action="addPage" method="POST" modelAttribute="tblp">
                                <table>
                                <tr><td>Page Name</td><td><form:input path="pageName"/></td> </tr>
                                <tr><td>Content:</td><td><form:input path="pageContent"/></td></tr>
                                <tr><td>slug:</td><td><form:input path="pageSlug"/></td></tr>
                                </table>
                                <input type="submit" value="Add Page">
                                </form:form>
        
        <table class="table"  border="1"><thead><th>page Id</th><th>Page Name</th><th>Page Content</th><th>Page slug</th><th>Edit</th><th>Delete</th></thead>
<tbody><c:forEach var="tblPage1" items="${tblPag}" begin="0" varStatus="loop"><tr><td>${tblPage1.pageId}</td>
<td>${tblPage1.pageName}</td>
<td>${tblPage1.pageContent}</td>
<td>${tblPage1.pageSlug}</td>
<td><a href = '${pageContext.request.contextPath}/admin/editTable/${tblPage1.pageId}'><button>Edit</button></td>
<td><a href="${pageContext.request.contextPath}/admin/page/delete/${tblPage1.pageId}">Delete</a></td>
</tr></c:forEach></tbody>
</table>
</div>
</div>
           
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-min.js"></script>
    </body>
</html>
