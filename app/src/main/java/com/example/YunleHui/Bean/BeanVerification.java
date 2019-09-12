package com.example.YunleHui.Bean;

/**
 * Created by admin on 2019/8/12 0012.
 */

public class BeanVerification {


    /**
     * success : false
     * code : 800103
     * msg : 支付密码为空,请设置支付密码
     * data : null
     */

    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
