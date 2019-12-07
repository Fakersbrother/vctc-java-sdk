package itd.vastchain.sdk.constant;

/**
 * api response error names
 */
public class VctcApiErrorNames {

    /****************************************CAT_GENERAL_HTTP HTTP 相关普通错误*********************************************************/
    public static final String NOTFOUND = "notFound";
    public static final String HTTPAPI_REQUEST_EXCEED_RATE_LIMIT = "httpApi_request_exceed_rate_limit";
    public static final String HTTPAPI_INVALID_SIGNATURE = "httpApi_invalid_signature";
    public static final String HTTPAPI_INVALID_TIMESTAMP = "httpApi_invalid_timestamp";
    public static final String HTTPAPI_INVALID_APPID = "httpApi_invalid_appid";

    /****************************************CAT_PAYMENT_MERCHANT 支付商户相关*********************************************************/
    public static final String MERCHANT_LOGIN_INVALID_CREDENTIALS1 = "merchant_login_invalid_credentials1";
    public static final String MERCHANT_LOGIN_INVALID_CREDENTIALS2 = "merchant_login_invalid_credentials2";
    public static final String MERCHANT_NO_LOGINTOKEN = "merchant_no_loginToken";
    public static final String MERCHANT_INVALID_TOKEN = "merchant_invalid_token";
    public static final String MERCHANT_REFUND_ERROR = "merchant_refund_error";
    public static final String MERCHANT_DUPLICATE_PAYMENT = "merchant_duplicate_payment";
    public static final String MERCHANT_UNIONPAY_ERROR = "merchant_unionpay_error";
    public static final String MERCHANT_MISMATCH = "merchant_mismatch";
    public static final String MERCHANT_PROFITSHARING_EXCEED_LIMIT = "merchant_profitsharing_exceed_limit";
    public static final String MERCHANT_INVALID_PAYMENTCHANNEL_PARAMS = "merchant_invalid_paymentchannel_params";
    public static final String MERCHANT_INVALID_PAYMENTCHANNEL_PARAMS2 = "merchant_invalid_paymentchannel_params2";
    public static final String MERCHANT_INVALID_PAYMENTCHANNEL_PARAMS3 = "merchant_invalid_paymentchannel_params3";
    public static final String PREPAIDID_INVALID_STATE = "prepaidId_invalid_state";

    /****************************************CAT_INTERNAL_SERVER_ERROR 内部错误*********************************************************/
    public static final String INTERNAL_SERVER_ERROR = "internal_server_error";

    /****************************************CAT_GENERAL 通用错误***********************************************************************/
    public static final String INVALID_PARAMETER = "invalid_parameter";
    public static final String NO_ACCESS_PERMISSION = "no_access_permission";
    public static final String PARAMETER_OUT_OF_RANGE = "parameter_out_of_range";
    public static final String ASSERT_ERROR = "assert_error";
    public static final String EXCEED_SIZE_LIMITATION = "exceed_size_limitation";
    public static final String INPUT_EXCEED_PRECISION = "input_exceed_precision";
    public static final String BUSY_ERROR = "busy_error";
    public static final String DUPLICATE_ENTITY = "duplicate_entity";

    /****************************************CAT_SMS 短信相关错误**********************************************************************/
    public static final String SENDING_SMS_WAS_FAILED = "sending_sms_was_failed";

    /**************************************CAT_UPLOAD_ONTO_CHAIN 数据上链相关错误*******************************************************/
    public static final String UPLOAD_TO_CHAIN_ITEM_BUSSINESS_ID_IS_DUPLICATE = "upload_to_chain_item_bussiness_id_is_duplicate";
    public static final String INVALID_EVTLINK = "invalid_evtlink";
    public static final String BLOCKCHAIN_REQUEST_ERROR = "blockchain_request_error";
    public static final String BLOCKCHAIN_PENDING_ERROR = "blockchain_pending_error";
}
