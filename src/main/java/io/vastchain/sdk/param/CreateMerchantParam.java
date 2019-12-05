package io.vastchain.sdk.param;


public class CreateMerchantParam extends VastChainRequestParam {
    /**  商户显示名称 */
    private String displayName;
    /** 商户密码*/
    private String pw;
    /** 该商户所属的 appId。该 `appId` 可以和签名用的 `appId` 不同，一旦设置无法修改，未来该 `appId` 拥有修改该 `merchant` 各类信息的权限 */
    private String appId;
    /** （仅创建子商户时传递）该商户所属的父商户 */
    private String parentMerchantId;
    /** 是否禁用该商户 */
    private Boolean disabled;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getParentMerchantId() {
        return parentMerchantId;
    }

    public void setParentMerchantId(String parentMerchantId) {
        this.parentMerchantId = parentMerchantId;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
