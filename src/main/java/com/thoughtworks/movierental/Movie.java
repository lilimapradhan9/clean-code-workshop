package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    private MovieType movieType;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.movieType = movieTypeFor(priceCode);
    }

    @Deprecated
    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public int getPriceCode() {
        return movieType.priceCode();
    }

    public void setPriceCode(int arg) {
        this.movieType = movieTypeFor(arg);
    }

    public String getTitle() {
        return title;
    }

    boolean isNewRelease() {
        return movieType.priceCode() == NEW_RELEASE;
    }

    double chargeFor(int priceCode, int daysRented) {
        return movieType.chargeFor(daysRented);
    }

    int frequentRenterPointsFor(int daysRented) {
        return movieType.frequentRenterPointsFor(daysRented);
    }

    private MovieType movieTypeFor(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                return new RegularMovieType(priceCode);
            case NEW_RELEASE:
                return new NewReleaseMovieType(priceCode);
            case CHILDRENS:
                return new ChildrenMovieType(CHILDRENS);
            default:
                return new InvalidMovieType(priceCode);
        }
    }
}