package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String body() {
        StringBuilder result = new StringBuilder();
        for (Rental each : rentals) {
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.amount()).append("\n");
        }
        return result.toString();
    }

    private String footer() {
        return "Amount owed is " + totalAmount() + "\nYou earned " + frequentRenterPoints()
                + " frequent renter points";
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

    private int frequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}

