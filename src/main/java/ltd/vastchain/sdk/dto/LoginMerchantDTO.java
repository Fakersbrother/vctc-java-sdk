package ltd.vastchain.sdk.dto;

public class LoginMerchantDTO extends VctcApiResponseDTO {

    /** 商户显示名称 */
    private String displayName;
    private String userId;
    private String loginToken;
    /** 该商户所属的父商户*/
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
