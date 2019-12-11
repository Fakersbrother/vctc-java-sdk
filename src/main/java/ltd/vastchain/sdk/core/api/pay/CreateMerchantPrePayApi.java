package ltd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.CreateMerchantPrePayDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.CreateMerchantPrePayParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateMerchantPrePayApi
 * 创建预支付单
 * 创建各类预支付单。若不提供相应参数，默认的支付方式为微信支付。
 *
 * 支持 POS 机支付、扫码支付、App 支付、JSSDK 支付、小程序支付等各类支付方式。
 *
 * 支持两个层级的商户，但支付只和第二层（子商户）直接相关。
 *
 */
public class CreateMerchantPrePayApi extends AbstractVctcApi {

    private final String path = "/submerchant-pay/wechatPayNative/";

    public CreateMerchantPrePayApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        CreateMerchantPrePayParam param = (CreateMerchantPrePayParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("subMerchantId", param.getSubMerchantId());
        jsonObject.put("totalAmount", param.getTotalAmount());
        jsonObject.put("orderId", param.getOrderId());
        jsonObject.put("extraInfo", param.getExtraInfo());

        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected CreateMerchantPrePayDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, CreateMerchantPrePayDTO.class);
    }
}
