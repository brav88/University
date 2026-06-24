<%-- 
    Document   : course
    Created on : 16 jun 2026, 8:39:02 p. m.
    Author     : Personal
--%>

<%@page import="univ.course.com.Course"%>
<%@page import="java.util.List"%>
<%@page import="univ.auth.com.User"%>
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
            int careerId = (int) request.getAttribute("careerId");
            User user = (User) session.getAttribute("UserLogged");
            List<Course> courseList = (List<Course>) request.getAttribute("courseList");
            List<Integer> courseEnrollmentList = (List<Integer>) request.getAttribute("courseEnrollmentList");
        %>

        <nav class="navbar bg-primary" data-bs-theme="dark">
            <a class="navbar-brand" href="CareerServlet" style="margin-left: 15px">University welcome <%=user.getName()%></a>
        </nav>

        <div class="container" style="margin-top:20px">
            <% if (user.getCareerId() == 0) {%>
            <form method="POST" action="EnrollmentServlet?scope=main">
                <input type="hidden" name="userId" value="<%=user.getId()%>">
                <input type="hidden" name="careerId" value="<%=careerId%>">
                <button type="submit" class="btn btn-primary">Enroll me!</button>
            </form>
            <% } %>    
            <div class="row">
                <%
                    String category = "";
                    boolean isFirstTable = true;
                %>

                <% for (Course course : courseList) { %>

                <%-- Si cambia la categoría, cerramos la tabla anterior (si existe) y abrimos una nueva --%>
                <% if (!course.getCategory().equals(category)) { %>

                <% if (!isFirstTable) { %>
                </tbody>
                </table>
            </div> <% }%>

            <h2 class="mt-4 mb-3 text-primary"><%= course.getCategory()%></h2>

            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered align-middle">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col" style="width: 70%;">Nombre del Curso</th>
                            <th scope="col" style="width: 30%;">Creditos</th>
                                <% if (user.getCareerId() == careerId) {%>
                            <th scope="col" style="width: 30%;">Actions</th>
                                <% } %>  
                        </tr>
                    </thead>
                    <tbody>
                        <%
                                isFirstTable = false;
                            }
                        %> 

                        <%-- Filas de la tabla con los datos del curso --%>
                        <tr>
                            <td><strong><%= course.getName()%></strong></td>
                            <td><span class="badge bg-secondary"><%= course.getCredits()%></span></td>
                                <% if (user.getCareerId() == careerId) {%>
                            <td>
                                <%
                                    String scope = courseEnrollmentList.contains(course.getId()) ? "Delete" : "Select";
                                    String style = courseEnrollmentList.contains(course.getId()) ? "danger" : "primary";
                                %>                                                               
                                <form method="POST" action="EnrollmentServlet?scope=<%= scope%>"> 
                                    <input type="hidden" name="careerId" value="<%=careerId%>">
                                    <input type="hidden" name="enrollmentId" value="<%= user.getEnrollmentId()%>" ></input>
                                    <input type="hidden" name="courseId" value="<%= course.getId()%>"></input>      
                                    <button  type="submit" class="btn btn-<%= style%>"><%= scope%></button> 
                                </form>

                            </td>
                            <% } %>  
                        </tr>

                        <%
                            category = course.getCategory();
                        %> 

                        <% } %>

                        <%-- Cierre de la última tabla si la lista no estaba vacía --%>
                        <% if (!courseList.isEmpty()) { %>
                    </tbody>
                </table>
            </div>
            <% }%>

        </div>            
    </div>
</body>
</html>
