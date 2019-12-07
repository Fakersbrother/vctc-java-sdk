package itd.vastchain.sdk.param;

public class RefundParam {

    /**  要退款的预支付订单号（prepayId） */
    private String id;

    public RefundParam() {
    }

    public RefundParam(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
