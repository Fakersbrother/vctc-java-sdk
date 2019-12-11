package ltd.vastchain.sdk.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.VctcApiClient;
import ltd.vastchain.sdk.dto.*;
import ltd.vastchain.sdk.enums.*;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.*;

import java.util.ArrayList;
import java.util.List;

public class ApiExample {
    /**
     * AppID，默认为测试账号；在非生产环境严禁使用正式账号，否则会导致
     * 测试数据上传到区块链主网；请反复测试无误后再在正式环境中切换
     */
    private static final String APPID = "AzE5";
    /**
     * 【警告】
     * AppSecret 是绝密资料，为了安全，像下面这样直接写在程序中是不对的。
     * 1. 禁止写在程序中
     * 2. 禁止写在 Git / SVN 仓库
     * 3. 应存储在普通程序员和无关人员无法访问到的安全加固的隔离机器上
     * 4. 对于涉及金融资产、代币等需要额外安全性的情况，建议将本类放
     * 在一个和大多数无关人员物理/网络隔离的机器上，把本类的签名方法
     * 作为一个服务，通过 HTTP 接口对其他程序提供签名服务，但不对任
     * 何人公开 AppSecret。
     * 5. 泄露 AppSecret 可能会导致无关人员伪造数据并上传至区块链上。
     * 6. 请不要删除这段警告，以方便其他工程师了解。
     * <p>
     * =========================================================
     * 杭州宇链科技有限公司
     */
    private static final String APPSECRET = "u4VcwCrZ0tD$ozhE";
    private static final String HOST_URL = "https://v1.api.tc.vastchain.ltd";

    public static void main(String[] args) throws VctcException {
//        sendSms();
//        loginMerchant();
//        createMerchant();
//        createDonationProject();
//        donateDonation();
//        fetchDonateOnChainIds();
//        queryFungibleBalance();
//        createEveriPay();
//        createMerchantPrePay();
//        getSubMerchantPayInfo();
//        createWechatNativePay();
//        createWechatPay();
//        createWechatAppPay();
//        refund();
//        setMerchantPayParams();
//        fetchOnChainIds();
//        uploadToBlockChain();
    }

    public static void sendSms() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        SendSmsParam param = new SendSmsParam();
        param.setCode("1234");
        param.setCodeType(CodeTypeEnum.INTEGER);
        param.setPhoneNumbers("13918130040");
        DataIdDTO result = client.sendSms(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void loginMerchant() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        LoginMerchantParam param = new LoginMerchantParam("PM8687779009", "xxx");

        LoginMerchantDTO result = client.loginMerchant(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createMerchant() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateMerchantParam param = new CreateMerchantParam(MerchantTypeEnum.MERCHANT, "Test", "123456", "xxx", null, false);

        DataIdDTO result = client.createMerchant(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createDonationProject() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateDonationProjectParam param = new CreateDonationProjectParam("1", System.currentTimeMillis(), "关爱重症儿童，助力象山小荣荣", "今天我们隆重推出新项目：关爱重症儿童。这个项目是由慈善基金会发起的，可信度很高", "XX省慈善基金会", new String[]{"基金会"}, new String[]{"助学"}, new String[]{"30000.00 RMB"});

        VctcApiResponseDTO result = client.createDonationProject(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void donateDonation() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        DonateDonationParam param = new DonateDonationParam("1", "1", "1", "威少", System.currentTimeMillis(), "d6bc8b1b17ff4861aca578e97673b981", "7673b98_d6bc8b1b17ff", "300000 RMB");

        VctcApiResponseDTO result = client.donateDonation(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void fetchDonateOnChainIds() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        FetchDonateOnChainIdsParam param = new FetchDonateOnChainIdsParam(DonationTypeEnum.DONATE, new String[]{"d6bc8b1b17ff4861aca578e97673b981"});

        FetchDonateOnChainIdsDTO result = client.fetchDonateOnChainIds(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void queryFungibleBalance() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        QueryFungibleBalanceParam param = new QueryFungibleBalanceParam("9zdo", "fungible-test", "9zdo", "user1");

        QueryFungibleBalanceDTO result = client.queryFungibleBalance(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createEveriPay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateEveriPayParam param = new CreateEveriPayParam("9zdo", "fungible-test", "9zdo", "user1", "200", "a7ab5a851cf38626201b884b332d16db");

        CreateEveriPayDTO result = client.createEveriPay(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createMerchantPrePay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateMerchantPrePayParam param = new CreateMerchantPrePayParam("1001", "100");

        CreateMerchantPrePayDTO result = client.createMerchantPrePay(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void getSubMerchantPayInfo() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        SubMerchantPayInfoParam param = new SubMerchantPayInfoParam("SMFP10293485763", "0");

        SubMerchantPayInfoDTO result = client.getSubMerchantPayInfo(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createWechatNativePay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        WechatNativePayParam param = new WechatNativePayParam("SMFP10293485763");

        WechatPayDTO result = client.createWechatNativePay(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createWechatPay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        WechatPayParam param = new WechatPayParam("SMFP10293485763", "sadfasfasfasdf");

        WechatPayDTO result = client.createWechatPay(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void createWechatAppPay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        WechatAppPayParam param = new WechatAppPayParam("SMFP10293485763", true);

        WechatPayDTO result = client.createWechatAppPay(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void refund() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        RefundParam param = new RefundParam("SMFP10293485763");

        VctcApiResponseDTO result = client.refund(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void setMerchantPayParams() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        MerchantPayParam param = new MerchantPayParam("SM0105000000", PayChannelEnum.WECHAT_UNIONPAYBIZSMALL, "898991870111287", "00000001", "https://v1.ruida-pay.api.vastchain.ltd/unionpay/vastchain/wechatPayBack");
        VctcApiResponseDTO result = client.setMerchantPayParams(param);
        System.out.println(JSON.toJSONString(result));

        param = new MerchantPayParam("SM0105000000", PayChannelEnum.WECHAT_NATIVE, "https://v1.ruida-pay.api.vastchain.ltd/unionpay/vastchain/wechatPayBack", true, "1", "1");
        result = client.setMerchantPayParams(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void fetchOnChainIds() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        List<FetchOnChainIdsItemsParam> items = new ArrayList<>();
        FetchOnChainIdsItemsParam item = new FetchOnChainIdsItemsParam(UploadChainTypeEnum.DATA_BUCKET_REGISTER, "doortest3d6", QueryChainTypeEnum.I2C);
        items.add(item);
        FetchOnChainIdsParam param = new FetchOnChainIdsParam(items);

        FetchOnChainIdsDTO result = client.fetchOnChainIds(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void uploadToBlockChain() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        List<UploadToBlockChainItemsParam> items = new ArrayList<>();
        UploadToBlockChainItemsParam item = new UploadToBlockChainItemsParam(UploadChainTypeEnum.EVERIPAY);
        JSONObject args = new JSONObject();
        args.put("id", "jV3oisdj489vsdlkj");
        args.put("evtLink", "0DFYxxx");
        args.put("amount", "39.28");
        item.setItems(args);
        items.add(item);
        UploadToBlockChainParam param = new UploadToBlockChainParam(items);

        VctcApiResponseDTO result = client.uploadToBlockChain(param);
        System.out.println(JSON.toJSONString(result));
    }

}
