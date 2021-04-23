package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String textStatement() {
        return header() + body() + footer();
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
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
        return "Amount owed is " + totalAmount() + "\nYou earned " + frequentRenterPoints()
                + " frequent renter points";
    }

    private String htmlHeader() {
        return "<h2>Rental Record for " + getName() + "</h2>";
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
        return "Amount owed is " + totalAmount() + "</br>You earned " + frequentRenterPoints()
                + " frequent renter points</p>";
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

    private int frequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}

