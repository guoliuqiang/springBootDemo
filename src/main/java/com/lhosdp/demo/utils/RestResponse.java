package com.lhosdp.demo.utils;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    final static public String RESULT_OK = "0";
    final static public String RESULT_DUPLICATE = "DUPLICATE_FLOW";
    final static public String NO_ACCOUNT = "NO_ACCOUNT";

    private String resultCode = RESULT_OK;
    private T data;
    private String errorMessage;

    public RestResponse() {
    }

    public RestResponse(String resultCode, String errorMessage) {
        this.resultCode = resultCode;
        this.errorMessage = errorMessage;
    }

    public RestResponse(T data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return RESULT_OK.equals(this.resultCode);
    }

    @JsonIgnore
    public boolean isDuplication() {
        return RESULT_DUPLICATE.equals(this.resultCode);
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static RestResponse errorMessage(String errorMessage) {
        return new RestResponse("BUSINESS_ERROR", errorMessage);
    }

    public static RestResponse needAuth() {
        return new RestResponse("NEED_AUTH", "请登录");
    }

    public static RestResponse duplicateFlow() {
        return new RestResponse(RESULT_DUPLICATE, "重复流水号执行成功");
    }

    public static RestResponse noAccount() {
        return new RestResponse(NO_ACCOUNT, "未开户");
    }
}
