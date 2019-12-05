package io.vastchain.sdk.dto;

import com.alibaba.fastjson.JSONObject;

public class FetchOnChainIdsDTO extends VastChainResponseDTO {

    private JSONObject items;

    public JSONObject getItems() {
        return items;
    }

    public void setItems(JSONObject items) {
        this.items = items;
    }
}
