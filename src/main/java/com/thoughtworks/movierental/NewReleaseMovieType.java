package com.thoughtworks.movierental;public class NewReleaseMovieType{	public NewReleaseMovieType()	{	}private double newReleaseMovieCharge(int daysRented) {
        double amount;
        amount = 0;
        amount += daysRented * 3;
        return amount;
    }}