package com.metafutsal.controller;

import com.metafutsal.service.BookingService;
import com.metafutsal.model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class HistoryController extends HttpServlet {
    private BookingService service = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s==null || s.getAttribute("userId")==null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        int userId = (Integer) s.getAttribute("userId");
        try {
            List<Booking> history = service.findByUser(userId);
            req.setAttribute("history", history);
            req.getRequestDispatcher("/history.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}