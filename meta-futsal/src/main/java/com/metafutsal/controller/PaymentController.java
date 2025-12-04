package com.metafutsal.controller;

import com.metafutsal.model.Payment;
import com.metafutsal.service.PaymentService;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;

@MultipartConfig
public class PaymentController extends HttpServlet {
    private PaymentService service = new PaymentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookingIdStr = req.getParameter("booking_id");
        if (bookingIdStr == null) {
            resp.sendRedirect(req.getContextPath() + "/home.jsp");
            return;
        }

        int bookingId = Integer.parseInt(bookingIdStr);
        String method = req.getParameter("method");

        Part proofPart = req.getPart("proof");
        String submittedName = proofPart.getSubmittedFileName();
        String safeName = System.currentTimeMillis() + "_" + (submittedName == null ? "proof.jpg" : submittedName.replaceAll("[^a-zA-Z0-9._-]", "_"));

        String uploadDir = req.getServletContext().getRealPath("/uploads");
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        File out = new File(dir, safeName);
        try (InputStream in = proofPart.getInputStream();
             OutputStream os = new FileOutputStream(out)) {
            byte[] buf = new byte[8192];
            int len;
            while ((len = in.read(buf)) > 0) os.write(buf, 0, len);
        }

        try {
            Payment p = new Payment();
            p.setBookingId(bookingId);
            p.setMethod(method);
            p.setProof(safeName);
            p.setStatus("WAITING");

            service.create(p);

            resp.sendRedirect(req.getContextPath() + "/receipt.jsp?booking_id=" + bookingId);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}