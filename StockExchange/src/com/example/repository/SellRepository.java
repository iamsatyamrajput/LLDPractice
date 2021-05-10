package com.example.repository;

import com.example.models.Order;

public interface SellRepository {
    public void addOrder(Order order);
    public Order getNextOrder(String stock, int position);
    public void clear();
}
