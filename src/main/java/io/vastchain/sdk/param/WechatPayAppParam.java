package io.vastchain.sdk.param;

public class WechatPayAppParam extends VastChainRequestParam {
    /** 创建预支付单得到的预支付单号 */
    private String prepayId;
    /** 是否启用订单分润（可选参数），只有和宇链签约的分润商户才支持该选项，否则设置无效；如果分润打开，则该订单的资金不会直接到账，需要调用分润接口进行后续处理 */
    private Boolean enableProfitSharing;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public Boolean getEnableProfitSharing() {
        return enableProfitSharing;
    }

    public void setEnableProfitSharing(Boolean enableProfitSharing) {
        this.enableProfitSharing = enableProfitSharing;
    }
}
