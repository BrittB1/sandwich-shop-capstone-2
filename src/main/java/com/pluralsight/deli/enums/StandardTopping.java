package com.pluralsight.deli.enums;

public enum StandardTopping {
    LETTUCE("Lettuce"),
    PEPPERS("Peppers"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALAPENOS("Jalapenos"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACAMOLE("Guacamole"),
    MUSHROOMS("Mushrooms");

    private final String displayName;

    StandardTopping(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
