package itd.vastchain.sdk.param;

public class CreateEveriPayParam {

    /**  是该可信积分发行时所隶属的 appId */
    private String tokenAppId;
    /** 是创建的可信积分的 id */
    private String tokenId;
    /** 要查询用户余额的用户所在的 appId */
    private String userAppId;
    /** 是该用户在所属的 appId 中的 id（即开发者在自己业务系统中的用户 id；该 id 无需事先在宇链云上注册或使用过）；*/
    private String userId;
    /** 为本二维码可扣款的最大金额。超过该金额，则扣款将一定失败。 */
    private String maxAmount;
    /** 当前付款码链上id，纯随机的32位数字和字母，对同一笔支付应该是不变的 */
    private String uuid;

    public CreateEveriPayParam() {
    }

    public CreateEveriPayParam(String tokenAppId, String tokenId, String userAppId, String userId, String maxAmount, String uuid) {
        this.tokenAppId = tokenAppId;
        this.tokenId = tokenId;
        this.userAppId = userAppId;
        this.userId = userId;
        this.maxAmount = maxAmount;
        this.uuid = uuid;
    }

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

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
