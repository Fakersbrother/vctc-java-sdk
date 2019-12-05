package io.vastchain.sdk.dto;

import com.alibaba.fastjson.JSONObject;

public class WechatPayDTO extends VastChainResponseDTO {

    private JSONObject args;

    public JSONObject getArgs() {
        return args;
    }

    public void setArgs(JSONObject args) {
        this.args = args;
    }
}
