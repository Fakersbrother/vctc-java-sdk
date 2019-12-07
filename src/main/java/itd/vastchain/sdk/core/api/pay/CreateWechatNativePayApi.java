package itd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.WechatPayDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.param.WechatNativePayParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateWechatPayNativeApi
 * 创建微信扫码支付参数
 * 通过这个 API 可以获取到所有进行支付时所需要的参数，可以直接用返回值来发起微信支付。不需要再调用微信的统一下单接口。
 *
 */
public class CreateWechatNativePayApi extends AbstractVctcApi {

    private final String path = "/submerchant-pay/wechatPayNative/";

    public CreateWechatNativePayApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        WechatNativePayParam param = (WechatNativePayParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prepayId", param.getPrepayId());

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
