package ltd.vastchain.sdk.exception;

public class VctcException extends Exception{

    private ErrorCode errCode;
    private String errMsg;

    public Integer getErrCode() {
        return this.errCode.getCode();
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public VctcException() {
    }

    public VctcException(String message, Throwable cause) {
        super(message, cause);
    }

    public VctcException(String message) {
        super(message);
    }

    public VctcException(Throwable cause) {
        super(cause);
    }

    public VctcException(ErrorCode errCode, String errMsg) {
        super(errCode.getCode() + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public VctcException(ErrorCode errCode) {
        super(errCode.getCode() + ":" + errCode.getMsg());
        this.errCode = errCode;
        this.errMsg = errCode.getMsg();
    }

}
