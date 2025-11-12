package com.pluralsight.deli.models;

import com.pluralsight.deli.enums.*;
import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {

    private SandwichSize size;
    private BreadType breadType;
    private List<MeatType> meat;
    private boolean hasExtraMeat;
    private List<CheeseType> cheeses;
    private boolean hasExtraCheese;
    private List<StandardTopping> toppings;
    private List<SauceType> sauces;
    private boolean toasted;

    public Sandwich(SandwichSize size, BreadType breadType) {
        super("Sandwich");
        this.size = size;
        this.breadType = breadType;
        this.meat = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.hasExtraMeat = false;
        this.hasExtraCheese = false;
        this.toasted = false;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public List<MeatType> getMeat() {
        return meat;
    }

    public void setMeat(List<MeatType> meat) {
        this.meat = meat;
    }

    public boolean isHasExtraMeat() {
        return hasExtraMeat;
    }

    public void setHasExtraMeat(boolean hasExtraMeats) {
        this.hasExtraMeat = hasExtraMeats;
    }

    public List<CheeseType> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<CheeseType> cheeses) {
        this.cheeses = cheeses;
    }

    public boolean isHasExtraCheese() {
        return hasExtraCheese;
    }

    public void setHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public List<StandardTopping> getTopping() {
        return toppings;
    }

    public void setTopping(List<StandardTopping> topping) {
        this.toppings = topping;
    }

    public List<SauceType> getSauces() {
        return sauces;
    }

    public void setSauces(List<SauceType> sauces) {
        this.sauces = sauces;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addMeat(MeatType meat) {
        this.meat.add(meat);
    }

    public void addCheese(CheeseType cheese) {
        this.cheeses.add(cheese);
    }

    public void addToppings(StandardTopping topping) {
        this.toppings.add(topping);
    }

    public void addSauces(SauceType sauce) {
        this.sauces.add(sauce);
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();

        description.append(size.getDisplayName()).append(" ").append(breadType.getDisplayName()).append(" Sandwich");

        if (toasted) {
            description.append(" - Toasted");
        }
        if (!meat.isEmpty()) {
            description.append("\n Meats: ");
        }
        for (int i = 0; i < meat.size(); i++) {
            description.append(meat.get(i).getDisplayName());
            if (i < meat.size() - 1) {
                description.append(", ");
            }
        }
        if (hasExtraMeat) {
            description.append(" (Xtra Meat)");
        }
        if (!cheeses.isEmpty()) {
            description.append("\n Cheeses: ");

            for (int i = 0; i < cheeses.size(); i++) {
                description.append(cheeses.get(i).getDisplayName());
                if (i < cheeses.size() - 1) {
                    description.append(", ");
                }
            }
            if (hasExtraCheese) {
                description.append(" (Xtra Cheese)");
            }
        }

        if (!toppings.isEmpty()) {
            description.append("\n Toppings: ");

            for (int i = 0; i < toppings.size(); i++) {
                description.append(toppings.get(i).getDisplayName());
                if (i < toppings.size() - 1) {
                    description.append(", ");
                }
            }
        }
        if (!sauces.isEmpty()) {
            description.append("\n Sauces: ");
            for (int i = 0; i < sauces.size(); i++) {
                description.append(sauces.get(i).getDisplayName());
                if (i < sauces.size() - 1) {
                    description.append(", ");
                }
            }
        }
        return description.toString();
    }

    @Override
    public double calculatePrice() {
    double totalPrice = 0.0;

    totalPrice += getSize().getBasePrice();

    totalPrice += meat.size() * size.getMeatPrice();

    if (hasExtraMeat && !meat.isEmpty()){
        totalPrice += size.getExtraMeatPrice();
    }
    totalPrice += cheeses.size() * size.getCheesePrice();

    if (hasExtraCheese && !cheeses.isEmpty()) {
        totalPrice += size.getExtraCheesePrice();
    }
        return totalPrice;
    }

}
