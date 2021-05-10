package com.example.service;

import com.example.models.Order;
import com.example.models.OrderResponse;
import com.example.models.Stock;
import com.example.repository.BuyRepository;
import com.example.repository.BuyRepositoryImpl;
import com.example.repository.SellRepository;
import com.example.repository.SellRepositoryImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExchangeServiceImpl implements ExchangeService {
    BuyRepository buy = new BuyRepositoryImpl();
    SellRepository sell = new SellRepositoryImpl();
    Set<String> stockInTrade = new HashSet<>();

    public List<OrderResponse> processOrder(){
        List<OrderResponse> responses = new ArrayList<>();
        for ( String stock : stockInTrade ) {
            int i=0;
            while(buy.getNextOrder(stock,i) != null){
                Order buyOrder = buy.getNextOrder(stock,i);
                int j=0;
                while (sell.getNextOrder(stock,j) != null) {
                    Order sellOrder = sell.getNextOrder(stock,j);
                    if (sellOrder.getStock().getPrice() <= buyOrder.getStock().getPrice() && sellOrder.getStock().getQuantity()!=0) {
                        if(sellOrder.getStock().getQuantity() >= buyOrder.getStock().getQuantity()) {
                            responses.add(this.tradeAllBuy(sellOrder,buyOrder));
                        } else {
                            responses.add(this.tradeAllSell(sellOrder,buyOrder));
                        }
                    }
                    j++;
                }
                i++;
            }

        }
        return responses;
    }

    private OrderResponse tradeAllSell(Order sellOrder, Order buyOrder) {
        OrderResponse orderResponse =  new OrderResponse(buyOrder.getId(),
                sellOrder.getStock().getPrice(),
                 sellOrder.getStock().getQuantity(),
                sellOrder.getId());
        buyOrder.getStock().setQuantity(buyOrder.getStock().getQuantity() - sellOrder.getStock().getQuantity());
        sellOrder.getStock().setQuantity(0);
        return orderResponse;
    }

    private OrderResponse tradeAllBuy(Order sellOrder, Order buyOrder) {
        OrderResponse orderResponse = new OrderResponse(buyOrder.getId(),
                sellOrder.getStock().getPrice(),
                buyOrder.getStock().getQuantity(),
                sellOrder.getId());
        sellOrder.getStock().setQuantity(sellOrder.getStock().getQuantity()-buyOrder.getStock().getQuantity());
        buyOrder.getStock().setQuantity(0);
        return orderResponse;
    }

    public void placeOrder(Order order){
        stockInTrade.add(order.getStock().getName());
        switch (order.getOperation()){
            case "buy" : buy.addOrder(order);
                        break;
            case "sell" : sell.addOrder(order);
                        break;
            default: break;
        }
    }
}
