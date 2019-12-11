package ltd.vastchain.sdk.enums;

public enum HttpMethodEnum {
    POST("POST"),
    GET("GET"),
    PUT("PUT");

    private String code;



    HttpMethodEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
