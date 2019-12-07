package itd.vastchain.sdk.dto;


public class CreateEveriPayDTO extends VctcApiResponseDTO {

    private CreateEveriPayDataDTO data;

    public CreateEveriPayDataDTO getData() {
        return data;
    }

    public void setData(CreateEveriPayDataDTO data) {
        this.data = data;
    }
}
