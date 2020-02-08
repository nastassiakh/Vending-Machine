package com.techelevator;

public class Change {
	
	public String getChange(double moneyRemaining) {
		 
		String result = "";
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		
		int qCount = 0;
		int dCount = 0;
		int nCount = 0;
		
		while(moneyRemaining >= quarter) {
			qCount++;
			moneyRemaining -= quarter;
			
		}
			
		while(moneyRemaining >= dime) {
			dCount++;
			moneyRemaining -= dime;
		}
		
		while(moneyRemaining >= nickel) {
			nCount++;
			moneyRemaining -= nickel;
			
		}
		
		result = "Your Change is " +qCount+" Quarters, "+dCount+" Dimes, "+ nCount +" Nickels";
	
		
		return result;
	}

}
