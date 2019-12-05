package io.vastchain.sdk.param;


public class LoginMerchantParam extends ApiRequestParam {
    /** 要登录的商户号或者子商户号 */
    private String userId;
    /** 登录密码 */
    private String pw;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
