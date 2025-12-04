package com.metafutsal.dao;

import com.metafutsal.model.Payment;
import com.metafutsal.util.DBUtil;

import java.sql.*;

public class PaymentDAO {

    public boolean create(Payment p) throws SQLException {
        String sql = "INSERT INTO payments(booking_id,method,proof,status) VALUES(?,?,?,?)";

        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setInt(1, p.getBookingId());
        ps.setString(2, p.getMethod());
        ps.setString(3, p.getProof());
        ps.setString(4, p.getStatus());

        return ps.executeUpdate() == 1;
    }
}