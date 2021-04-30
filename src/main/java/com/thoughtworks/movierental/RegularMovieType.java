package com.thoughtworks.movierental;

public class RegularMovieType implements MovieType {
    private final int priceCode;

    public RegularMovieType(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    @Override
    public double chargeFor(int daysRented) {
        double amount = 0.0;
        amount += 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    @Override
    public int frequentRenterPointsFor(int daysRented) {
        return 1;
    }
}