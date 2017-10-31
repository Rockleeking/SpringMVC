<%-- 
    Document   : new
    Created on : Jul 15, 2017, 2:05:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            $(windows).onload(function() {
                str1= "${newone}";
                document.getElementById("view").innerHTML=str1;
                
            };
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${newone}
        <p id="view">
            
        </p>
        
    </body>
</html>
