package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class RentalTest {
    @Test
    public void amountForRegularMovie() {
        Rental rental = new Rental(new Movie("REgular", Movie.REGULAR), 4);

        double amount = rental.amount();

        Assert.assertEquals(5.0, amount, 0.0);
    }

    @Test
    public void amountForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("New Release", Movie.NEW_RELEASE), 4);

        double amount = rental.amount();

        Assert.assertEquals(12, amount, 0.0);
    }

    @Test
    public void amountForChildrenMovie() {
        Rental rental = new Rental(new Movie("Children", Movie.CHILDRENS), 4);

        double amount = rental.amount();

        Assert.assertEquals(3.0, amount, 0.0);
    }

    @Test
    public void amountForUnsupportedMovie() {
        Rental rental = new Rental(new Movie("REgular", 4), 4);

        double amount = rental.amount();

        Assert.assertEquals(0.0, amount, 0.0);
    }

    @Test
    public void frequentRenterPointsForRegularMovie() {
        Rental rental = new Rental(new Movie("REgular", Movie.REGULAR), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        Assert.assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("New Release", Movie.NEW_RELEASE), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        Assert.assertEquals(2, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForChildrenMovie() {
        Rental rental = new Rental(new Movie("Children", Movie.CHILDRENS), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        Assert.assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void frequentRenterPointsForUnsupportedMovie() {
        Rental rental = new Rental(new Movie("REgular", 4), 4);

        int frequentRenterPoints = rental.frequentRenterPoints();

        Assert.assertEquals(1, frequentRenterPoints);
    }
}
