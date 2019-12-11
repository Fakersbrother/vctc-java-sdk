package ltd.vastchain.sdk.dto;

/**
 * common data id dto
 * {
 *   "status": "success",
 *   "version": "1",
 *   "data": {
 *       "id": "xxx"
 *   }
 * }
 */
public class DataIdDTO extends VctcApiResponseDTO {

    private IDDTO data;

    public IDDTO getData() {
        return data;
    }

    public void setData(IDDTO data) {
        this.data = data;
    }
}

