package itd.vastchain.sdk.param;

import itd.vastchain.sdk.core.VctcApiContext;

public class RefundParam{
    /**  要退款的预支付订单号（prepayId） */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
