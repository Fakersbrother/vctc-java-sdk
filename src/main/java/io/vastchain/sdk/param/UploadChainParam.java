package io.vastchain.sdk.param;

import com.alibaba.fastjson.JSONArray;

public class UploadChainParam extends VastChainRequestParam {
    /** 包含一个或多个上链项目信息的数组，目前，每次最多批量查询 500 条记录 */
    private JSONArray items;

    public JSONArray getItems() {
        return items;
    }

    public void setItems(JSONArray items) {
        this.items = items;
    }
}
