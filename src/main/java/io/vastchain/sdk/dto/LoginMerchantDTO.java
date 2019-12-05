package io.vastchain.sdk.dto;

public class LoginMerchantDTO extends VastChainDTO {
    private String displayName;
    private String userId;
    private String loginToken;
    private String parentMerchantId;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getParentMerchantId() {
        return parentMerchantId;
    }

    public void setParentMerchantId(String parentMerchantId) {
        this.parentMerchantId = parentMerchantId;
    }
}
