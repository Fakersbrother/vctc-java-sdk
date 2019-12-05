package io.vastchain.sdk.param;


public class SendSmsParam extends VastChainRequestParam {
    /** 手机号，目前只支持同时发送 1 条短信 */
    private String phoneNumbers;
    /** 验证码类型，目前只支持整数 */
    private String codeType;
    /** 短信验证 */
    private String code;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
