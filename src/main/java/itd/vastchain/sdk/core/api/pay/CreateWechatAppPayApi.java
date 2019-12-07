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
import itd.vastchain.sdk.param.WechatAppPayParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateWechatAppPayApi
 * 创建微信 App 支付参数
 *
 */
public class CreateWechatAppPayApi extends AbstractVctcApi {

    private final String path = "/submerchant-pay/wechatPayApp/";

    public CreateWechatAppPayApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        WechatAppPayParam param = (WechatAppPayParam)apiParam.getBuinessApiParam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prepayId", param.getPrepayId());
        jsonObject.put("enableProfitSharing", param.getEnableProfitSharing());

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
