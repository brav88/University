<%-- 
    Document   : main
    Created on : 9 jun 2026, 8:24:37 p. m.
    Author     : Personal
--%>

<%@page import="univ.auth.com.User"%>
<%@page import="java.util.List"%>
<%@page import="univ.career.com.Career"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("UserLogged");
            List<Career> careerList = (List<Career>) request.getAttribute("careerList");
        %>

        <nav class="navbar bg-primary" data-bs-theme="dark">
            <a class="navbar-brand" href="main.js" style="margin-left: 15px">University welcome <%=user.getName()%></a>
        </nav>

        <div class="container" style="margin-top:20px">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <% for (Career career : careerList) {%>
                <div class="col d-flex align-items-stretch">
                    <div class="card h-100 w-100">
                        <img src="<%=career.getPhoto()%>" class="card-img-top" alt="Foto de <%=career.getName()%>" style="height: 200px; object-fit: cover;">

                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title"><%=career.getName()%></h5>
                            <p class="card-text flex-grow-1"><%=career.getDescription()%></p>
                            <a href="CourseServlet?careerId=<%=career.getId()%>" class="btn btn-primary mt-auto">Ver programa</a>
                        </div>
                    </div>
                </div>                    
                <% }%>
            </div>            
        </div>
    </body>
</html>
