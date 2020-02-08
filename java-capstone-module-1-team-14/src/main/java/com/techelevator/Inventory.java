package com.techelevator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {


	private String fileName = "vendingMachine.csv";
	private File myFile = new File(fileName);//object of file


    Map<String, Snacks> snackObjectsMap = new HashMap<String, Snacks>(); //empty map with String and Object
			
	
	
	public  Map<String, Snacks> getInventory() { //method
		
		try{
		 Scanner scan = new Scanner(myFile ); //scanner checking my file
		
		while (scan.hasNextLine()) {
			String[] line = scan.nextLine().split("\\|");	
			String location = line[0];
			String name = line[1];
			String  type = line[3];
			double price = Double.parseDouble(line[2]);
			
			if(type.equals("Chip")) {
				Snacks object = new Chip(location, name, price, type);
				snackObjectsMap.put(location, object);
			}else  if(type.equals("Candy")) {
				Snacks object = new Candy(location, name, price, type);
				snackObjectsMap.put(location, object);
			}else if (type.equals("Drink")) {
				Snacks object = new Drink(location, name, price, type);
				snackObjectsMap.put(location, object);
			}else if (type.equals("Gum")) {
				Snacks object = new Gum(location, name, price, type);
				snackObjectsMap.put(location, object);
			}}		
	
		}catch(Exception e){
			
		}
		return snackObjectsMap;
	}
			

	
	
	
}

