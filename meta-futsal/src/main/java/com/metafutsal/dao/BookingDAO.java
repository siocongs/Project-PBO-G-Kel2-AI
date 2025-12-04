package com.metafutsal.dao;

import com.metafutsal.model.Booking;
import com.metafutsal.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public int create(Booking b) throws SQLException {
        String sql =
                "INSERT INTO bookings(user_id, field_id, booking_date, start_time, duration, total_price) " +
                        "VALUES(?,?,?,?,?,?)";

        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, b.getUserId());
        ps.setInt(2, b.getFieldId());
        ps.setDate(3, b.getBookingDate());
        ps.setTime(4, b.getStartTime());
        ps.setInt(5, b.getDuration());
        ps.setBigDecimal(6, b.getTotalPrice());

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) return rs.getInt(1);
        return -1;
    }

    public boolean hasConflict(int fieldId, Date date, Time time) throws SQLException {
        String sql = "SELECT id FROM bookings WHERE field_id=? AND booking_date=? AND start_time=?";
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setInt(1, fieldId);
        ps.setDate(2, date);
        ps.setTime(3, time);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public List<Booking> findByUser(int userId) throws SQLException {
        List<Booking> list = new ArrayList<>();

        String sql = "SELECT * FROM bookings WHERE user_id=? ORDER BY booking_date DESC";

        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Booking(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("field_id"),
                    rs.getDate("booking_date"),
                    rs.getTime("start_time"),
                    rs.getInt("duration"),
                    rs.getBigDecimal("total_price")
            ));
        }

        return list;
    }

    public List<Time> getBookedTimes(int fieldId, Date date) throws SQLException {
        List<Time> times = new ArrayList<>();

        String sql = "SELECT start_time FROM bookings WHERE field_id=? AND booking_date=?";
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setInt(1, fieldId);
        ps.setDate(2, date);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            times.add(rs.getTime("start_time"));
        }

        return times;
    }
}