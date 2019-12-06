package itd.vastchain.sdk.example;

import com.alibaba.fastjson.JSON;
import itd.vastchain.sdk.VctcApiClient;
import itd.vastchain.sdk.dto.LoginMerchantDTO;
import itd.vastchain.sdk.dto.SendSmsDTO;
import itd.vastchain.sdk.enums.CodeTypeEnum;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.LoginMerchantParam;
import itd.vastchain.sdk.param.SendSmsParam;
import itd.vastchain.sdk.param.VctcApiAppIdCredentialParam;
import itd.vastchain.sdk.param.VctcApiCredentialParam;

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
     *    在一个和大多数无关人员物理/网络隔离的机器上，把本类的签名方法
     *    作为一个服务，通过 HTTP 接口对其他程序提供签名服务，但不对任
     *    何人公开 AppSecret。
     * 5. 泄露 AppSecret 可能会导致无关人员伪造数据并上传至区块链上。
     * 6. 请不要删除这段警告，以方便其他工程师了解。
     *
     * =========================================================
     *                                    杭州宇链科技有限公司
     */
    private static final String APPSECRET = "u4VcwCrZ0tD$ozhE";
    private static final String HOST_URL = "https://v1.api.tc.vastchain.ltd";

    public static void main(String[] args) throws VctcException {
//        sendSms();
        loginMerchant();
    }

    public static void sendSms() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID,APPSECRET,HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        SendSmsParam param = new SendSmsParam();
        param.setCode("1234");
        param.setCodeType(CodeTypeEnum.INTEGER);
        param.setPhoneNumbers("13918130040");
        SendSmsDTO result = client.sendSms(param);
        System.out.println(JSON.toJSONString(result));
    }

    public static void loginMerchant() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID,APPSECRET,HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        LoginMerchantParam param = new LoginMerchantParam("xx","xx");

        LoginMerchantDTO result = client.loginMerchant(param);
        System.out.println(JSON.toJSONString(result));
    }

}
