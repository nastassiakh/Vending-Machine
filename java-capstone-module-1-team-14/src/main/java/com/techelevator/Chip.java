package com.techelevator;

public class Chip extends Snacks{
	
	
	public Chip(String location, String name, double price, String type) {
		super(location, name, price, type);
	}


	@Override
	public String makeSound() {
		return  "Crunch,Crunch, Yum!";
	}





	
	
	
	
}
