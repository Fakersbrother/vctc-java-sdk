package ltd.vastchain.sdk.param;

import ltd.vastchain.sdk.enums.PayChannelEnum;

public class MerchantPayParam {

    /**
     * 要修改支付参数的商户号或子商户号
     */
    private String id;
    /**
     * 修改参数的支付通道，目前支持 WechatNative（微信支付）、WechatUnionPayBizSmall（银联微信小程序支付）两种
     */
    private PayChannelEnum paymentChannel;
    /**
     * 银联商户号
     */
    private String unionPayBizMchId;
    /**
     * 支付终端 Id
     */
    private String terminalId;
    /** 支付回调地址 */
    private String notifyCallbackUrl;
    /** 是否允许分润（如无需求或尚未开通此业务，请不要设置为 true，否则会导致支付无法入账） */
    private Boolean profitSharing;
    /** 该宇链云子商户或父商户所对应的微信商户在支付时使用的 AppId（比如微信开放平台里的移动应用的 appid 或者微信小程序/公众号的 AppId，注意：如使用分润功能，则这些 Appid 必须和宇链进行微信平台上的绑定，否则无法使用；具体请咨询技术支持） */
    private String wechatAppId;
    /** 该宇链云子商户或父商户收款的微信商户的商户号 */
    private String wechatMchId;

    public MerchantPayParam() {
    }

    /**
     * 修改 WechatUnionPayBizSmall（银联微信小程序支付）参数
     *
     * @param id
     * @param paymentChannel
     * @param unionPayBizMchId
     * @param terminalId
     * @param notifyCallbackUrl
     */
    public MerchantPayParam(String id, PayChannelEnum paymentChannel, String unionPayBizMchId, String terminalId, String notifyCallbackUrl) {
        this.id = id;
        this.paymentChannel = paymentChannel;
        this.unionPayBizMchId = unionPayBizMchId;
        this.terminalId = terminalId;
        this.notifyCallbackUrl = notifyCallbackUrl;
    }

    /**
     * 修改 WechatNative（微信支付）参数
     *
     * @param id
     * @param paymentChannel
     * @param notifyCallbackUrl
     * @param profitSharing
     * @param wechatAppId
     * @param wechatMchId
     */
    public MerchantPayParam(String id, PayChannelEnum paymentChannel, String notifyCallbackUrl, Boolean profitSharing, String wechatAppId, String wechatMchId) {
        this.id = id;
        this.paymentChannel = paymentChannel;
        this.notifyCallbackUrl = notifyCallbackUrl;
        this.profitSharing = profitSharing;
        this.wechatAppId = wechatAppId;
        this.wechatMchId = wechatMchId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PayChannelEnum getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(PayChannelEnum paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getUnionPayBizMchId() {
        return unionPayBizMchId;
    }

    public void setUnionPayBizMchId(String unionPayBizMchId) {
        this.unionPayBizMchId = unionPayBizMchId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getNotifyCallbackUrl() {
        return notifyCallbackUrl;
    }

    public void setNotifyCallbackUrl(String notifyCallbackUrl) {
        this.notifyCallbackUrl = notifyCallbackUrl;
    }

    public Boolean getProfitSharing() {
        return profitSharing;
    }

    public void setProfitSharing(Boolean profitSharing) {
        this.profitSharing = profitSharing;
    }

    public String getWechatAppId() {
        return wechatAppId;
    }

    public void setWechatAppId(String wechatAppId) {
        this.wechatAppId = wechatAppId;
    }

    public String getWechatMchId() {
        return wechatMchId;
    }

    public void setWechatMchId(String wechatMchId) {
        this.wechatMchId = wechatMchId;
    }
}
