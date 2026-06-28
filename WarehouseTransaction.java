package com.wipro.wms.entity;

public class WarehouseTransaction {
	private String transactionId;
    private String itemId;
    private String locationId;
    private String transactionType;
    private int quantity;
    private String date;

    public WarehouseTransaction() {

    }

    public WarehouseTransaction(String transactionId, String itemId,
            String locationId, String transactionType,
            int quantity, String date) {

        this.transactionId = transactionId;
        this.itemId = itemId;
        this.locationId = locationId;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
