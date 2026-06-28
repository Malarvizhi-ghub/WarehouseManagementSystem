package com.wipro.wms.entity;

public class Item {
	private String itemId;
    private String itemName;
    private String category;
    private int totalQuantity;

    public Item() {
    }

    public Item(String itemId, String itemName, String category, int totalQuantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.totalQuantity = totalQuantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
	
}
