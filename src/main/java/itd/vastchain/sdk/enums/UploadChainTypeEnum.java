package itd.vastchain.sdk.enums;

public enum UploadChainTypeEnum {
    EVERIPAY("everiPay"),
    DATA_BUCKET_REGISTER("data-bucket-register"),
    DATA_ITEM_CREATE("data-item-create"),
    VOLUNTARY_ACTIVITY_REGISTER("voluntary-activity-register"),
    VOLUNTARY_ACTIVITY_SIGNIN("voluntary-activity-signIn"),
    VOLUNTARY_ACTIVITY_SIGNOUT("voluntary-activity-signOut"),
    INTELLIGENT_DOORLOCK_MODEL("intelligent-doorlock-model"),
    INTELLIGENT_DOORLOCK_REGISTER("intelligent-doorlock-register"),
    EVERIPASS("everiPass"),
    FUNGIBLE_TOKEN_SYMBOL_REGISTER("fungible-token-symbol-register"),
    FUNGIBLE_TOKEN_ISSUE("fungible-token-issue"),
    FUNGIBLE_TOKEN_TRANSFER("fungible-token-transfer");

    private String code;

    UploadChainTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
