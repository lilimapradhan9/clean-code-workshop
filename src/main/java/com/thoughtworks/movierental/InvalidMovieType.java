package com.thoughtworks.movierental;

public class InvalidMovieType implements MovieType{
    private final int priceCode;

    public InvalidMovieType(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    @Override
    public double chargeFor(int daysRented) {
        return 0;
    }

    @Override
    public int frequentRenterPointsFor(int daysRented) {
        return 1;
    }
}
