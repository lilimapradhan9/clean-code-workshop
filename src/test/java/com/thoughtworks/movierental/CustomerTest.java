package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void statementForCustomerWithRegularRental() {
        Customer customer = new Customer("Dave");
        customer.addRental(new Rental(new Movie("ABC", 0), 2));

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Dave\n" +
                "\tABC\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statementForCustomerWithRegularRentalMoreThan2Days() {
        Customer customer = new Customer("Dave");
        customer.addRental(new Rental(new Movie("ABC", 0), 4));

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Dave\n" +
                "\tABC\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statementForCustomerWithNewReleaseRental() {
        Customer customer = new Customer("Dave");
        customer.addRental(new Rental(new Movie("ABC", 1), 5));

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Dave\n" +
                "\tABC\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void statementForCustomerWithChildrenRental() {
        Customer customer = new Customer("Dave");
        customer.addRental(new Rental(new Movie("ABC", 2), 2));

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Dave\n" +
                "\tABC\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statementForCustomerWithChildrenRentalMoreThan3days() {
        Customer customer = new Customer("Dave");
        customer.addRental(new Rental(new Movie("ABC", 2), 5));

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Dave\n" +
                "\tABC\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void statementForCustomerWithMultipleRentals() {
        Customer customer = new Customer("Dave");
        customer.addRental(new Rental(new Movie("ABC", 2), 5));
        customer.addRental(new Rental(new Movie("DEF", 1), 3));
        customer.addRental(new Rental(new Movie("PQR", 0), 2));

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Dave\n" +
                "\tABC\t4.5\n" +
                "\tDEF\t9.0\n" +
                "\tPQR\t2.0\n" +
                "Amount owed is 15.5\n" +
                "You earned 4 frequent renter points", statement);
    }
}