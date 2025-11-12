package com.pluralsight.deli.models;

import com.pluralsight.deli.enums.ChipType;

public class Chips extends Product {

    private ChipType type;

    public Chips(ChipType type) {
        super("Chips");
        this.type = type;
    }

    public ChipType getType() {
        return type;
    }

    public void setType(ChipType type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return type.getDisplayName() + "Chips";
    }
    @Override
    public double calculatePrice() {
        return 1.50;
    }
}
