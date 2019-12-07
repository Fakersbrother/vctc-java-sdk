package itd.vastchain.sdk.dto;

public class SubMerchantPayInfoDTO extends VctcApiResponseDTO {
    private String merchantDisplayName;
    private String totalAmount;
    /**  注意这里指的是用户要支付的价格，而不是优惠前的价格 */
    private String disconut;
    private String createTime;
    private String paymentTime;

    public String getMerchantDisplayName() {
        return merchantDisplayName;
    }

    public void setMerchantDisplayName(String merchantDisplayName) {
        this.merchantDisplayName = merchantDisplayName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDisconut() {
        return disconut;
    }

    public void setDisconut(String disconut) {
        this.disconut = disconut;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }
}
