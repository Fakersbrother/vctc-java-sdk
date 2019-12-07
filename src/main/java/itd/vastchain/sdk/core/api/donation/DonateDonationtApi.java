package itd.vastchain.sdk.core.api.donation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.VctcApiResponseDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.DonateDonationParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

/**
 * DonateDonationtApi
 * 创建捐款项目的一次捐赠
 *
 */
public class DonateDonationtApi extends AbstractVctcApi {

    private final String path = "/donation/donate/";

    public DonateDonationtApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        DonateDonationParam param = (DonateDonationParam)apiParam.getBuinessApiParam();
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

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath(path);
        apiContext.setBody(body);
        apiContext.setHttpMethod(HttpMethodEnum.POST.getCode());
        apiContext.setCredentialParam(apiParam.getCredentialParam());
        return apiContext;
    }

    @Override
    protected VctcApiResponseDTO callApi(VctcApiContext context) throws VctcException {
        String result = new OkhttpApi(context.getFullApiurl(), context.getCredentialParam().getTimeout()).post(context.getBody());
        return JSON.parseObject(result, VctcApiResponseDTO.class);
    }
}
