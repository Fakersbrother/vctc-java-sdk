package io.vastchain.sdk.param;

public class VastChainRequestParam {
    /** appId */
    private String appId;
    /** appSecret */
    private String appSecret;
    /** 访问域名 */
    private String hostUrl;
    /** 接口路径 以“/”开头 */
    private String path;
    /** get请求参数 如 _appid=AzE5&_t=32093029 */
    private String query;
    /** 接口超时时间 */
    private Integer timeout;


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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
