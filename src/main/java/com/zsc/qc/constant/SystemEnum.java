package com.zsc.qc.constant;

public enum SystemEnum {

    SYS_STATUS_INTERNAL_SUCCESS("成功",100),
    SYS_STATUS_INTERNAL_ERROR("系统异常，请稍后再试",200),
    SYS_LOGIN_ERROR("请登录后访问",401),
    SYS_LOGIN_PASSWORD_ERROR("密码错误",401),
    SYS_AUTHORITY_ERROR("没有权限访问",403),



    PARAM_ERROR("参数不合法",300),

    CHECK_USER_NAME_NULL("用户名不存在",300),
    CHECK_USER_NAME_EXIST("用户名已存在",300);






    // 成员变量
    private String msg;
    private int code;

    // 构造方法
    private SystemEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
    // 普通方法
    public static String getMsg(int code) {
        for (SystemEnum c : SystemEnum.values()) {
            if (c.getCode() == code) {
                return c.msg;
            }
        }
        return null;
    }

    // get set 方法
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
