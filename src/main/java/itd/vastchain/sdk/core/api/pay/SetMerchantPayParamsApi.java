package itd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.VctcApiResponseDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.MerchantPayParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * SetMerchantPayParamsApi
 * 设置商户支付参数
 *
 */
public class SetMerchantPayParamsApi extends AbstractVctcApi {

    private final String path = "/merchant/paymentParams/";

    public SetMerchantPayParamsApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        MerchantPayParam param = (MerchantPayParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());
        jsonObject.put("paymentChannel", param.getPaymentChannel());

        JSONObject parameters = new JSONObject();
        parameters.put("notifyCallbackUrl", param.getNotifyCallbackUrl());
        if ("WechatUnionPayBizSmall".equals(param.getPaymentChannel())) {
            parameters.put("unionPayBizMchId", param.getUnionPayBizMchId());
            parameters.put("terminalId", param.getTerminalId());
        } else if ("WechatNative".equals(param.getPaymentChannel())) {
            parameters.put("profitSharing", param.getProfitSharing());
            parameters.put("wechatAppId", param.getWechatAppId());
            parameters.put("wechatMchId", param.getWechatMchId());
        }

        jsonObject.put("parameters", parameters);

        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.PUT.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected VctcApiResponseDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).put(context.getBody());
        return JSON.parseObject(result, VctcApiResponseDTO.class);
    }
}
