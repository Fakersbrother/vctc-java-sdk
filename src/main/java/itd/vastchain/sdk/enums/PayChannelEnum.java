package itd.vastchain.sdk.enums;

public enum PayChannelEnum {
    WECHAT_UNIONPAYBIZSMALL("WechatUnionPayBizSmall"),
    WECHAT_NATIVE("WechatNative");

    private String code;


    PayChannelEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
