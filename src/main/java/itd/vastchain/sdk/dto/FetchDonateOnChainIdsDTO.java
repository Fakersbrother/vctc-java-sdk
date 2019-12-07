package itd.vastchain.sdk.dto;

import java.util.Map;

public class FetchDonateOnChainIdsDTO extends VctcApiResponseDTO {

    private Map<String,String> ids;

    public Map<String, String> getIds() {
        return ids;
    }

    public void setIds(Map<String, String> ids) {
        this.ids = ids;
    }
}
