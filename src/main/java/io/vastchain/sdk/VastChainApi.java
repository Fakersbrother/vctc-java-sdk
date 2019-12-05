package io.vastchain.sdk;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.vastchain.sdk.dto.LoginMerchantDTO;
import io.vastchain.sdk.dto.VastChainDTO;
import io.vastchain.sdk.exception.ApiResponseException;
import io.vastchain.sdk.param.*;
import io.vastchain.sdk.util.OkhttpApi;
import io.vastchain.sdk.util.Signature;

/**
 * 宇链云API
 */
public class VastChainApi {

    private final static String HTTP_METHOD_POST = "POST";
    private final static String HTTP_METHOD_GET = "GET";

    public VastChainApi() {
    }

    private static void valid(ApiRequestParam param) throws ApiResponseException {
        if (param.getAppId() == null || "".equals(param.getAppId())) {
            throw new ApiResponseException("appId is null");
        }
        if (param.getAppSecret() == null || "".equals(param.getAppSecret())) {
            throw new ApiResponseException("appSecret is null");
        }
        if (param.getHostUrl() == null || "".equals(param.getHostUrl())) {
            throw new ApiResponseException("hostUrl is null");
        }
    }

    /**
     * 发送短信验证码
     *
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainDTO sendSms(SendSmsParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/sms/verificationCode/");
        // 目前只支持同时发送 1 条短信
        JSONObject itemJson = new JSONObject();
        // 国内短信：11位手机号码，例如15951955195; 国际/港澳台消息：国际区号+号码，例如85200000000
        itemJson.put("phoneNumbers", param.getPhoneNumbers());
        // 验证码类型，目前只支持整数
        itemJson.put("codeType", param.getCodeType());
        // 短信验证码
        itemJson.put("code", param.getCode());
        JSONArray items = new JSONArray();
        items.add(itemJson);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", items);

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainDTO.class);
    }

    /**
     * 商户登录
     *
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static LoginMerchantDTO loginMerchant(LoginMerchantParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/merchant/login/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", param.getUserId());
        jsonObject.put("pw", param.getPw());
        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, LoginMerchantDTO.class);
    }

    /**
     * 创建商户
     *
     * @param param
     * @param type 创建子商户（subMerchant）还是父商户（merchant)
     * @return
     * @throws ApiResponseException
     */
    public static VastChainDTO createMerchant(CreateMerchantParam param,String type) throws ApiResponseException {
        valid(param);
        param.setPath("/merchant/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type);

        JSONObject parameters = new JSONObject();
        parameters.put("displayName", param.getDisplayName());
        parameters.put("pw", param.getPw());
        parameters.put("disabled", param.getDisabled());
        parameters.put("appId", param.getAppId());
        if("subMerchant".equals(type)) {
            parameters.put("parentMerchantId", param.getParentMerchantId());
        }
        jsonObject.put("parameters", parameters);
        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainDTO.class);
    }

    /**
     * 创建捐款项目
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainDTO createDonationProject(CreateDonationProjectParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/donation/project/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());
        jsonObject.put("createTime", param.getCreateTime());
        jsonObject.put("title", param.getTitle());
        jsonObject.put("desc", param.getDesc());
        jsonObject.put("founder", param.getFounder());
        jsonObject.put("category", param.getCategory());
        jsonObject.put("keyWords", param.getKeyWords());
        jsonObject.put("targetAmount", param.getTargetAmount());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainDTO.class);
    }
    /**
     * 创建捐款项目的一次捐赠
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainDTO donateDonation(CreateDonationProjectParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/donation/donate");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());
        jsonObject.put("createTime", param.getCreateTime());
        jsonObject.put("title", param.getTitle());
        jsonObject.put("desc", param.getDesc());
        jsonObject.put("founder", param.getFounder());
        jsonObject.put("category", param.getCategory());
        jsonObject.put("keyWords", param.getKeyWords());
        jsonObject.put("targetAmount", param.getTargetAmount());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainDTO.class);
    }

}
