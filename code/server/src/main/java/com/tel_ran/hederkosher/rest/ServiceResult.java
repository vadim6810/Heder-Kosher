package com.tel_ran.hederkosher.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Igor on 05.08.2016.
 */
public class ServiceResult {
    private int code;
    private String message;
    private String description;
    private Object data;

    public ServiceResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.description = null;
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

    /**
     * Defines if this result is successful.
     * @return {@code true} if this result is successful
     */
    @JsonIgnore
    public boolean isSuccessful(){
        return code == 0;
    }
}
