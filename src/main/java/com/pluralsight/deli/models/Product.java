package com.pluralsight.deli.models;

import com.pluralsight.deli.interfaces.Displayable;
import com.pluralsight.deli.interfaces.Priceable;

public abstract class Product implements Priceable,Displayable {

   protected String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
