package com.metafutsal.service;

import com.metafutsal.dao.BookingDAO;
import com.metafutsal.model.Booking;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class BookingService {

    private BookingDAO dao = new BookingDAO();

    public int create(Booking b) throws Exception {
        return dao.create(b);
    }

    public boolean hasConflict(int fieldId, Date date, Time time) throws Exception {
        return dao.hasConflict(fieldId, date, time);
    }

    public List<Time> getBookedTimes(int fieldId, Date date) throws Exception {
        return dao.getBookedTimes(fieldId, date);
    }

    public List<Booking> findByUser(int userId) throws Exception {
        return dao.findByUser(userId);
    }
}