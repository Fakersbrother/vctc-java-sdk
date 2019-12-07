package itd.vastchain.sdk.dto;


public class QueryFungibleBalanceDTO extends VctcApiResponseDTO {

    private QueryFungibleBalanceDataDTO data;

    public QueryFungibleBalanceDataDTO getData() {
        return data;
    }

    public void setData(QueryFungibleBalanceDataDTO data) {
        this.data = data;
    }
}
