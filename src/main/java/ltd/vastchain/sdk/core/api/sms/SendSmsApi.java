package ltd.vastchain.sdk.core.api.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.DataIdDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.SendSmsParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * SendSmsApi
 * 发送短信验证码
 */
public class SendSmsApi extends AbstractVctcApi {

    private final String path = "/sms/verificationCode/";

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
