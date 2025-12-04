package com.metafutsal.controller;

import com.metafutsal.model.User;
import com.metafutsal.service.UserService;
import com.metafutsal.util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // meampilkan halaman register
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        try {
            // cek email sudah terdaftar
            if (service.findByEmail(email) != null) {
                req.setAttribute("error", "Email sudah terdaftar.");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }

            User u = new User();
            u.setFullname(fullname);
            u.setEmail(email);
            u.setPassword(PasswordUtil.hash(password));
            u.setPhone(phone);

            service.register(u);

            resp.sendRedirect(req.getContextPath() + "/login.jsp?registered=1");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}