package com;

public class Coctail {
    private String drinkId;
    private String drinkName;
    private String drinkTags;
    private String drinkCategory;
    private String drinkGlass;
    private String ingredients1;
    private String ingredients2;
    private String ingredients3;

    public Coctail(String drinkId, String drinkName, String drinkTags, String drinkCategory, String drinkGlass, String ingredients1, String ingredients2, String ingredients3) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkTags = drinkTags;
        this.drinkCategory = drinkCategory;
        this.drinkGlass = drinkGlass;
        this.ingredients1 = ingredients1;
        this.ingredients2 = ingredients2;
        this.ingredients3 = ingredients3;
    }

    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkTags() {
        return drinkTags;
    }

    public void setDrinkTags(String drinkTags) {
        this.drinkTags = drinkTags;
    }

    public String getDrinkCategory() {
        return drinkCategory;
    }

    public void setDrinkCategory(String drinkCategory) {
        this.drinkCategory = drinkCategory;
    }

    public String getDrinkGlass() {
        return drinkGlass;
    }

    public void setDrinkGlass(String drinkGlass) {
        this.drinkGlass = drinkGlass;
    }

    public String getIngredients1() {
        return ingredients1;
    }

    public void setIngredients1(String ingredients1) {
        this.ingredients1 = ingredients1;
    }

    public String getIngredients2() {
        return ingredients2;
    }

    public void setIngredients2(String ingredients2) {
        this.ingredients2 = ingredients2;
    }

    public String getIngredients3() {
        return ingredients3;
    }

    public void setIngredients3(String ingredients3) {
        this.ingredients3 = ingredients3;
    }
}

