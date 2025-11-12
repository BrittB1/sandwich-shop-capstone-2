package com.pluralsight.deli.models;

import com.pluralsight.deli.enums.*;

public class Drink extends Product {

    private DrinkSize size;
    private DrinkFlavor flavor;

    public Drink(DrinkSize size, DrinkFlavor flavor) {
        super("Drink");
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(DrinkFlavor flavor) {
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return size.getDisplayName() + " " + flavor.getDisplayName();
    }

    @Override
    public double calculatePrice() {
        return size.getPrice();
    }
}
