package com.tr2016.hederkosher.utils;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Created by user on 23/12/16.
 */

public class Message {
    private String text;
    private Date date;

    public Message() {
    }

    public Message(Date date,String message) {
        this.date = date;
        this.text = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }
    public String getDateToString() {
        return DateFormat.format("yyyy-MM-dd hh:mm:ss",date).toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }
}