package ltd.vastchain.sdk.core.api.donation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.core.AbstractVctcApi;
import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.dto.VctcApiResponseDTO;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.exception.VctcClientException;
import ltd.vastchain.sdk.exception.VctcException;
import ltd.vastchain.sdk.param.CreateDonationProjectParam;
import ltd.vastchain.sdk.param.VctcApiParam;
import ltd.vastchain.sdk.util.OkhttpApi;

/**
 * CreateDonationProjectApi
 * 创建捐款项目
 *
 */
public class CreateDonationProjectApi extends AbstractVctcApi {

    private final String path = "/donation/project/";

    public CreateDonationProjectApi(VctcApiParam apiParam) {
        super(apiParam);
    }

    @Override
    protected void specialValidate() throws VctcClientException {

    }

    @Override
    protected VctcApiContext buildContext() {
        CreateDonationProjectParam param = (CreateDonationProjectParam)apiParam.getBuinessApiParam();
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
