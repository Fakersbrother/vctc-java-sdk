package itd.vastchain.sdk.param;

public class VctcApiParam<T> {

    /**
     * 业务接口参数
     */
    private T buinessApiParam;

    /**
     * api请求参数
     */
    private VctcApiCredentialParam credentialParam;

    public VctcApiParam(T buinessApiParam, VctcApiCredentialParam credentialParam) {
        this.buinessApiParam = buinessApiParam;
        this.credentialParam = credentialParam;
    }

    public T getBuinessApiParam() {
        return buinessApiParam;
    }

    public void setBuinessApiParam(T buinessApiParam) {
        this.buinessApiParam = buinessApiParam;
    }

    public VctcApiCredentialParam getCredentialParam() {
        return credentialParam;
    }

    public void setCredentialParam(VctcApiCredentialParam credentialParam) {
        this.credentialParam = credentialParam;
    }
}
