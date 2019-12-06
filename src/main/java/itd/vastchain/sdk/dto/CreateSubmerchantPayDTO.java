package itd.vastchain.sdk.dto;

public class CreateSubmerchantPayDTO extends VctcApiResponseDTO {

    private String prepayId;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
}
