package com.tel_ran.hederkosher.service;

/**
 * Created by Igor on 05.08.2016.
 */
public class serviceResult {
    private int code;
    private String message;
    private String description;
    private Object data;

    public serviceResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.description = "";
        this.data = null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
