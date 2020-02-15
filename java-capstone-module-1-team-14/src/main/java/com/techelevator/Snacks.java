package com.techelevator;

public abstract class Snacks {
	private String name;
	private String location;
	private double price;
	private String type;
	private int quantity = 5;
	
	
	public Snacks(String location, String name, double price, String type) {
		this.price = price;
		this.name = name;
		this.location = location;
		this.type = type;

	}


	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public double getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public abstract  String makeSound() ;
	
	public boolean canPurchase() {
		if(this.getQuantity() >= 1) {
			return true;
		}
		return false;
	}
	
	public void purchase() {
		
		this.quantity --;
	}


	@Override
	public String toString() {

		
		return String.format("|%-25s|%-8s|%-5.2f|%-7s|%-8d", name, location, price, type, quantity);
//		return "name = " + name + ",\tlocation = " + location + ",\tprice = " + price + ",\ttype = " + type + ",\tquantity = "
//				+ quantity;

	}


	

}
