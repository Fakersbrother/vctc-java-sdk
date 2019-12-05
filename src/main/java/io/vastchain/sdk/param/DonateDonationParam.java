package io.vastchain.sdk.param;


public class DonateDonationParam extends VastChainRequestParam {

    /**  必选，在项目方数据库中能唯一找到项目的项目 id，请确保该 id 不重复且可查询到项目情况 */
    private String id;
    /** 可选，项目的创建时间(UNIX 时间戳)，请以数值形式传递*/
    private Long createTime;
    /** 可选，捐赠者 id，同一个捐赠者多次捐赠的，此处必须相同 */
    private String donatorId;
    /** 建议传输，捐赠者公钥地址，可作为捐款证明使用，如果捐款者拥有某些兼容 everiToken 芯片的市民卡、交通卡（如嘉兴杭州等），也可以直接写入卡内 */
    private String donatorPublicKey;
    /** 可选，捐赠者名称 */
    private String donatorName;
    /** 必选，捐赠所对应的项目 id，项目必须存在 */
    private String projectIdBiz;
    /** 可选，捐赠所对应的项目 id 上链后的 id，后面有一个 API 可根据 `projectId_biz` 查询此上链 id */
    private String projectIdBc;
    /** 可选，金额，请务必按照此格式提供，小数点后要有2位 */
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(String donatorId) {
        this.donatorId = donatorId;
    }

    public String getDonatorPublicKey() {
        return donatorPublicKey;
    }

    public void setDonatorPublicKey(String donatorPublicKey) {
        this.donatorPublicKey = donatorPublicKey;
    }

    public String getDonatorName() {
        return donatorName;
    }

    public void setDonatorName(String donatorName) {
        this.donatorName = donatorName;
    }

    public String getProjectIdBiz() {
        return projectIdBiz;
    }

    public void setProjectIdBiz(String projectIdBiz) {
        this.projectIdBiz = projectIdBiz;
    }

    public String getProjectIdBc() {
        return projectIdBc;
    }

    public void setProjectIdBc(String projectIdBc) {
        this.projectIdBc = projectIdBc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
