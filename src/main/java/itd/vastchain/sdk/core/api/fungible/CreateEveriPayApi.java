package itd.vastchain.sdk.core.api.fungible;

import com.alibaba.fastjson.JSON;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.CreateEveriPayDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.CreateEveriPayParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateEveriPayApi
 * 生成可信积分扣款二维码（everiPay）
 * 生成某个用户在某种可信积分扣款的二维码。该二维码的有效期为 20 秒，再加上可能的时间误差，请每 5 秒请求并生成一个新的二维码，并在界面上刷新。
 *
 */
public class CreateEveriPayApi extends AbstractVctcApi {

    private final String path = "/fungible-token/everiPay/";

    public CreateEveriPayApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        CreateEveriPayParam param = (CreateEveriPayParam)apiParam.getBuinessApiParam();
        StringBuffer query = new StringBuffer("");
        query.append("tokenAppId=").append(param.getTokenAppId());
        query.append("&tokenId=").append(param.getTokenId());
        query.append("&userAppId=").append(param.getUserAppId());
        query.append("&userId=").append(param.getUserId());
        query.append("&maxAmount=").append(param.getMaxAmount());
        query.append("&uuid=").append(param.getUuid());

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setQuery(query.toString());
        apiContext.setHttpMethod(HttpMethodEnum.GET.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected CreateEveriPayDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).get();
        return JSON.parseObject(result, CreateEveriPayDTO.class);
    }
}
