package itd.vastchain.sdk.core.api.pay;

import com.alibaba.fastjson.JSON;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.SubMerchantPayInfoDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.SubMerchantPayInfoParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * GetSubMerchantPayInfoApi
 * 获取子商户支付详情
 * GET https://xxx/submerchant-pay/prePay/[prepayid]
 *
 */
public class GetSubMerchantPayInfoApi extends AbstractVctcApi {

    private final String path = "/submerchant-pay/prePay/";

    public GetSubMerchantPayInfoApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        SubMerchantPayInfoParam param = (SubMerchantPayInfoParam)apiParam.getBuinessApiParam();
        StringBuffer query = new StringBuffer("");
        query.append("waitForFinish=").append(param.getWaitForFinish());

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path + param.getPrepayid());
        apiContext.setQuery(query.toString());
        apiContext.setHttpMethod(HttpMethodEnum.GET.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected SubMerchantPayInfoDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).get();
        return JSON.parseObject(result, SubMerchantPayInfoDTO.class);
    }
}
