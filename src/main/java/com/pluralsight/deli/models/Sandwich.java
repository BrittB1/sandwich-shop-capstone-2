package com.pluralsight.deli.models;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {

    private SandwichSize size;
    private BreadType breadType;
    private List<MeatType> meat;
    private boolean hasExtraMeat;
    private List<CheeseType> cheese;
    private boolean hasExtraCheese;
    private List <StandardTopping> topping;
    private List <SauceType> sauce;
    private boolean toasted;

public Sandwich(SandwichSize size,BreadType breadType) {
    super("Sandwich");
    this.size = size;
    this.breadType = breadType;
    this.meat = new ArrayList<>();
    this.cheese = new ArrayList<>();
    this.topping = new ArrayList<>();
    this.sauce = new ArrayList<>();
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

    public List<CheeseType> getCheese() {
        return cheese;
    }

    public void setCheese(List<CheeseType> cheese) {
        this.cheese = cheese;
    }

    public boolean isHasExtraCheese() {
        return hasExtraCheese;
    }

    public void setHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public List<StandardTopping> getTopping() {
        return topping;
    }

    public void setTopping(List<StandardTopping> topping) {
        this.topping = topping;
    }

    public List<SauceType> getSauce() {
        return sauce;
    }

    public void setSauce(List<SauceType> sauce) {
        this.sauce = sauce;
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
    this.cheese.add(cheese);
    }
    public void addToppings (StandardTopping topping){
    this.topping.add(topping);
    }
    public void addSauces (SauceType sauce){
    this.sauce.add(sauce);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
