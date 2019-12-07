package itd.vastchain.sdk.core.api.donation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.core.AbstractVctcApi;
import itd.vastchain.sdk.core.VctcApiContext;
import itd.vastchain.sdk.dto.VctcApiResponseDTO;
import itd.vastchain.sdk.enums.HttpMethodEnum;
import itd.vastchain.sdk.exception.VctcClientException;
import itd.vastchain.sdk.exception.VctcException;
import itd.vastchain.sdk.param.CreateDonationProjectParam;
import itd.vastchain.sdk.param.VctcApiParam;
import itd.vastchain.sdk.util.OkhttpApi;

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
