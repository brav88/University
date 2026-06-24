/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package univ.course.com;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import univ.auth.com.User;
import univ.enrollment.com.EnrollmentDAO;

/**
 *
 * @author Personal
 */
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("UserLogged");

        if (user != null) {
            EnrollmentDAO edao = new EnrollmentDAO();
            List<Integer> courseEnrollmentList = edao.getEnrollmentDetails(user.getId(), user.getEnrollmentId());
            request.setAttribute("courseEnrollmentList", courseEnrollmentList);
        }

        int careerId = Integer.parseInt(request.getParameter("careerId"));
        CourseDAO dao = new CourseDAO();

        List<Course> courseList = dao.getAll(careerId);
        request.setAttribute("courseList", courseList);
        request.setAttribute("careerId", careerId);
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
