package io.vastchain.sdk.dto;

import com.alibaba.fastjson.JSONObject;

public class FetchDonateOnChainIdsDTO extends VastChainResponseDTO {

    private JSONObject ids;

    public JSONObject getIds() {
        return ids;
    }

    public void setIds(JSONObject ids) {
        this.ids = ids;
    }
}
