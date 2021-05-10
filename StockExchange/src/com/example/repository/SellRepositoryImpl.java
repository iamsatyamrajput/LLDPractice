package com.example.repository;

import com.example.models.Order;

import java.util.*;

public class SellRepositoryImpl implements SellRepository{
    private final Map<String, ArrayList<Order>> sellRequests = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        if(sellRequests.get(order.getStock().getName())==null){
            sellRequests.put(order.getStock().getName(),new ArrayList<>(Arrays.asList(order)));
        } else {
            sellRequests.get(order.getStock().getName()).add(order);
        }
    }

    @Override
    public Order getNextOrder(String stock, int position) {
       if(sellRequests.get(stock)!=null && sellRequests.get(stock).size() <= position){
           return null;
       }
       return sellRequests.get(stock).get(position);
    }

    @Override
    public void clear() {
        sellRequests.clear();
    }
}
