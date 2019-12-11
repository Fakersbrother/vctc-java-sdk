package ltd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.VctcApiResponseDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.enums.PayChannelEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.MerchantPayParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

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
        jsonObject.put("paymentChannel", param.getPaymentChannel().getCode());

        JSONObject parameters = new JSONObject();
        parameters.put("notifyCallbackUrl", param.getNotifyCallbackUrl());
        if (PayChannelEnum.WECHAT_UNIONPAYBIZSMALL == param.getPaymentChannel()) {
            parameters.put("unionPayBizMchId", param.getUnionPayBizMchId());
            parameters.put("terminalId", param.getTerminalId());
        } else if (PayChannelEnum.WECHAT_NATIVE == param.getPaymentChannel()) {
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
