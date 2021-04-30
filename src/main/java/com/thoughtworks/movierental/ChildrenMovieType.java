package com.thoughtworks.movierental;

public class ChildrenMovieType implements MovieType {
    private final int priceCode;

    public ChildrenMovieType(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    public double chargeFor(int daysRented) {
        double amount;
        amount = 0;
        amount += 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    @Override
    public int frequentRenterPointsFor(int daysRented) {
        return 1;
    }
}