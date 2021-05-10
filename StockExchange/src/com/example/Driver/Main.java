package com.example.Driver;

import com.example.models.Order;
import com.example.models.OrderResponse;
import com.example.models.Stock;
import com.example.service.ExchangeService;
import com.example.service.ExchangeServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] input = {
                "#1 09:45 BAC sell 240.12 100",
                "#2 09:46 BAC sell 237.45 90",
                "#3 09:47 BAC buy 238.10 110",
                "#4 09:48 BAC buy 237.80 10",
                "#5 09:49 BAC buy 237.80 40",
                "#6 09:50 BAC sell 236.00 50"
        };
        List<Order> orders = createOrder(input);
        ExchangeService exchangeService = new ExchangeServiceImpl();
        for (int i = 0; i < orders.size(); i++) {
            exchangeService.placeOrder(orders.get(i));
        }
        List<OrderResponse> orderResponseList = exchangeService.processOrder();
        for (int i = 0; i < orderResponseList.size(); i++) {
            System.out.println(orderResponseList.get(i));
        }

    }
    private static List<Order> createOrder(String[] input){
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String[] inputs = input[i].split(" ");
            orders.add(new Order(
                    Integer.parseInt(inputs[0].replace("#","")),
                    inputs[1],
                        new Stock(inputs[2],
                                Double.parseDouble(inputs[4]),
                                Integer.parseInt(inputs[5])),
                    inputs[3]));
        }
        return orders;
    }
}
