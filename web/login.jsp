<%-- 
    Document   : login
    Created on : 9 jun 2026, 8:03:26 p. m.
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Welcome to University State</h3>

        <form action="LoginServlet" method="POST">
            <div>
                Email:<input type="email" name="email" > 
            </div>
            <div>
                Pwd:<input type="password" name="pwd" >
            </div>
            <div>
                <button type="submit" >Login</button>
            </div>
        </form>
    </body>
</html>
