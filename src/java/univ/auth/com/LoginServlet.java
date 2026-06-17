/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package univ.auth.com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Personal
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if(session != null){
            session.invalidate();
        }

        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPwd(request.getParameter("pwd"));

        LoginDAO dao = new LoginDAO();
        user = dao.validateLogin(user);

        if (user != null) {
            session = request.getSession();
            session.setAttribute("UserLogged", user);
            response.sendRedirect("CareerServlet");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
