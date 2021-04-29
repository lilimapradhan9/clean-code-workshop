package com.thoughtworks.movierental;public class RegularMovieType{	public RegularMovieType()	{	}private double regularMovieCharge(int daysRented) {
        double amount = 0.0;
        amount += 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }}