package itd.vastchain.sdk.dto;


public class CreateEveriPayDataDTO {

    /** 查询到的余额，目前每次只返回一组结果，因此数组中只有一项 */
    private String [] evtLinks;

    public String[] getEvtLinks() {
        return evtLinks;
    }

    public void setEvtLinks(String[] evtLinks) {
        this.evtLinks = evtLinks;
    }
}
