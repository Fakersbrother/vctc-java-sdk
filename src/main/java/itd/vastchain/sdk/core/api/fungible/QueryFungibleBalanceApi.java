package itd.vastchain.sdk.core.api.fungible;

import com.alibaba.fastjson.JSON;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.QueryFungibleBalanceDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.QueryFungibleBalanceParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * QueryFungibleBalanceApi
 * 查询可信积分余额
 * 查询某种可信积分在某个用户 ID 的余额。
 *
 */
public class QueryFungibleBalanceApi extends AbstractVctcApi {

    private final String path = "/fungible-token/balance/";

    public QueryFungibleBalanceApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        QueryFungibleBalanceParam param = (QueryFungibleBalanceParam)apiParam.getBuinessApiParam();
        StringBuffer query = new StringBuffer("");
        query.append("tokenAppId=").append(param.getTokenAppId());
        query.append("&tokenId=").append(param.getTokenId());
        query.append("&userAppId=").append(param.getUserAppId());
        query.append("&userId=").append(param.getUserId());

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setQuery(query.toString());
        apiContext.setHttpMethod(HttpMethodEnum.GET.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected QueryFungibleBalanceDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).get();
        return JSON.parseObject(result, QueryFungibleBalanceDTO.class);
    }
}
