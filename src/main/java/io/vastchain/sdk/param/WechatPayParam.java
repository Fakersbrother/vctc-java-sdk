package io.vastchain.sdk.param;

public class WechatPayParam extends VastChainRequestParam {
    /** 创建预支付单得到的预支付单号 */
    private String prepayId;
    /** 下单用户的 openid。为了安全，openid 应该是后端得到，不传递给小程序，且该 API 也应该是后端调用后将结果返回给前端小程序 */
    private String openId;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
