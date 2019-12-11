package ltd.vastchain.sdk.core.api.merchant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.DataIdDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.enums.MerchantTypeEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.CreateMerchantParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateMerchantApi
 * 创建商户
 * 该接口同时适用于子商户和父商户。
 *
 * 宇链云上的商户分为父商户和子商户两层。实际业务逻辑都发生在子商户，父商户主要用于统一收银、统一查询、统一设置参数等。任何一个子商户都要归属于一个父商户，即使只有一个子商户，也要创建一个对应的父商户，再创建子商户。
 */
public class CreateMerchantApi extends AbstractVctcApi {

    private final String path = "/merchant/";

    public CreateMerchantApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        CreateMerchantParam param = (CreateMerchantParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", param.getType().getCode());

        JSONObject parameters = new JSONObject();
        parameters.put("displayName", param.getDisplayName());
        parameters.put("pw", param.getPw());
        parameters.put("disabled", param.getDisabled());
        parameters.put("appId", param.getAppId());
        if (MerchantTypeEnum.SUB_MERCHANT == param.getType()) {
            parameters.put("parentMerchantId", param.getParentMerchantId());
        }
        jsonObject.put("parameters", parameters);

        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected DataIdDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, DataIdDTO.class);
    }
}
