package com.thoughtworks.movierental;

public class Rental {

    public static final int BASE_FREQUENT_RENTER_POINTS = 1;
    public static final int BONUS_FREQUENT_RENTER_POINTS = 2;
    private int daysRented;
    private Movie movie;

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
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    int frequentRenterPoints() {
        return isBonusApplicable() ? BONUS_FREQUENT_RENTER_POINTS : BASE_FREQUENT_RENTER_POINTS;
    }

    private boolean isBonusApplicable() {
        return movie.isNewRelease() && getDaysRented() > 1;
    }
}