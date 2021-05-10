package com.example.models;

public class Order {
    private Integer id;
    private String time;
    private Stock stock;
    private String operation;

    public Order(Integer id, String time, Stock stock, String operation) {
        this.id = id;
        this.time = time;
        this.stock = stock;
        this.operation = operation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
