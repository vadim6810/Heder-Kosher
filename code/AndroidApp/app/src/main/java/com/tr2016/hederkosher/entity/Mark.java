package com.tr2016.hederkosher.entity;

import java.util.Date;

/**
 * Created by Igor on 12.08.2016.
 */
public class Mark {
    private long id;
    private Date date;
    private int mark;
    private String text;
    private boolean enable;

    public Mark(long id, Date date, int mark, String text, boolean enable) {
        this.id = id;
        this.date = date;
        this.mark = mark;
        this.text = text;
        this.enable = enable;
    }

    public Mark() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
