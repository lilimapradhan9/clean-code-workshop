package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
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