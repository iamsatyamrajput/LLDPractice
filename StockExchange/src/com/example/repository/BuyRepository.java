package com.example.repository;

import com.example.models.Order;
import com.example.models.Stock;

public interface BuyRepository {
    public void addOrder(Order order);
    public Order getNextOrder(String stock , int position);
    public void clear();
}
