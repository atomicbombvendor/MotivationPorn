package com.practice.motivationporn.exception;

public class PornException extends RuntimeException {

    private String msg;

    public PornException(String msg){
        super(msg);
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return String.format("Porn Exception: %s", msg);
    }
}
