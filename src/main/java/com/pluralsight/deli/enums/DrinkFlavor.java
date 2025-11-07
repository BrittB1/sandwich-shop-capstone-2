package com.pluralsight.deli.enums;

public enum DrinkFlavor {

    WATER("Water"),
    GENERIC_COLA("Cola Soda"),
    GENERIC_ORANGE("Orange Soda"),
    PINEAPPLE_COCONUT("Tropical Wave Soda"),
    STRAWBERRY_CREAM("Strawberry Cream Soda");

    private final String displayName;

    DrinkFlavor(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
