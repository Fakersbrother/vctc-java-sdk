package itd.vastchain.sdk.dto;

public class CreateMerchantPrePayDTO extends VctcApiResponseDTO {

    /** 预支付单号 */
    private String prepayId;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
}
