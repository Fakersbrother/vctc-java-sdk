package itd.vastchain.sdk.param;


public class CreateDonationProjectParam {

    /**  必选，在项目方数据库中能唯一找到项目的项目 id，请确保该 id 不重复且可查询到项目情况 */
    private String id;
    /** 可选，项目的创建时间(UNIX 时间戳)，请以数值形式传递*/
    private Long createTime;
    /** 可选，项目名称 */
    private String title;
    /** （可选，项目描述 */
    private String desc;
    /** 可选，发起单位 */
    private String founder;
    /** 可选，项目类别，请以数组方式提供 */
    private String [] category;
    /** 可选，自定义关键词，请以数组方式提供 */
    private String [] keyWords;
    /** 可选，目标金额，请务必按照此格式提供，分别代表最少金额（低于则项目不成立）、最高金额（超过则不再募资）；小数点后至少要有2位 */
    private String [] targetAmount;

    public CreateDonationProjectParam() {
    }

    public CreateDonationProjectParam(String id) {
        this.id = id;
    }

    public CreateDonationProjectParam(String id, Long createTime, String title, String desc, String founder, String[] category, String[] keyWords, String[] targetAmount) {
        this.id = id;
        this.createTime = createTime;
        this.title = title;
        this.desc = desc;
        this.founder = founder;
        this.category = category;
        this.keyWords = keyWords;
        this.targetAmount = targetAmount;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String[] keyWords) {
        this.keyWords = keyWords;
    }

    public String[] getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String[] targetAmount) {
        this.targetAmount = targetAmount;
    }
}
