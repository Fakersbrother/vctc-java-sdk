package itd.vastchain.sdk.param;

import itd.vastchain.sdk.core.VctcApiContext;

public class QueryFungibleBalanceParam{

    /**  是该可信积分发行时所隶属的 appId */
    private String tokenAppId;
    /** 是创建的可信积分的 id */
    private String tokenId;
    /** 要查询用户余额的用户所在的 appId */
    private String userAppId;
    /** 是该用户在所属的 appId 中的 id（即开发者在自己业务系统中的用户 id；该 id 无需事先在宇链云上注册或使用过）；*/
    private String userId;

    public String getTokenAppId() {
        return tokenAppId;
    }

    public void setTokenAppId(String tokenAppId) {
        this.tokenAppId = tokenAppId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserAppId() {
        return userAppId;
    }

    public void setUserAppId(String userAppId) {
        this.userAppId = userAppId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
