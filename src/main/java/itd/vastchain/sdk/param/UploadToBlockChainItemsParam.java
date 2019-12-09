package itd.vastchain.sdk.param;

import com.alibaba.fastjson.JSONObject;
import itd.vastchain.sdk.enums.UploadChainTypeEnum;

public class UploadToBlockChainItemsParam {
    private UploadChainTypeEnum type;

    private JSONObject items;

    public UploadToBlockChainItemsParam() {

    }

    public UploadToBlockChainItemsParam(UploadChainTypeEnum type) {
        this.type = type;
    }

    public UploadToBlockChainItemsParam(UploadChainTypeEnum type, JSONObject items) {
        this.type = type;
        this.items = items;
    }

    public String getType() {
        return type.getCode();
    }

    public void setType(UploadChainTypeEnum type) {
        this.type = type;
    }

    public JSONObject getItems() {
        return items;
    }

    public void setItems(JSONObject items) {
        this.items = items;
    }
}
