package com.metafutsal.controller;

import com.metafutsal.model.User;
import com.metafutsal.service.UserService;
import com.metafutsal.util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // menampilkan halaman login
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            User u = service.findByEmail(email);
            if (u != null && PasswordUtil.verify(password, u.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("userId", u.getId());
                session.setAttribute("fullname", u.getFullname());
                session.setAttribute("email", u.getEmail());
                resp.sendRedirect(req.getContextPath() + "/home.jsp");
            } else {
                req.setAttribute("error", "Email atau password salah.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}