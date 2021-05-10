package com.example.repository;

import com.example.models.Order;
import com.example.models.Stock;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuyRepositoryImpl implements BuyRepository{
    private final Map<String, ArrayList<Order>> buyRequests = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        if(buyRequests.get(order.getStock().getName())==null){
            buyRequests.put(order.getStock().getName(),new ArrayList<>(Arrays.asList(order)));
        } else {
            buyRequests.get(order.getStock().getName()).add(order);
        }
    }

    @Override
    public Order getNextOrder(String stock, int position) {
        if(buyRequests.get(stock)!=null && buyRequests.get(stock).size() <= position ){
            return null;
        }
        return buyRequests.get(stock).get(position);
    }

    @Override
    public void clear() {
        buyRequests.clear();
    }
}
