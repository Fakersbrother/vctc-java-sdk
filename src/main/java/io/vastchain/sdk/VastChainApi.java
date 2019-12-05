package io.vastchain.sdk;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.vastchain.sdk.dto.*;
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

    private static void valid(VastChainRequestParam param) throws ApiResponseException {
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
    public static VastChainResponseDTO sendSms(SendSmsParam param) throws ApiResponseException {
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
        return JSON.parseObject(result, VastChainResponseDTO.class);
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
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO createMerchant(CreateMerchantParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/merchant/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", param.getType());

        JSONObject parameters = new JSONObject();
        parameters.put("displayName", param.getDisplayName());
        parameters.put("pw", param.getPw());
        parameters.put("disabled", param.getDisabled());
        parameters.put("appId", param.getAppId());
        if("subMerchant".equals(param.getType())) {
            parameters.put("parentMerchantId", param.getParentMerchantId());
        }
        jsonObject.put("parameters", parameters);
        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 创建捐款项目
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO createDonationProject(CreateDonationProjectParam param) throws ApiResponseException {
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
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 创建捐款项目的一次捐赠
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO donateDonation(DonateDonationParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/donation/donate/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());
        jsonObject.put("createTime", param.getCreateTime());
        jsonObject.put("donatorId", param.getDonatorId());
        jsonObject.put("donatorPublicKey", param.getDonatorPublicKey());
        jsonObject.put("donatorName", param.getDonatorName());
        jsonObject.put("projectId_biz", param.getProjectIdBiz());
        jsonObject.put("projectId_bc", param.getProjectIdBc());
        jsonObject.put("amount", param.getAmount());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 获取捐款上链 ID
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static FetchDonateOnChainIdsDTO fetchDonateOnChainIds(FetchDonateOnChainIdsParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/donation/fetchOnChainIds/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", param.getType());
        jsonObject.put("originalIds", param.getOriginalIds());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, FetchDonateOnChainIdsDTO.class);
    }

    /**
     * 查询可信积分余额
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO queryFungibleBalance(QueryFungibleBalanceParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/fungible-token/balance/");
        StringBuffer query = new StringBuffer("");
        query.append("tokenAppId=").append(param.getTokenAppId());
        query.append("&tokenId=").append(param.getTokenId());
        query.append("&userAppId=").append(param.getUserAppId());
        query.append("&userId=").append(param.getUserId());
        param.setQuery(query.toString());

        String url = Signature.sign(param, HTTP_METHOD_GET, null);
        String result = new OkhttpApi(url, param.getTimeout()).get();
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 生成可信积分扣款二维码（everiPay）
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO createEveriPay(CreateEveriPayParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/fungible-token/everiPay/");
        StringBuffer query = new StringBuffer("");
        query.append("tokenAppId=").append(param.getTokenAppId());
        query.append("&tokenId=").append(param.getTokenId());
        query.append("&userAppId=").append(param.getUserAppId());
        query.append("&userId=").append(param.getUserId());
        query.append("&maxAmount=").append(param.getMaxAmount());
        query.append("&uuid=").append(param.getUuid());
        param.setQuery(query.toString());

        String url = Signature.sign(param, HTTP_METHOD_GET, null);
        String result = new OkhttpApi(url, param.getTimeout()).get();
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 创建预支付单
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static SubmerchantPayDTO submerchantPay(SubmerchantPayParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/submerchant-pay/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("subMerchantId", param.getSubMerchantId());
        jsonObject.put("totalAmount", param.getTotalAmount());
        jsonObject.put("orderId", param.getOrderId());
        jsonObject.put("extraInfo", param.getExtraInfo());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, SubmerchantPayDTO.class);
    }

    /**
     * 获取子商户支付详情
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static SubMerchantPayInfoDTO getSubMerchantPayInfo(SubMerchantPayInfoParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/submerchant-pay/prePay/"+param.getPrepayid());
        StringBuffer query = new StringBuffer("");
        query.append("waitForFinish=").append(param.getWaitForFinish());
        param.setQuery(query.toString());

        String url = Signature.sign(param, HTTP_METHOD_GET, null);
        String result = new OkhttpApi(url, param.getTimeout()).get();
        return JSON.parseObject(result, SubMerchantPayInfoDTO.class);
    }

    /**
     * 创建微信扫码支付参数
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static WechatPayDTO wechatPayNative(WechatPayNativeParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/submerchant-pay/wechatPayNative/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prepayId", param.getPrepayId());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, WechatPayDTO.class);
    }

    /**
     * 创建微信小程序支付参数
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static WechatPayDTO wechatPay(WechatPayParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/submerchant-pay/wechatPay/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prepayId", param.getPrepayId());
        jsonObject.put("openId", param.getOpenId());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, WechatPayDTO.class);
    }

    /**
     * 创建微信 App 支付参数
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static WechatPayDTO wechatPayApp(WechatPayAppParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/submerchant-pay/wechatPayApp/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prepayId", param.getPrepayId());
        jsonObject.put("enableProfitSharing", param.getEnableProfitSharing());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, WechatPayDTO.class);
    }

    /**
     * 退款接口
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO refund(RefundParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/submerchant-pay/refund/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 设置商户支付参数
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO setMerchantPayParams(MerchantPayParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/merchant/paymentParams/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", param.getId());
        jsonObject.put("paymentChannel", param.getPaymentChannel());

        JSONObject parameters = new JSONObject();
        parameters.put("notifyCallbackUrl", param.getNotifyCallbackUrl());
        if("WechatUnionPayBizSmall".equals(param.getPaymentChannel())){
            parameters.put("unionPayBizMchId", param.getUnionPayBizMchId());
            parameters.put("terminalId", param.getTerminalId());
        }else  if("WechatNative".equals(param.getPaymentChannel())){
            parameters.put("profitSharing", param.getProfitSharing());
            parameters.put("wechatAppId", param.getWechatAppId());
            parameters.put("wechatMchId", param.getWechatMchId());
        }

        jsonObject.put("parameters",parameters);

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }

    /**
     * 获取链上 ID 接口
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static FetchOnChainIdsDTO fetchOnChainIds(FetchOnChainIdsParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/common-chain-upload/fetchOnChainIds/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", param.getItems());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, FetchOnChainIdsDTO.class);
    }

    /**
     * 批量上链接口
     * @param param
     * @return
     * @throws ApiResponseException
     */
    public static VastChainResponseDTO uploadChain(UploadChainParam param) throws ApiResponseException {
        valid(param);
        param.setPath("/common-chain-upload/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", param.getItems());

        String body = jsonObject.toJSONString();
        String url = Signature.sign(param, HTTP_METHOD_POST, body);
        String result = new OkhttpApi(url, param.getTimeout()).post(body);
        return JSON.parseObject(result, VastChainResponseDTO.class);
    }
}
