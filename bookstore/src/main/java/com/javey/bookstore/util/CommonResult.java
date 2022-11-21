package com.javey.bookstore.util;

public class CommonResult {
    private boolean flag;
    private Object resultData;
    private String message;


    public static CommonResult ok() {
        return new CommonResult().setFlag(true);
    }

    public static CommonResult error() {
        return new CommonResult().setFlag(false);
    }

    public boolean isFlag() {
        return flag;
    }

    public CommonResult setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public Object getResultData() {
        return resultData;
    }

    public CommonResult setResultData(Object resultData) {
        this.resultData = resultData;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "flag=" + flag +
                ", resultData=" + resultData +
                ", message='" + message + '\'' +
                '}';
    }
}
