package itd.vastchain.sdk.param;

public abstract class VctcApiCredentialParam {
    /** appId */
    private String appId;
    /** appSecret */
    private String appSecret;
    /** 访问域名 */
    private String hostUrl;
    /** 接口超时时间 */
    private Integer timeout;

    public VctcApiCredentialParam(String appId, String appSecret, String hostUrl) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.hostUrl = hostUrl;
    }

    public VctcApiCredentialParam(String appId, String appSecret, String hostUrl, Integer timeout) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.hostUrl = hostUrl;
        this.timeout = timeout;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getHostUrl() {
        return hostUrl;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
