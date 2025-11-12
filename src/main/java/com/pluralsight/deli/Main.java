package com.pluralsight.deli;


import com.pluralsight.deli.enums.ChipType;
import com.pluralsight.deli.enums.DrinkFlavor;
import com.pluralsight.deli.enums.DrinkSize;
import com.pluralsight.deli.models.Chips;
import com.pluralsight.deli.models.Drink;
import com.pluralsight.deli.models.Order;

public class Main {
    public static void main(String[] args) {

        Order order = new Order();

        order.addItem(new Chips(ChipType.CHEESY));

    }
}

