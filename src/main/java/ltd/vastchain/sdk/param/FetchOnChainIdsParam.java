package ltd.vastchain.sdk.param;

import java.util.List;

public class FetchOnChainIdsParam{
    /** 包含一个或多个上链项目信息的数组，目前，每次最多批量查询 500 条记录 */
    private List<FetchOnChainIdsItemsParam> items;

    public FetchOnChainIdsParam() {
    }
    public FetchOnChainIdsParam(List<FetchOnChainIdsItemsParam> items) {
        this.items = items;
    }

    public List<FetchOnChainIdsItemsParam> getItems() {
        return items;
    }

    public void setItems(List<FetchOnChainIdsItemsParam> items) {
        this.items = items;
    }
}
