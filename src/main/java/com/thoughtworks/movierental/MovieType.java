package com.thoughtworks.movierental;

public interface MovieType {
    int priceCode();

    double chargeFor(int daysRented);

    int frequentRenterPointsFor(int daysRented);
}
