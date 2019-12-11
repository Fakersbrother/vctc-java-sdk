package ltd.vastchain.sdk.core.api.donation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.FetchDonateOnChainIdsDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.FetchDonateOnChainIdsParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * FetchDonateOnChainIdsApi
 * 获取捐款上链 ID
 *
 */
public class FetchDonateOnChainIdsApi extends AbstractVctcApi {

    private final String path = "/donation/fetchOnChainIds/";

    public FetchDonateOnChainIdsApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        FetchDonateOnChainIdsParam param = (FetchDonateOnChainIdsParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", param.getType().getCode());
        jsonObject.put("originalIds", param.getOriginalIds());
        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected FetchDonateOnChainIdsDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, FetchDonateOnChainIdsDTO.class);
    }
}
