package com.metafutsal.model;

public class Payment {
    private int id;
    private int bookingId;
    private String method;
    private String proof;
    private String status;

    public Payment() {}

    public Payment(int id,int bookingId,String method,String proof,String status){
        this.id=id; this.bookingId=bookingId;
        this.method=method; this.proof=proof; this.status=status;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public int getBookingId(){ return bookingId; }
    public void setBookingId(int bookingId){ this.bookingId=bookingId; }

    public String getMethod(){ return method; }
    public void setMethod(String method){ this.method=method; }

    public String getProof(){ return proof; }
    public void setProof(String proof){ this.proof=proof; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }
}