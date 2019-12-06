package itd.vastchain.sdk.exception;

public class VctcClientException extends VctcException{

    private ErrorCode errCode;
    private String errMsg;

    public Integer getErrCode() {
        return this.errCode.getCode();
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public VctcClientException() {
    }

    public VctcClientException(ErrorCode errCode, String errMsg) {
        super(errCode.getCode() + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public VctcClientException(ErrorCode errCode) {
        super(errCode.getCode() + ":" + errCode.getMsg());
        this.errCode = errCode;
        this.errMsg = errCode.getMsg();
    }

}
