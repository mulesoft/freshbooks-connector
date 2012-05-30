package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;

public class ItemResponse extends BaseResponse {
    @XmlElement(name = "item_id", nillable=true)
    private String itemId;
    @XmlElement(name = "item", required = false)
    private Item item;
    @XmlElement(name = "items", required = false)
    private Items items;

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
