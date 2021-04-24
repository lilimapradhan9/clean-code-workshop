package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private String customerName;
    private List<Rental> rentals;
    private double totalAmount;
    private int totalFrequentRenterPoints;

    public TextStatement(String customerName, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.customerName = customerName;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    public String textStatement() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        StringBuilder result = new StringBuilder();
        rentals.forEach(rental -> result
                .append("\t")
                .append(rental.getMovie().getTitle())
                .append("\t")
                .append(rental.amount())
                .append("\n"));

        return result.toString();
    }

    private String footer() {
        return "Amount owed is " + totalAmount + "\nYou earned " + totalFrequentRenterPoints
                + " frequent renter points";
    }
}
