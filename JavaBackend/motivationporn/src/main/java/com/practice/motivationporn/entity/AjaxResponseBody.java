package com.practice.motivationporn.entity;

import com.practice.motivationporn.common.ResponseStatusEnum;

import java.io.Serializable;

/**
 * @author haoyue
 * 权限认证返回的对象
 */
public class AjaxResponseBody implements Serializable {

    private Integer status;

    private String msg;

    private Object result;

    private String token;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMsgAndCode(ResponseStatusEnum statusEnum){
        this.status = statusEnum.getCode();
        this.msg = statusEnum.getMsg();
    }
}
