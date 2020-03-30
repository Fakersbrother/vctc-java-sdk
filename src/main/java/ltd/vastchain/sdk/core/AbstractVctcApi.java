package ltd.vastchain.sdk.core;

import ltd.vastchain.sdk.exception.ErrorCode;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.VctcApiCredentialParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.Signature;

import java.util.Date;

public abstract class AbstractVctcApi implements VctcApi {

    protected VctcApiParam apiParam;

    public AbstractVctcApi(VctcApiParam apiParam) {
        this.apiParam = apiParam;
    }

    @Override
    public <T> T request() throws VctcException {
        //1.valid param
        validApiParams();
        //2.build context
        VctcApiContext context = buildContext();
        //3.sign
        sign(context);
        //4.call api
        return callApi(context);
    }

    /**
     * signature,can override
     * @param context
     * @return
     */
    protected String sign(VctcApiContext context) {
        String url = Signature.sign(context,new Date().getTime());
        context.setFullApiurl(url);
        return url;
    }

    /**
     * common api params valid
     * @throws VctcException
     */
    private void validApiParams() throws VctcException {
        VctcApiCredentialParam credentialParam = apiParam.getCredentialParam();
        if (credentialParam == null) {
            throw new VctcClientException(ErrorCode.APIPARAMS_ISNULL);
        }
        if (credentialParam.getAppId() == null || "".equals(credentialParam.getAppId())) {
            throw new VctcClientException(ErrorCode.APP_ID_ISNULL);
        }
        if (credentialParam.getAppSecret() == null || "".equals(credentialParam.getAppSecret())) {
            throw new VctcClientException(ErrorCode.APP_SECRET_ISNULL);
        }
        if (credentialParam.getHostUrl() == null || "".equals(credentialParam.getHostUrl())) {
            throw new VctcClientException(ErrorCode.HOSTURL_ISNULL);
        }
        specialValidate();
    }

    protected abstract VctcApiContext buildContext();

    protected abstract <T> T callApi(VctcApiContext context) throws VctcException;

    /**
     * specialValidate
     * @throws VctcException
     */
    protected abstract void specialValidate() throws VctcClientException;
}
