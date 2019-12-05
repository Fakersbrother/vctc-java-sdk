package io.vastchain.sdk.dto;

public class SubmerchantPayDTO extends VastChainResponseDTO {

    private String prepayId;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
}
