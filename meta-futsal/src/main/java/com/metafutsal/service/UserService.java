package com.metafutsal.service;

import com.metafutsal.dao.UserDAO;
import com.metafutsal.model.User;

public class UserService {
    private UserDAO dao = new UserDAO();

    public User findByEmail(String email) throws Exception {
        return dao.findByEmail(email);
    }

    public boolean register(User u) throws Exception {
        return dao.create(u);
    }
}