package com.metafutsal.dao;

import com.metafutsal.model.Field;
import com.metafutsal.util.DBUtil;

import java.sql.*;
import java.util.*;

public class FieldDAO {

    public List<Field> findAll() throws SQLException {
        List<Field> list = new ArrayList<>();
        String sql = "SELECT * FROM fields";

        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Field f = new Field(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getBigDecimal("price_per_hour")
            );
            list.add(f);
        }
        return list;
    }

    public Field findById(int id) throws SQLException {
        String sql = "SELECT * FROM fields WHERE id = ?";
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Field(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getBigDecimal("price_per_hour")
            );
        }
        return null;
    }
}