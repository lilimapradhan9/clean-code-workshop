package com.thoughtworks.movierental;public class ChildrenMovieType{	public ChildrenMovieType()	{	}private double childrenMovieCharge(int daysRented) {
        double amount;
        amount = 0;
        amount += 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }}