package com.thoughtworks.movierental;

public class NewReleaseMovieType implements MovieType {
    private final int priceCode;

    public NewReleaseMovieType(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    public double chargeFor(int daysRented) {
        double amount;
        amount = 0;
        amount += daysRented * 3;
        return amount;
    }

    @Override
    public int frequentRenterPointsFor(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}