package ltd.vastchain.sdk;

import ltd.vastchain.sdk.core.VctcApiContext;
import ltd.vastchain.sdk.enums.HttpMethodEnum;
import ltd.vastchain.sdk.param.QueryFungibleBalanceParam;
import ltd.vastchain.sdk.param.VctcApiAppIdCredentialParam;
import ltd.vastchain.sdk.param.VctcApiCredentialParam;
import ltd.vastchain.sdk.util.Signature;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignatureTest {

    private static final String APPID = "AzE5";
    private static final String APPSECRET = "u4VcwCrZ0tD$ozhE";
    private static final String HOST_URL = "https://v1.api.tc.vastchain.ltd";

    @Test
    public void test() {
        VctcApiContext apiContext = buildContext();
        String url = Signature.sign(apiContext,1577674442066L);
        String expected = "https://v1.api.tc.vastchain.ltd/fungible-token/balance/?_appid=AzE5&_t=1577674442066&tokenAppId=9zdo&tokenId=fungible-test&userAppId=9zdo&userId=user1&_s=dbc363db4fbae3189572ea09dc8eb58db0f90dee972cea1c6f9a24532bf8d0ad";
        assertEquals(expected, url);
    }

    private VctcApiContext buildContext(){
        VctcApiCredentialParam credentialParam = new VctcApiAppIdCredentialParam(APPID, APPSECRET, HOST_URL);
        QueryFungibleBalanceParam param = new QueryFungibleBalanceParam("9zdo", "fungible-test", "9zdo", "user1");

        StringBuffer query = new StringBuffer("");
        query.append("tokenAppId=").append(param.getTokenAppId());
        query.append("&tokenId=").append(param.getTokenId());
        query.append("&userAppId=").append(param.getUserAppId());
        query.append("&userId=").append(param.getUserId());

        VctcApiContext apiContext = new VctcApiContext();
        apiContext.setPath("/fungible-token/balance/");
        apiContext.setQuery(query.toString());
        apiContext.setHttpMethod(HttpMethodEnum.GET.getCode());
        apiContext.setCredentialParam(credentialParam);
        return apiContext;
    }
}
