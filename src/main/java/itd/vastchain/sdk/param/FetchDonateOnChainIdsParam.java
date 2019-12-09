package itd.vastchain.sdk.param;


import itd.vastchain.sdk.enums.DonationTypeEnum;

public class FetchDonateOnChainIdsParam {

    /**
     * 要获取项目(project) 的链上 id，还是捐赠记录（donate）的链上id
     */
    private DonationTypeEnum type;
    /**
     * 要查询的 id 列表，每次可批量查询 20 个
     */
    private String[] originalIds;


    public FetchDonateOnChainIdsParam() {
    }

    public FetchDonateOnChainIdsParam(DonationTypeEnum type, String[] originalIds) {
        this.type = type;
        this.originalIds = originalIds;
    }

    public DonationTypeEnum getType() {
        return type;
    }

    public void setType(DonationTypeEnum type) {
        this.type = type;
    }

    public String[] getOriginalIds() {
        return originalIds;
    }

    public void setOriginalIds(String[] originalIds) {
        this.originalIds = originalIds;
    }
}
