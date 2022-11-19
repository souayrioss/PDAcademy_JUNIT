package org.pda.junit.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.pda.junit.entity.Admin;
import org.pda.junit.entity.Role;
import org.pda.junit.service.AdminService;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class AuthServlet extends HttpServlet {

    private String message;

    public void init() {
        message = null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (password.isEmpty() || email.isEmpty()) {
            message = "password or email as empty";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        AdminService adminService = new AdminService();

        Admin adminConnect = adminService.login(email,password);
        if (adminConnect == null) {

            message = "password or email as incorrect";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            request.setAttribute("admin",adminConnect);
            HttpSession session = request.getSession();
            session.setAttribute("adminConn", adminConnect);
            if (adminConnect.getRole().equals(Role.ADMIN) ) {
                response.sendRedirect("dashboard");
            } else if (adminConnect.getRole().equals(Role.RESPONSIBLE)) {
                message = "vous etes responsible";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
            } else if (adminConnect.getRole().equals(Role.PARTICIPANT)) {
                message = "vous etes participant";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
            }


        }

    }
    public void destroy() {
    }
}