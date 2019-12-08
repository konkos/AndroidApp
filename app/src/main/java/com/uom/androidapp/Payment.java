package com.uom.androidapp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

//USE ECLIPSE FOR TESTS

public abstract class Payment {
    private Double amount;
    private String pattern = "dd MM yy";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private Date date = new Date();

    public Payment() {}

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
