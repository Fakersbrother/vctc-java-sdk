package itd.vastchain.sdk.core.api.donation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.FetchDonateOnChainIdsDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.FetchDonateOnChainIdsParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

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
        jsonObject.put("type", param.getType());
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
