package io.vastchain.sdk.param;

public class RefundParam extends VastChainRequestParam{
    /**  要退款的预支付订单号（prepayId） */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
