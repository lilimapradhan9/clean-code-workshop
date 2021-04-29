package com.thoughtworks.movierental;

public class Rental {

    public static final int BASE_FREQUENT_RENTER_POINTS = 1;
    public static final int BONUS_FREQUENT_RENTER_POINTS = 2;
    private final int daysRented;
    private final Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount() {
        return movie.chargeFor(movie.getPriceCode(), daysRented);
    }

    int frequentRenterPoints() {
        return movie.frequentRenterPointsFor(daysRented);
    }
}