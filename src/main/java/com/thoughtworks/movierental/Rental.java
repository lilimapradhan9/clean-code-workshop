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
        double amount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }

    int frequentRenterPoints() {
        return isBonusApplicable() ? BONUS_FREQUENT_RENTER_POINTS : BASE_FREQUENT_RENTER_POINTS;
    }

    private boolean isBonusApplicable() {
        return movie.isNewRelease() && getDaysRented() > 1;
    }
}