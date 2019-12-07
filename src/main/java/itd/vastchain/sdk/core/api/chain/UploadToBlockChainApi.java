package itd.vastchain.sdk.core.api.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.FetchOnChainIdsDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.UploadToBlockChainParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * UploadToBlockChainApi
 * 批量上链接口
 * 单个或批量提交一批信息到区块链上，支持明文和加密数据。
 */
public class UploadToBlockChainApi extends AbstractVctcApi {

    private final String path = "/common-chain-upload/";

    public UploadToBlockChainApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        UploadToBlockChainParam param = (UploadToBlockChainParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", param.getItems());

        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected FetchOnChainIdsDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, FetchOnChainIdsDTO.class);
    }
}
