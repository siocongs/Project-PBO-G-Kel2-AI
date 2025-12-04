package com.metafutsal.dao;

import com.metafutsal.model.User;
import com.metafutsal.util.DBUtil;
import java.sql.*;

public class UserDAO {

    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new User(
                    rs.getInt("id"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone")
            );
        }

        return null;
    }

    public boolean create(User user) throws SQLException {
        String sql = "INSERT INTO users(fullname,email,password,phone) VALUES(?,?,?,?)";
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setString(1, user.getFullname());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getPhone());

        return ps.executeUpdate() == 1;
    }
}