/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package univ.enrollment.com;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Personal
 */
public class EnrollmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scope = request.getParameter("scope");

        int careerId = Integer.parseInt(request.getParameter("careerId"));

        if (scope.equals("main")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            EnrollmentDAO dao = new EnrollmentDAO();
            dao.insertEnrollment(userId, careerId);
            response.sendRedirect("CareerServlet");
        }
        if (scope.equals("Select")) {
            int enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            EnrollmentDAO dao = new EnrollmentDAO();
            dao.insertEnrollmentDetail(enrollmentId, courseId);
            response.sendRedirect("CourseServlet?careerId=" + careerId);
        }
        if (scope.equals("Delete")) {
            int enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            EnrollmentDAO dao = new EnrollmentDAO();
            dao.deleteEnrollmentDetail(enrollmentId, courseId);
            response.sendRedirect("CourseServlet?careerId=" + careerId);
        }
    }
}
