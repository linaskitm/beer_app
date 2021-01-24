package com;

import java.io.Serializable;

public class Beer implements Serializable {
    private String drinkId;
    private String drinkName;
    private String drinkTagline;
    private String drinkDescription;
    private String drinkFirstBrewed;

    public Beer(String drinkId, String drinkName, String drinkTagline, String drinkDescription, String drinkFirstBrewed) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkTagline = drinkTagline;
        this.drinkDescription = drinkDescription;
        this.drinkFirstBrewed = drinkFirstBrewed;
    }

    public Beer(String drinkName, String drinkTagline, String drinkDescription, String drinkFirstBrewed) {
        this.drinkName = drinkName;
        this.drinkTagline = drinkTagline;
        this.drinkDescription = drinkDescription;
        this.drinkFirstBrewed = drinkFirstBrewed;
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

    public String getDrinkTagline() {
        return drinkTagline;
    }

    public void setDrinkTagline(String drinkTagline) {
        this.drinkTagline = drinkTagline;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public String getDrinkFirstBrewed() {
        return drinkFirstBrewed;
    }

    public void setDrinkFirstBrewed(String drinkFirstBrewed) {
        this.drinkFirstBrewed = drinkFirstBrewed;
    }
}
