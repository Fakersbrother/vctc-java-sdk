package itd.vastchain.sdk.enums;

public enum ApiTypeEnum {
    SEND_SMS("SEND_SMS", "发送短信API"),
    LOGIN_MERCHANT("loginMerchant", "商户登录api"),
    WX_H5_PAY("wx_h5_pay", "微信H5支付渠道"),
    ALI_REFUND("ali_refund", "支付宝退款渠道"),
    WECHAT_REFUND("wechat_refund", "微信退款渠道");

    private String code;

    private String desc;

    ApiTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
}
