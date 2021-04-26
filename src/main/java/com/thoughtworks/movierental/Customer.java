package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals();

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
        return new TextStatement(name, rentals).text();
    }

    public String htmlStatement() {
        return new HtmlStatement(name, rentals).htmlText();
    }
}

