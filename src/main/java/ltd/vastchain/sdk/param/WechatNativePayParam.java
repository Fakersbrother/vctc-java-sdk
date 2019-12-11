package ltd.vastchain.sdk.param;

public class WechatNativePayParam {

    /**  创建预支付单得到的预支付单号 */
    private String prepayId;

    public WechatNativePayParam() {

    }
    public WechatNativePayParam(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
}
