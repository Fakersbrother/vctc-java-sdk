package ltd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.WechatPayDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.param.WechatPayParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateWechatPayApi
 * 创建微信小程序支付参数
 *
 */
public class CreateWechatPayApi extends AbstractVctcApi {

    private final String path = "/submerchant-pay/wechatPay/";

    public CreateWechatPayApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        WechatPayParam param = (WechatPayParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prepayId", param.getPrepayId());
        jsonObject.put("openId", param.getOpenId());

        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected WechatPayDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, WechatPayDTO.class);
    }
}
