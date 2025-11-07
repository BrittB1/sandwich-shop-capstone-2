package com.pluralsight.deli.enums;

public enum ChipType {
    PLAIN_POTATO("Potato"),
    BARBECUE("Backyard BBQ"),
    SPICY_CHILI("Sweet 'n' Spicy Chili");

    private final String displayName;

    ChipType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
