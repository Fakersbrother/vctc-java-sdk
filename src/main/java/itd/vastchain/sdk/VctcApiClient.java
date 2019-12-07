package itd.vastchain.sdk;


import itd.vastchain.sdk.core.api.chain.FetchOnChainIdsApi;
import itd.vastchain.sdk.core.api.chain.UploadToBlockChainApi;
import itd.vastchain.sdk.core.api.donation.CreateDonationProjectApi;
import itd.vastchain.sdk.core.api.donation.DonateDonationtApi;
import itd.vastchain.sdk.core.api.donation.FetchDonateOnChainIdsApi;
import itd.vastchain.sdk.core.api.fungible.CreateEveriPayApi;
import itd.vastchain.sdk.core.api.merchant.CreateMerchantApi;
import itd.vastchain.sdk.core.api.merchant.LoginMerchantApi;
import itd.vastchain.sdk.core.api.pay.*;
import itd.vastchain.sdk.core.api.sms.SendSmsApi;
import itd.vastchain.sdk.dto.*;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.*;

/**
 * VctcApiClient
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
    public DataIdDTO sendSms(SendSmsParam param) throws VctcException {
        return new SendSmsApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 商户登录
     *
     * @param param
     * @return
     * @throws VctcException
     */
    public LoginMerchantDTO loginMerchant(LoginMerchantParam param) throws VctcException {
        return new LoginMerchantApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建商户
     *
     * @param param
     * @return
     * @throws VctcException
     */
    DataIdDTO createMerchant(CreateMerchantParam param) throws VctcException {
        return new CreateMerchantApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建捐款项目
     *
     * @param param
     * @return
     * @throws VctcException
     */
    VctcApiResponseDTO createDonationProject(CreateDonationProjectParam param) throws VctcException {
        return new CreateDonationProjectApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建捐款项目的一次捐赠
     *
     * @param param
     * @return
     * @throws VctcException
     */
    VctcApiResponseDTO donateDonation(DonateDonationParam param) throws VctcException {
        return new DonateDonationtApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 获取捐款上链 ID
     *
     * @param param
     * @return
     * @throws VctcException
     */
    FetchDonateOnChainIdsDTO fetchDonateOnChainIds(FetchDonateOnChainIdsParam param) throws VctcException {
        return new FetchDonateOnChainIdsApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 查询可信积分余额
     *
     * @param param
     * @return
     * @throws VctcException
     */
    QueryFungibleBalanceDTO queryFungibleBalance(QueryFungibleBalanceParam param) throws VctcException {
        return new FetchDonateOnChainIdsApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 生成可信积分扣款二维码（everiPay）
     *
     * @param param
     * @return
     * @throws VctcException
     */
    CreateEveriPayDTO createEveriPay(CreateEveriPayParam param) throws VctcException {
        return new CreateEveriPayApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建预支付单
     *
     * @param param
     * @return
     * @throws VctcException
     */
    CreateMerchantPrePayDTO createMerchantPrePay(CreateMerchantPrePayParam param) throws VctcException {
        return new CreateMerchantPrePayApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 获取子商户支付详情
     *
     * @param param
     * @return
     * @throws VctcException
     */
    SubMerchantPayInfoDTO getSubMerchantPayInfo(SubMerchantPayInfoParam param) throws VctcException {
        return new GetSubMerchantPayInfoApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建微信扫码支付参数
     *
     * @param param
     * @return
     * @throws VctcException
     */
    WechatPayDTO createWechatNativePay(WechatNativePayParam param) throws VctcException {
        return new CreateWechatNativePayApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建微信小程序支付参数
     *
     * @param param
     * @return
     * @throws VctcException
     */
    WechatPayDTO createWechatPay(WechatPayParam param) throws VctcException {
        return new CreateWechatPayApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 创建微信 App 支付参数
     *
     * @param param
     * @return
     * @throws VctcException
     */
    WechatPayDTO createWechatAppPay(WechatAppPayParam param) throws VctcException {
        return new CreateWechatAppPayApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 退款接口
     *
     * @param param
     * @return
     * @throws VctcException
     */
    VctcApiResponseDTO refund(RefundParam param) throws VctcException {
        return new RefundApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 设置商户支付参数
     *
     * @param param
     * @return
     * @throws VctcException
     */
    VctcApiResponseDTO setMerchantPayParams(MerchantPayParam param) throws VctcException {
        return new SetMerchantPayParamsApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 获取链上 ID 接口
     *
     * @param param
     * @return
     * @throws VctcException
     */
    FetchOnChainIdsDTO fetchOnChainIds(FetchOnChainIdsParam param) throws VctcException {
        return new FetchOnChainIdsApi(new VctcApiParam(param, credentialParam)).request();
    }

    /**
     * 批量上链接口
     *
     * @param param
     * @return
     * @throws VctcException
     */
    VctcApiResponseDTO uploadToBlockChain(UploadToBlockChainParam param) throws VctcException {
        return new UploadToBlockChainApi(new VctcApiParam(param, credentialParam)).request();
    }
}
