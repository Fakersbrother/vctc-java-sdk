package ltd.vastchain.sdk.param;


import ltd.vastchain.sdk.enums.CodeTypeEnum;

public class SendSmsParam {
    /** 手机号，目前只支持同时发送 1 条短信 */
    private String phoneNumbers;
    /** 验证码类型，目前只支持整数 */
    private CodeTypeEnum codeType;
    /** 短信验证 */
    private String code;

    public SendSmsParam() {
    }

    public SendSmsParam(String phoneNumbers, String code) {
        this.phoneNumbers = phoneNumbers;
        this.codeType = CodeTypeEnum.INTEGER;
        this.code = code;
    }

    public SendSmsParam(String phoneNumbers, CodeTypeEnum codeType, String code) {
        this.phoneNumbers = phoneNumbers;
        this.codeType = codeType;
        this.code = code;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public CodeTypeEnum getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeTypeEnum codeType) {
        this.codeType = codeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
