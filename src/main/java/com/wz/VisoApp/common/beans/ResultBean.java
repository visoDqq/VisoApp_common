package com.wz.VisoApp.common.beans;

/**
 * Created by chenwuxiong on 2017/12/1.
 */
public class ResultBean<T> {

    public final static boolean TRUE = true;

    public final static boolean FALSE = false;

    public final static int FAIL = 10001;

    public final static int SUCCESS = 200;

    public final static String ERROR_MSG = "请求失败";

    public final static String SUCCESS_MSG = "请求成功";

    private boolean success = true;

    private int code = SUCCESS;

    private String message = SUCCESS_MSG;

    private T data;

    public ResultBean() {
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(Throwable throwable) {
        this.success = false;
        this.code = FAIL;
        this.message = ERROR_MSG;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
