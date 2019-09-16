package com.practice.motivationporn.common;

public class ResponseBean {

    private int statusCode;
    private Object data;
    private String msg;

    public ResponseBean(int statusCode, Object data, String msg) {
        this.statusCode = statusCode;
        this.data = data;
        this.msg = msg;
    }

    public static ResponseBean build(Integer status, Object data,  String msg) {
        return new ResponseBean(status, data, msg);
    }

    public static ResponseBean build(ResponseStatusEnum error, Object data) {
        return new ResponseBean(error.getCode(), data, error.getMsg());
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
