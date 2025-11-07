package com.pluralsight.deli.enums;

public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLAND("Thousand Island"),
    VINAIGRETTE("Vinaigrette");

    private final String displayName;

    SauceType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
