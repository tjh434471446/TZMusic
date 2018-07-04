package com.jiehao.tzmusic.pojo;

public class WebResult {
    private int code;
    private String message;
    private POJOBase body;

    public WebResult(int code, String message, POJOBase body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public POJOBase getBody() {
        return body;
    }

    public void setBody(POJOBase body) {
        this.body = body;
    }
}
