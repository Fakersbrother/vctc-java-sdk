package ltd.vastchain.sdk.param;

public class SubMerchantPayInfoParam {

    /**
     * 二维码 scene 里解析出的子商户预支付单号；
     */
    private String prepayid;
    /**
     * 可选值为 0 或 1，默认为 0，代表是否阻塞以等待实时的支付成功通知（强烈推荐）
     */
    private String waitForFinish;

    public SubMerchantPayInfoParam() {
    }

    public SubMerchantPayInfoParam(String prepayid, String waitForFinish) {
        this.prepayid = prepayid;
        this.waitForFinish = waitForFinish;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getWaitForFinish() {
        return waitForFinish;
    }

    public void setWaitForFinish(String waitForFinish) {
        this.waitForFinish = waitForFinish;
    }
}
