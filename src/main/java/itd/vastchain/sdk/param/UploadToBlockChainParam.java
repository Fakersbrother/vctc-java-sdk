package itd.vastchain.sdk.param;

import java.util.List;

public class UploadToBlockChainParam {
    /**
     * 包含一个或多个上链项目信息的数组，目前，每次最多批量查询 500 条记录
     */
    private List<UploadToBlockChainItemsParam> items;

    public UploadToBlockChainParam() {

    }

    public UploadToBlockChainParam(List<UploadToBlockChainItemsParam> items) {
        this.items = items;
    }

    public List<UploadToBlockChainItemsParam> getItems() {
        return items;
    }

    public void setItems(List<UploadToBlockChainItemsParam> items) {
        this.items = items;
    }
}
