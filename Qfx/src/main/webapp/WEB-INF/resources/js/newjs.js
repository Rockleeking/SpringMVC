function page(){
                        str='<table ><thead><th>page Id</th><th>Page Name</th><th>Page Content</th><th>Page slug</th></thead><tbody><c:forEach var="tblPage" items="${tblPage}"><tr><td>${tblPage.pageId}</td><td>${tblPage.pageName}</td><td>${tblPage.pageContent}</td><td>${tblPage.pageSlug}</td></tr></c:forEach></tbody></table>';
                        document.getElementById("demo").innerHTML=str;
                        
                    }


function edit(){
    
    str='<form method="post" action="UpdatePage"><br><input type="hidden" value="${tblPage1.pageId}" name="id">Page Name:<input type="text" name="pageName" value="${tblPage1.pageName}"><br>Page Content: <textarea name="pageContent" value="${tblPage1.pageContent}"><br>Duration: <input type="text" name="time" value="${ticket.time}"><br>Seat Number: <input type="text" name="seatno" value="${ticket.seatno}"><br>Hall number: <input type="text" name="hallno" value="${ticket.hallno}"><br><input type="submit" value="Submit"></form>';}