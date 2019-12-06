package itd.vastchain.sdk.core;

import itd.vastchain.sdk.param.VctcApiCredentialParam;

/**
 * 宇链云接口请求上下文
 */
public class VctcApiContext {

    /** 宇链api请求参数 */
    private VctcApiCredentialParam credentialParam;
    /** 接口路径 以“/”开头 */
    private String path;
    /** get请求参数 如 _appid=AzE5&_t=32093029 */
    private String query;
    /** post请求参数 */
    private String body;
    /** 请求类型 */
    private String httpMethod;
    /** 完整API请求ur */
    private String fullApiurl;


    public VctcApiContext() {
    }

    public VctcApiContext(VctcApiCredentialParam credentialParam, String path, String query, String httpMethod) {
        this.credentialParam = credentialParam;
        this.path = path;
        this.query = query;
        this.httpMethod = httpMethod;
    }

    public VctcApiContext(VctcApiCredentialParam credentialParam, String path, String query, String body, String httpMethod) {
        this.credentialParam = credentialParam;
        this.path = path;
        this.query = query;
        this.body = body;
        this.httpMethod = httpMethod;
    }

    public VctcApiCredentialParam getCredentialParam() {
        return credentialParam;
    }

    public void setCredentialParam(VctcApiCredentialParam credentialParam) {
        this.credentialParam = credentialParam;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getFullApiurl() {
        return fullApiurl;
    }

    public void setFullApiurl(String fullApiurl) {
        this.fullApiurl = fullApiurl;
    }
}
