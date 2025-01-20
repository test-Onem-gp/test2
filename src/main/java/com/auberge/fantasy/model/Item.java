package com.auberge.fantasy.model;

public class Item {
    //fields
    int sellIn ;
    int quality ;
    String name ;

    public Item(int sellIn, int quality, String name) {
        this.sellIn = sellIn;
        this.quality = quality;
        this.name = name;
    }

    public Item() {
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item qualities are " +
                "sellIn =" + sellIn +
                ", quality =" + quality +
                ", name='" + name + '\'' +
                '}';
    }
}
