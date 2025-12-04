package com.metafutsal.controller;

import com.metafutsal.model.Booking;
import com.metafutsal.model.Field;
import com.metafutsal.service.BookingService;
import com.metafutsal.service.FieldService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class BookingController extends HttpServlet {

    private FieldService fieldService = new FieldService();
    private BookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<Field> fields = fieldService.findAll();
            req.setAttribute("fields", fields);

            // default data
            int fieldId = fields.get(0).getId();
            Date today = new Date(System.currentTimeMillis());

            // jika user memilih field & date
            String f = req.getParameter("field_id");
            String d = req.getParameter("date");

            if (f != null && d != null && !d.isEmpty()) {
                fieldId = Integer.parseInt(f);
                today = Date.valueOf(d);
            }

            // Ambil jam yang sudah dibooking
            List<Time> booked = bookingService.getBookedTimes(fieldId, today);

            req.setAttribute("booked", booked);
            req.setAttribute("selectedField", fieldId);
            req.setAttribute("selectedDate", today);

            req.getRequestDispatcher("/booking.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        try {
            int userId = (int) session.getAttribute("userId");

            // Ambil parameter
            String fieldIdStr = req.getParameter("field_id");
            String dateStr = req.getParameter("date");
            String durationStr = req.getParameter("duration");
            String startStr = req.getParameter("start_time");

            // Validasi null
            if (fieldIdStr == null || dateStr == null ||
                    durationStr == null || startStr == null ||
                    fieldIdStr.isEmpty() || dateStr.isEmpty() ||
                    durationStr.isEmpty() || startStr.isEmpty()) {

                req.setAttribute("error", "Form tidak lengkap. Silakan pilih tanggal, lapangan, jam, dan durasi.");
                req.setAttribute("fields", fieldService.findAll());
                req.getRequestDispatcher("/booking.jsp").forward(req, resp);
                return;
            }

            // Konversi
            int fieldId = Integer.parseInt(fieldIdStr);
            Date date = Date.valueOf(dateStr);
            int duration = Integer.parseInt(durationStr);

            // Format jam → Time
            if (startStr.matches("\\d{2}:\\d{2}")) {
                startStr += ":00";
            }
            Time startTime = Time.valueOf(startStr);

            // Cek tabrakan booking
            if (bookingService.hasConflict(fieldId, date, startTime)) {
                req.setAttribute("error", "Slot waktu sudah dipesan.");
                req.setAttribute("fields", fieldService.findAll());
                req.setAttribute("selectedField", fieldId);
                req.setAttribute("selectedDate", date);

                req.getRequestDispatcher("/booking.jsp").forward(req, resp);
                return;
            }

            // Hitung harga
            BigDecimal pricePerHour = fieldService.findById(fieldId).getPricePerHour();
            BigDecimal totalPrice = pricePerHour.multiply(BigDecimal.valueOf(duration));

            // Simpan booking
            Booking b = new Booking();
            b.setUserId(userId);
            b.setFieldId(fieldId);
            b.setBookingDate(date);
            b.setStartTime(startTime);
            b.setDuration(duration);
            b.setTotalPrice(totalPrice);

            int bookingId = bookingService.create(b);

            resp.sendRedirect(req.getContextPath() + "/payment.jsp?booking_id=" + bookingId);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}