package itd.vastchain.sdk.exception;


@SuppressWarnings("all")
public enum ErrorCode {

    APIPARAMS_ISNULL(10001, "apiParams is null"),
    APP_ID_ISNULL(10002, "appId is null"),
    HOSTURL_ISNULL(10003, "hostUrl is null"),
    APP_SECRET_ISNULL(10004, "appSecret is null"),

    ;
    private Integer code;

    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
