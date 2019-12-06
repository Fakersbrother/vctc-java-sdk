package itd.vastchain.sdk.param;

public class VctcApiAppIdCredentialParam extends VctcApiCredentialParam {

    public VctcApiAppIdCredentialParam(String appId, String appSecret, String hostUrl) {
        super(appId, appSecret, hostUrl);
    }

    public VctcApiAppIdCredentialParam(String appId, String appSecret, String hostUrl, Integer timeout) {
        super(appId, appSecret, hostUrl, timeout);
    }
}
