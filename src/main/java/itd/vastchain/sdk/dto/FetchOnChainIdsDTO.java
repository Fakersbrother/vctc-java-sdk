package itd.vastchain.sdk.dto;

import java.util.List;

public class FetchOnChainIdsDTO extends VctcApiResponseDTO {

    /**
     * 如果响应的 items 数组的某一项为空对象（{ }），也就是没有 id 字段，说明上链已彻底失败，或者查询的 id 不存在，请重新提交。
     * 如果响应的 items 数组的某一项的  id 为空字符串（{ "id": "" }），则代表上链已提交，尚未获取到最终确认结果，请耐心等待再查询。
     */
    private List<FetchOnChainIdsItemsDTO> items;

    public List<FetchOnChainIdsItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<FetchOnChainIdsItemsDTO> items) {
        this.items = items;
    }
}
