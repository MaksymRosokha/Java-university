package com.rosokha.task3;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, Double> items;
    private Double totalPrice = 0.0;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(String item, double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        items.put(item, price);
        totalPrice += price;
    }

    public void removeItem(String item) {
        Double price = items.get(item);
        items.remove(item);
        totalPrice -= price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void clear() {
        items.clear();
        totalPrice = 0.0;
    }

    public Map<String, Double> getItems() {
        return items;
    }
}
