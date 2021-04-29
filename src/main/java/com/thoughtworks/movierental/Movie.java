package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    boolean isNewRelease() {
        return priceCode == NEW_RELEASE;
    }

    double chargeFor(int priceCode, int daysRented) {
        switch (priceCode) {
            case REGULAR:
                return regularMovieCharge(daysRented);
            case NEW_RELEASE:
                return newReleaseMovieCharge(daysRented);
            case CHILDRENS:
                return childrenMovieCharge(daysRented);
        }
        return 0;
    }

    private double childrenMovieCharge(int daysRented) {
        double amount;
        amount = 0;
        amount += 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    private double newReleaseMovieCharge(int daysRented) {
        double amount;
        amount = 0;
        amount += daysRented * 3;
        return amount;
    }

    private double regularMovieCharge(int daysRented) {
        double amount = 0.0;
        amount += 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    int frequentRenterPointsFor(int daysRented) {
        return isNewRelease() && daysRented > 1 ? Rental.BONUS_FREQUENT_RENTER_POINTS : Rental.BASE_FREQUENT_RENTER_POINTS;
    }
}