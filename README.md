# vctc-java-sdk<!-- omit in toc -->

Official Java SDK for VastChain. https://www.vastchain.cn

> This SDK also has an [**example package**](https://github.com/vastchain/vctc-java-sdk/tree/master/src/main/java/ltd/vastchain/sdk/example/) set up, which lists various useful code examples for quick references on how to interact with VastChain.

- [Install](#install)
  - [use with Maven project](#use-with-maven-project)
  - [other](#other)
- [Usage overview](#usage-overview)

## Install

### use with Maven project

In project `pom.xml` file

```xml
<dependencies>
   <dependency>
       <groupId>ltd.vastchain</groupId>
       <artifactId>vctc-java-sdk</artifactId>
       <version>1.0.1</version>
   </dependency>
</dependencies>
```

### other

Build jar with all the dependencies, run the following command

`mvn clean compile assembly:single`

It will generate jar with all dependencies under `target` folder

Use maven command to install `jar` as dependency

```console
$ mvn install:install-file -Dfile=path/to/jar/file \
                           -DgroupId=ltd.vastchain \
                           -DartifactId=vctc-java-sdk \
                           -Dversion=version \
                           -Dpackaging=jar

```

## Usage overview

Here is the code example which highlights the common usage of the SDK.

<details>
<summary>Click to see full code example</summary>

```java
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

    private static final String APPID = "";
    private static final String APPSECRET = "";
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

    /**
     * 发送短信验证码
     * 参考：https://www.vastchain.cn/docs/api/sms
     * @throws VctcException
     */
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

    /**
     * 商户登录
     * 参考：https://www.vastchain.cn/docs#/api/merchant
     * @throws VctcException
     */
    public static void loginMerchant() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        LoginMerchantParam param = new LoginMerchantParam("PM8687779009", "xxx");

        LoginMerchantDTO result = client.loginMerchant(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建商户
     * 参考：https://www.vastchain.cn/docs#/api/merchant
     * @throws VctcException
     */
    public static void createMerchant() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateMerchantParam param = new CreateMerchantParam(MerchantTypeEnum.MERCHANT, "Test", "123456", "xxx", null, false);

        DataIdDTO result = client.createMerchant(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建捐款项目
     * 参考：https://www.vastchain.cn/docs#/api/donation
     * @throws VctcException
     */
    public static void createDonationProject() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateDonationProjectParam param = new CreateDonationProjectParam("1", System.currentTimeMillis(), "关爱重症儿童，助力象山小荣荣", "今天我们隆重推出新项目：关爱重症儿童。这个项目是由慈善基金会发起的，可信度很高", "XX省慈善基金会", new String[]{"基金会"}, new String[]{"助学"}, new String[]{"30000.00 RMB"});

        VctcApiResponseDTO result = client.createDonationProject(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建捐款项目的一次捐赠
     * 参考：https://www.vastchain.cn/docs#/api/donation
     * @throws VctcException
     */
    public static void donateDonation() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        DonateDonationParam param = new DonateDonationParam("1", "1", "1", "威少", System.currentTimeMillis(), "d6bc8b1b17ff4861aca578e97673b981", "7673b98_d6bc8b1b17ff", "300000 RMB");

        VctcApiResponseDTO result = client.donateDonation(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 获取捐款上链 ID
     * 参考：https://www.vastchain.cn/docs#/api/donation
     * @throws VctcException
     */
    public static void fetchDonateOnChainIds() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        FetchDonateOnChainIdsParam param = new FetchDonateOnChainIdsParam(DonationTypeEnum.DONATE, new String[]{"d6bc8b1b17ff4861aca578e97673b981"});

        FetchDonateOnChainIdsDTO result = client.fetchDonateOnChainIds(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 查询可信积分余额
     * 参考：https://www.vastchain.cn/docs#/api/ft
     * @throws VctcException
     */
    public static void queryFungibleBalance() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        QueryFungibleBalanceParam param = new QueryFungibleBalanceParam("9zdo", "fungible-test", "9zdo", "user1");

        QueryFungibleBalanceDTO result = client.queryFungibleBalance(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 生成可信积分扣款二维码（everiPay）
     * 参考：https://www.vastchain.cn/docs#/api/ft
     * @throws VctcException
     */
    public static void createEveriPay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateEveriPayParam param = new CreateEveriPayParam("9zdo", "fungible-test", "9zdo", "user1", "200", "a7ab5a851cf38626201b884b332d16db");

        CreateEveriPayDTO result = client.createEveriPay(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建预支付单
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
    public static void createMerchantPrePay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        CreateMerchantPrePayParam param = new CreateMerchantPrePayParam("1001", "100");

        CreateMerchantPrePayDTO result = client.createMerchantPrePay(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 获取子商户支付详情
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
    public static void getSubMerchantPayInfo() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        SubMerchantPayInfoParam param = new SubMerchantPayInfoParam("SMFP10293485763", "0");

        SubMerchantPayInfoDTO result = client.getSubMerchantPayInfo(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建微信扫码支付参数
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
    public static void createWechatNativePay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        WechatNativePayParam param = new WechatNativePayParam("SMFP10293485763");

        WechatPayDTO result = client.createWechatNativePay(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建微信小程序支付参数
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
    public static void createWechatPay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        WechatPayParam param = new WechatPayParam("SMFP10293485763", "sadfasfasfasdf");

        WechatPayDTO result = client.createWechatPay(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 创建微信App支付参数
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
    public static void createWechatAppPay() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        WechatAppPayParam param = new WechatAppPayParam("SMFP10293485763", true);

        WechatPayDTO result = client.createWechatAppPay(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 退款接口
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
    public static void refund() throws VctcException {
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        VctcApiClient client = new VctcApiClient(credentialParam);
        RefundParam param = new RefundParam("SMFP10293485763");

        VctcApiResponseDTO result = client.refund(param);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 设置商户支付参数
     * 参考：https://www.vastchain.cn/docs#/api/subpay
     * @throws VctcException
     */
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

    /**
     * 获取链上ID接口
     * 参考：https://www.vastchain.cn/docs#/api/up_commit
     * @throws VctcException
     */
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

    /**
     * 批量上链接口
     * 参考：https://www.vastchain.cn/docs#/api/up_commit
     * @throws VctcException
     */
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

```

</details>
