package itd.vastchain.sdk.core.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.SendSmsDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.SendSmsParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * SendSmsApi
 * POST https://v1.api.tc.vastchain.ltd/sms/verificationCode
 */
public class SendSmsApi extends AbstractVctcApi {

    public SendSmsApi(VctcApiParam param) {
        super(param);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        SendSmsParam param = (SendSmsParam)apiParam.getBuinessApiParam();
        // 目前只支持同时发送 1 条短信
        JSONObject itemJson = new JSONObject();
        // 国内短信：11位手机号码，例如15951955195; 国际/港澳台消息：国际区号+号码，例如85200000000
        itemJson.put("phoneNumbers", param.getPhoneNumbers());
        // 验证码类型，目前只支持整数
        itemJson.put("codeType", param.getCodeType().getCode());
        // 短信验证码
        itemJson.put("code", param.getCode());
        JSONArray items = new JSONArray();
        items.add(itemJson);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", items);
        String body = jsonObject.toJSONString();

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath("/sms/verificationCode/");
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected SendSmsDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, SendSmsDTO.class);
    }
}
