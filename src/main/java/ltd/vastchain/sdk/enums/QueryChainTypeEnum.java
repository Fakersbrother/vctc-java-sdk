package ltd.vastchain.sdk.enums;

public enum QueryChainTypeEnum {
    I2C("i2c"),
    C2I("c2i");

    private String code;

    QueryChainTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
