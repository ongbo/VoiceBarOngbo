package com.voicebar.entity;

public class ResultMessage {

    private String status;//状态 fail ，success
    private String message;//消息内容

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
