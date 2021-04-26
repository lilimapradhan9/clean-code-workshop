package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int frequentRenterPoints;
    private final String customerName;

    public HtmlStatement(List<Rental> rentals, double totalAmount, int frequentRenterPoints, String customerName) {
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.customerName = customerName;
    }

    public String html() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h2>Rental Record for " + customerName + "</h2>";
    }

    private String htmlBody() {
        StringBuilder result = new StringBuilder();
        result.append("<p>");
        rentals.forEach(rental -> result
                .append(rental.getMovie().getTitle())
                .append(": ")
                .append(rental.amount())
                .append("</br>"));

        return result.toString();
    }

    private String htmlFooter() {
        return "Amount owed is " + totalAmount + "</br>You earned " + frequentRenterPoints
                + " frequent renter points</p>";
    }
}
