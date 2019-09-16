package com.practice.motivationporn.common;

public enum ResponseStatusEnum {

    SUCCESS(200, "成功"),
    PARAMETER_VALUE_ERROR(402, "参数值不对"),
    UN_LOGIN(501, "用户未登录"),
    TOKEN_INVALID(502, "token失效"),
    UN_AUTHENTICATION(503, "没有权限"),
    BUSINESS_AUTHENTICATION(503, "业务不支持"),
    UPDATE_DATA_INVALID(504, "更新数据已经失效"),
    UPDATE_FAIL(505, "更新数据失败"),
    USER_NOT_EXIStS(507, "用户不存在"),
    USER_REGISTER_FAIL(508, "用户注册失败"),
    QUERY_FAIL(510, "随机获取失败，稍后尝试")
    ;

    private Integer code;

    private String msg;

    ResponseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
