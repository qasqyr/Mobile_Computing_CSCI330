package com.example.inclass_exercise_6_fragments;

public class Drink {
    private String name;
    private String temp;
    private int image;

    public Drink(String name, String temp, int image) {
        this.name = name;
        this.temp = temp;
        this.image = image;
    }

    public static final Drink[] drinks = {
        new Drink("Coca Cola", "Cold", R.drawable.coca_cola),
        new Drink("Tea", "Hot", R.drawable.tea),
        new Drink("Coffee", "Hot", R.drawable.coffee),
        new Drink("Water", "Warm", R.drawable.water),
        new Drink("Milk", "Warm", R.drawable.milk),
        new Drink("Orange Juice", "Cold", R.drawable.orange_juice),
        new Drink("Pepsi", "Cold", R.drawable.pepsi)
    };

    public String getName() {
        return name;
    }

    public String getTemp() {
        return temp;
    }

    public int getImage() {
        return image;
    }
}
