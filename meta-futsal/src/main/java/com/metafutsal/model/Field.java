package com.metafutsal.model;

import java.math.BigDecimal;

public class Field {
    private int id;
    private String name;
    private String type;
    private BigDecimal pricePerHour;

    public Field() {}

    public Field(int id, String name, String type, BigDecimal price) {
        this.id=id; this.name=name; this.type=type; this.pricePerHour=price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id=id; }

    public String getName() { return name; }
    public void setName(String name) { this.name=name; }

    public String getType() { return type; }
    public void setType(String type) { this.type=type; }

    public BigDecimal getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(BigDecimal price) { this.pricePerHour=price; }
}