package com.thoughtworks.movierental;

public class TextStatement {
    private final String customerName;
    private final Rentals rentals;

    public TextStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String text() {
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
        return "Amount owed is " + rentals.totalAmount() + "\nYou earned " + rentals.totalFrequentRenterPoints()
                + " frequent renter points";
    }
}
