package ltd.vastchain.sdk.core.api.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.FetchOnChainIdsDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.FetchOnChainIdsParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * FetchOnChainIdsApi
 * 获取链上 ID 接口
 * 此接口用来通过同步的方式查询上链结果，包括链上 ID（OnChainId）、区块 ID（Block Num）、事务 ID（Transaction Id），用来获知上链的最终确认状态。
 *
 * 不同的上链动作（action），在得到上链 ID 之前所需要等待的时延是不同的。对于 everiPay 和 everiPass 动作，一般只需 1 秒即可完成。一些请求可能要在上链 3 - 4 分钟之后才可以获得链上 ID。
 */
public class FetchOnChainIdsApi extends AbstractVctcApi {

    private final String path = "/common-chain-upload/fetchOnChainIds/";

    public FetchOnChainIdsApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        FetchOnChainIdsParam param = (FetchOnChainIdsParam)apiParam.getBuinessApiParam();
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
