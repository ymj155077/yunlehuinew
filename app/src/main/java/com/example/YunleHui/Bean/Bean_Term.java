package com.example.YunleHui.Bean;

/**
 * Created by admin on 2019/8/20 0020.
 */

public class Bean_Term {


    /**
     * success : false
     * code : 10004
     * msg : 已经超过有效期
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
