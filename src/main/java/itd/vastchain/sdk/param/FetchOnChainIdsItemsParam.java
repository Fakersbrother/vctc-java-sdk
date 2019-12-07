package itd.vastchain.sdk.param;

public class FetchOnChainIdsItemsParam {

    /** 上链的动作（action）类别，此参数的值必须和上链时传递的 type 参数一致 */
    private String type;
    /**  要查询上链状态的上链项目的 id */
    private String id;
    /** 值必须为 i2c 或 c2i 之一。前者代表通过本地的数据 id（即上链时提供的 id） 获取链上 id，后者代表通过 链上 id 获取本地 id*/
    private String queryType;

    public FetchOnChainIdsItemsParam() {

    }

    public FetchOnChainIdsItemsParam(String type, String id, String queryType) {
        this.type = type;
        this.id = id;
        this.queryType = queryType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
