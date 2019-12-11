package ltd.vastchain.sdk.dto;

public class WechatPayDTO extends VctcApiResponseDTO {

    private WechatPayArgsDTO args;

    public WechatPayArgsDTO getArgs() {
        return args;
    }

    public void setArgs(WechatPayArgsDTO args) {
        this.args = args;
    }
}
