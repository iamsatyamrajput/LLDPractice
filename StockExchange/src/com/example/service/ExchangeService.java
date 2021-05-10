package com.example.service;

import com.example.models.Order;
import com.example.models.OrderResponse;

import java.util.List;

public interface ExchangeService {
    public List<OrderResponse> processOrder();
    public void placeOrder(Order order);
}
