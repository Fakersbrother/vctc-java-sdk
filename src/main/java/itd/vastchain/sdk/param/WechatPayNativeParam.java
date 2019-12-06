package itd.vastchain.sdk.param;

import itd.vastchain.sdk.core.VctcApiContext;

public class WechatPayNativeParam{
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
