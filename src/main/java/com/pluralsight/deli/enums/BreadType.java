package com.pluralsight.deli.enums;

public enum BreadType {
    WHITE ("White Bread"),
    WHEAT("Wheat Bread"),
    RYE("Rye Bread"),
    WRAP("Tortilla");

    private final String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
