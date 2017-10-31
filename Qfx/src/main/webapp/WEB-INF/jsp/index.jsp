<%-- 
    Document   : simpletemplate
    Created on : Jul 4, 2017, 10:21:51 AM
    Author     : root
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
        <title>Welcome</title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    
    <body>
        <div class="container">
        
        <nav class="navbar navbar-inverse" >    
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                    <img src="${pageContext.request.contextPath}/resources/img/qfx-logo.gif" alt="QFX"/>
                </a>
            </div>
                <ul class="nav navbar-nav" >
                    <c:forEach items="${menu}" var="m">
                <li id="${m.menuName}${m.menuId}"><a href="${pageContext.request.contextPath}/page/${m.pageId.pageId}">${m.menuName}</a></li>
                    </c:forEach>
            </ul>
            </div>
        </nav>
        
            <div>
                ${page.pageContent}
            </div>
          

        </div>
    
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/js/jquery-min.js"></script>
    </body>
</html>
