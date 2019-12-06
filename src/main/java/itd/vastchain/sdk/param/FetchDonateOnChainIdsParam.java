package itd.vastchain.sdk.param;


import itd.vastchain.sdk.core.VctcApiContext;

public class FetchDonateOnChainIdsParam{

    /**  要获取项目(project) 的链上 id，还是捐赠记录（donate）的链上id */
    private String type;
    /** 要查询的 id 列表，每次可批量查询 20 个 */
    private Long originalIds;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOriginalIds() {
        return originalIds;
    }

    public void setOriginalIds(Long originalIds) {
        this.originalIds = originalIds;
    }
}
