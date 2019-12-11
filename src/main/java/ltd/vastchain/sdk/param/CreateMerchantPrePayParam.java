package ltd.vastchain.sdk.param;

public class CreateMerchantPrePayParam {
    /**  发起支付的子商户号 */
    private String subMerchantId;
    /** 交易金额  以字符串形式发送，最多精确到分 */
    private String totalAmount;
    /** 该交易所关联的订单号，这个版本暂时不使用，为 null 即可 */
    private String orderId;
    /** 该交易所关联的额外信息，可以任意设置，建议使用 JSON 格式*/
    private String extraInfo;

    public CreateMerchantPrePayParam() {
    }

    public CreateMerchantPrePayParam(String subMerchantId, String totalAmount) {
        this.subMerchantId = subMerchantId;
        this.totalAmount = totalAmount;
    }

    public CreateMerchantPrePayParam(String subMerchantId, String totalAmount, String extraInfo) {
        this.subMerchantId = subMerchantId;
        this.totalAmount = totalAmount;
        this.extraInfo = extraInfo;
    }

    public CreateMerchantPrePayParam(String subMerchantId, String totalAmount, String orderId, String extraInfo) {
        this.subMerchantId = subMerchantId;
        this.totalAmount = totalAmount;
        this.orderId = orderId;
        this.extraInfo = extraInfo;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
