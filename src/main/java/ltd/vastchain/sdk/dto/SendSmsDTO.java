package ltd.vastchain.sdk.dto;

/** SendSmsDTO */
public class SendSmsDTO extends VctcApiResponseDTO {

    /** SendSmsDataDTO */
    private SendSmsDataDTO data;

    public SendSmsDataDTO getData() {
        return data;
    }

    public void setData(SendSmsDataDTO data) {
        this.data = data;
    }


}

