package com.metafutsal.service;

import com.metafutsal.dao.FieldDAO;
import com.metafutsal.model.Field;
import java.util.List;

public class FieldService {

    private FieldDAO dao = new FieldDAO();

    public List<Field> findAll() throws Exception {
        return dao.findAll();
    }

    public Field findById(int id) throws Exception {
        return dao.findById(id);
    }
}