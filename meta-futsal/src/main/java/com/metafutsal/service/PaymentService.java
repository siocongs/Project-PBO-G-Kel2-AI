package com.metafutsal.service;

import com.metafutsal.dao.PaymentDAO;
import com.metafutsal.model.Payment;

public class PaymentService {

    private PaymentDAO dao = new PaymentDAO();

    public boolean create(Payment p) throws Exception {
        return dao.create(p);
    }
}