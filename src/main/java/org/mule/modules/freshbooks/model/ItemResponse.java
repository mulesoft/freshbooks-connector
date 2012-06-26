package org.mule.modules.freshbooks.model;


public class ItemResponse extends BaseResponse {
    private String itemId;
    private Item item;
    private Items items;

    public ItemResponse(Response response) {
        initBaseResponseFields(response);
        itemId = response.getItemId();
        item = response.getItem();
        items = response.getItems();
    }
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
