package com.tr2016.hederkosher.utils;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Created by user on 23/12/16.
 */

public class Message {
    private String text;
    private Date date;
    private int type;

    public Message() {
    }

    public Message(Date date,String message,int type) {
        this.date = date;
        this.text = message;
        this.type = type;
    }

    public int getType() {
        return type;
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

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}