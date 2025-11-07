package com.pluralsight.deli.enums;

public enum SandwichSize {
    SMALL("4 in."),
    MEDIUM("8 in."),
    LARGE("12 in.");

    private final String displayName;

    SandwichSize(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
