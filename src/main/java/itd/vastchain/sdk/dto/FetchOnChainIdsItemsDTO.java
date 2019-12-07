package itd.vastchain.sdk.dto;

public class FetchOnChainIdsItemsDTO {

    /**  代表该数据在链上的唯一标志，此标志在宇链云内部通用，相同的上链数据生成的链上 ID 是相同的，这可以防止重复上链。如果 id 为空字符串（""），说明上链已提交，但正在排队或尚未确认最终状态。*/
    private String id;
    /**  代表此次上链在链上所对应的事务 ID（Transaction Id），可以通过区块链浏览器查询。如果该上链被分为多个事务（Transaction） */
    private String chainTrxId;
    /**  代表此次上链的区块号（Block Num）。一个区块里可能有很多个事务（transaction），所以仅凭区块号不能完全定位到某条数据 */
    private String chainBlockNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChainTrxId() {
        return chainTrxId;
    }

    public void setChainTrxId(String chainTrxId) {
        this.chainTrxId = chainTrxId;
    }

    public String getChainBlockNum() {
        return chainBlockNum;
    }

    public void setChainBlockNum(String chainBlockNum) {
        this.chainBlockNum = chainBlockNum;
    }
}
