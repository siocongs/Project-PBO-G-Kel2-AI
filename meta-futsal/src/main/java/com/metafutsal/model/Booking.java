package com.metafutsal.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Booking {
    private int id;
    private int userId;
    private int fieldId;
    private Date bookingDate;
    private Time startTime;
    private int duration;
    private BigDecimal totalPrice;

    public Booking() {}

    public Booking(int id, int userId, int fieldId, Date bookingDate, Time startTime, int duration, BigDecimal totalPrice) {
        this.id = id;
        this.userId = userId;
        this.fieldId = fieldId;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getFieldId() { return fieldId; }
    public void setFieldId(int fieldId) { this.fieldId = fieldId; }

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }

    public Time getStartTime() { return startTime; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
}