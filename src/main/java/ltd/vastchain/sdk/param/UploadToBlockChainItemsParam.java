package ltd.vastchain.sdk.param;

import com.alibaba.fastjson.JSONObject;
import ltd.vastchain.sdk.enums.UploadChainTypeEnum;

public class UploadToBlockChainItemsParam {
    private UploadChainTypeEnum type;

    private JSONObject args;

    public UploadToBlockChainItemsParam() {

    }

    public UploadToBlockChainItemsParam(UploadChainTypeEnum type) {
        this.type = type;
    }

    public UploadToBlockChainItemsParam(UploadChainTypeEnum type, JSONObject items) {
        this.type = type;
        this.args = items;
    }

    public String getType() {
        return type.getCode();
    }

    public void setType(UploadChainTypeEnum type) {
        this.type = type;
    }

    public JSONObject getArgs() {
        return args;
    }

    public void setArgs(JSONObject args) {
        this.args = args;
    }
}
