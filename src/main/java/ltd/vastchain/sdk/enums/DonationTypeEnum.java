package ltd.vastchain.sdk.enums;

public enum DonationTypeEnum {
    PROJECT("project"),
    DONATE("donate");

    private String code;

    DonationTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
