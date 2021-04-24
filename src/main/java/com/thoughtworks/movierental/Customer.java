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

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    public String textStatement() {
        return new TextStatement(name, rentals, totalAmount(), frequentRenterPoints()).textStatement();
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

