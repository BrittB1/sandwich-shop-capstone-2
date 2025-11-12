package com.pluralsight.deli.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List <Product> items;

    public Order() {
        this.items = new ArrayList<>();
    }
    public void addItem (Product p) {
        items.add(p);
    }
    public void removeItem (Product p) {
        items.remove(p);
    }
    public List <Product> getItems(){
        return items;
    }
    public double calculateTotal () {
double total = 0;

        for (Product item : items) {
            total += item.calculatePrice();
        }
        return total;
    }
    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();

        details.append("\n----Order Details -----\n");

        if (items.isEmpty()) {
            details.append("No items in order!");
        } else  {
            int itemNumber = 1;
            for (Product item:items) {
                details.append(itemNumber + ". ")
                        .append(item.getDescription())
                        .append(" - $")
                        .append(String.format("%.2f",item.calculatePrice()))
                        .append("\n");
                itemNumber ++;
            }

        }
        details.append("\n Total: $")
                .append(String.format("%.2f", calculateTotal()));

        return details.toString();
    }

    public boolean isValid() {
        return !items.isEmpty();
    }

    public int itemCount() {
        return items.size();
    }

    public void clearOrder() {
        items.clear();
    }
}
