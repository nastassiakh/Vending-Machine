package com.techelevator;

public class Drink extends Snacks{

	public Drink(String location, String name, double price, String type) {
		super(location, name, price, type);
	}

	@Override
	public String makeSound() {
		
		return "Glug, Glug, Yum!";
	}

}
