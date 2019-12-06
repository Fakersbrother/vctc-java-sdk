package itd.vastchain.sdk;


import itd.vastchain.sdk.core.api.LoginMerchantApi;
import itd.vastchain.sdk.core.api.SendSmsApi;
import itd.vastchain.sdk.dto.LoginMerchantDTO;
import itd.vastchain.sdk.dto.SendSmsDTO;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.LoginMerchantParam;
import itd.vastchain.sdk.param.SendSmsParam;
import itd.vastchain.sdk.param.VctcApiCredentialParam;
import itd.vastchain.sdk.param.VctcApiParam;

/**
 * 宇链云API
 */
public class VctcApiClient {

    private VctcApiCredentialParam credentialParam;

    public VctcApiClient(VctcApiCredentialParam credentialParam) {
        this.credentialParam = credentialParam;
    }

    /**
     * 发送短信验证码
     *
     * @param param
     * @return
     * @throws VctcException
     */
    public SendSmsDTO sendSms(SendSmsParam param) throws VctcException {
        VctcApiParam apiParam = new VctcApiParam<>(param, credentialParam);
        return new SendSmsApi(apiParam).request();
    }

    /**
     * 商户登录
     *
     * @param param
     * @return
     * @throws VctcException
     */
    public LoginMerchantDTO loginMerchant(LoginMerchantParam param) throws VctcException{
        VctcApiParam apiParam = new VctcApiParam<>(param, credentialParam);
        return new LoginMerchantApi(apiParam).request();
    }
//    /**
//     * 创建商户
//     *
//     * @param param
//     * @return
//     * @throws VctcException
//     */
//    VctcApiResponseDTO createMerchant(CreateMerchantParam param) throws VctcException;
//
//    /**
//     * 创建捐款项目
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO createDonationProject(CreateDonationProjectParam param) throws VctcClientException;
//
//    /**
//     * 创建捐款项目的一次捐赠
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO donateDonation(DonateDonationParam param) throws VctcClientException;
//
//    /**
//     * 获取捐款上链 ID
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    FetchDonateOnChainIdsDTO fetchDonateOnChainIds(FetchDonateOnChainIdsParam param) throws VctcClientException;
//
//    /**
//     * 查询可信积分余额
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO queryFungibleBalance(QueryFungibleBalanceParam param) throws VctcClientException;
//
//    /**
//     * 生成可信积分扣款二维码（everiPay）
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO createEveriPay(CreateEveriPayParam param) throws VctcClientException;
//
//    /**
//     * 创建预支付单
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    CreateSubmerchantPayDTO createSubMerchantPay(CreateSubMerchantPayParam param) throws VctcClientException;
//
//    /**
//     * 获取子商户支付详情
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    SubMerchantPayInfoDTO getSubMerchantPayInfo(SubMerchantPayInfoParam param) throws VctcClientException;
//
//    /**
//     * 创建微信扫码支付参数
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    WechatPayDTO createWechatPayNative(WechatPayNativeParam param) throws VctcClientException;
//
//    /**
//     * 创建微信小程序支付参数
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    WechatPayDTO createWechatPay(WechatPayParam param) throws VctcClientException;
//
//    /**
//     * 创建微信 App 支付参数
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    WechatPayDTO createWechatPayApp(WechatPayAppParam param) throws VctcClientException;
//
//    /**
//     * 退款接口
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO refund(RefundParam param) throws VctcClientException;
//
//    /**
//     * 设置商户支付参数
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO setMerchantPayParams(MerchantPayParam param) throws VctcClientException;
//
//    /**
//     * 获取链上 ID 接口
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    FetchOnChainIdsDTO fetchOnChainIds(FetchOnChainIdsParam param) throws VctcClientException;
//
//    /**
//     * 批量上链接口
//     *
//     * @param param
//     * @return
//     * @throws VctcClientException
//     */
//    VctcApiResponseDTO uploadToBlockChain(UploadToBlockChainParam param) throws VctcClientException;
}
