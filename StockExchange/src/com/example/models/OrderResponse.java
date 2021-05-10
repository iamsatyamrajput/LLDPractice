package com.example.models;

public class OrderResponse {
    private Integer buyId;
    private Double sellPrice;
    private Integer quantity;
    private Integer sellId;

    public OrderResponse(Integer buyId, Double sellPrice, Integer quantity, Integer sellId) {
        this.buyId = buyId;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.sellId = sellId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    @Override
    public String toString() {
        return "#"+buyId +" "+ sellPrice +" "+ quantity +" #"+sellId ;
    }
}
