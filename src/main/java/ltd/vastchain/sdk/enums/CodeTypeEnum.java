package ltd.vastchain.sdk.enums;

public enum CodeTypeEnum {
    INTEGER("integer");

    private String code;



    CodeTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
