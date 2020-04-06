package com.rani.model;

/**
 * Combo class represents how many quarters, dimes,nickles,pennies
 */
public class Combo {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

// getters and setters for the instance variables
    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }


    public String toString() {

        return this.getPennies() + " Pennies\n" + this.getNickels() + " Nickles\n" + this.getDimes() + " Dimes\n" + this.getQuarters() + " Quarters";
    }
}
