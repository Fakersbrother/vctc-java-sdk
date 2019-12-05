package io.vastchain.sdk.exception;

import com.alibaba.fastjson.JSONObject;

public class ApiResponseException extends Exception{
    private JSONObject raw;

    public ApiResponseException(String message, Throwable cause) {
        super(message, cause);

        if (cause instanceof ApiResponseException) {
            this.raw = ((ApiResponseException) cause).getRaw();
        }
    }

    public ApiResponseException(String message, JSONObject raw) {
        super(message);
        this.raw = raw;
    }

    public ApiResponseException(String message) {
        super(message);
    }

    public JSONObject getRaw() {
        return raw;
    }
}
