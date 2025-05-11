/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bl.UserFacadeLocal;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;

/**
 *
 * @author moses
 */
public class RegisterServlet extends HttpServlet {
    @EJB
    private UserFacadeLocal ufl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        if (ufl.existsByUsername(username)) {
            request.getRequestDispatcher("signup.html").forward(request, response);
        }

        User user = createUser(username, password, role);

        ufl.create(user);

        request.getRequestDispatcher("register_user_outcome.jsp").forward(request, response);
    }

    private User createUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserRole(role);
        return user;
    }

}
