package com.practice.motivationporn.common;

/**
 * @author haoyue
 */

public enum TokenEnum {

    /**
     * 加密盐
     */
    SALT("Bearer"),
    /**
     * 头部标题
     */
    TITLE("Bearer "),
    /**
     * 发布者
     */
    ISSUER("MotivationPorn"),
    /**
     * 过期时间
     */
    EXPIRE_SECONDS("86400");

    private String value;

    TokenEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
