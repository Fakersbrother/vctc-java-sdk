package ltd.vastchain.sdk.enums;

public enum MerchantTypeEnum {
    SUB_MERCHANT("subMerchant"),
    MERCHANT("merchant");

    private String code;

    MerchantTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
