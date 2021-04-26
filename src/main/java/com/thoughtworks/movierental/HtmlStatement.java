package com.thoughtworks.movierental;

class HtmlStatement {
    private final Rentals rentals;
    private final String customerName;

    public HtmlStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String htmlText() {
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
        return "Amount owed is " + rentals.totalAmount() + "</br>You earned " + rentals.totalFrequentRenterPoints()
                + " frequent renter points</p>";
    }
}
