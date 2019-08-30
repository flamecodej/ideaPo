package com.oracle.entity;

import java.io.Serializable;

public class ResponseEntity implements Serializable {

    private Integer code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResponseEntity() {
    }

    public ResponseEntity(Integer code) {
        this.code = code;
    }

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
