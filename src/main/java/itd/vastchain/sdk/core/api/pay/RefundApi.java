package itd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.VctcApiResponseDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.RefundParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * RefundApi
 * 退款接口
 *
 */
public class RefundApi extends AbstractVctcApi {

    private final String path = "/submerchant-pay/refund/";

    public RefundApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        RefundParam param = (RefundParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());

        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected VctcApiResponseDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, VctcApiResponseDTO.class);
    }
}
