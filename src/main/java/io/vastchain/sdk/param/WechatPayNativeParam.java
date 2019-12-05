package io.vastchain.sdk.param;

public class WechatPayNativeParam extends VastChainRequestParam {
    /**
     * 创建预支付单得到的预支付单号
     */
    private String prepayId;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
}
