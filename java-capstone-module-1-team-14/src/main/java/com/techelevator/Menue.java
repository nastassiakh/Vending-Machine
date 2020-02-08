package com.techelevator;

import java.util.Scanner;

public class Menue {
	Scanner scan = new Scanner(System.in);

	public String getUserInput() {

		System.out.println("Please, enter (1)to Display Vending Machine Items (2)to Purchase (3)to Exit");
		String userInput = scan.nextLine();
		return userInput;
	}

	public String getCodeFromUser() {
	
		 System.out.println("Please, type the code of product that you want to buy(ex. A1) ");
		 String userCodeInput = scan.nextLine();
		
		 return userCodeInput;

	}

	public double getMoneyInput() {

		double userMoneySum = 0;
		while (true) {
			System.out.println("Please, feed money into the machine in valid whole dollar amounts($1, $2, $5, $10)");
			String userInputInString = scan.nextLine();
			double userMoney = Double.parseDouble(userInputInString);

			System.out.println("Do you want to add more money (Y/N) ?");
			userInputInString = scan.nextLine();

			userMoneySum += userMoney;
			if (userInputInString.contains("N") || userInputInString.contains("n")) {
				break;
			}
			
//			else if(userInputInString.contains("Y") || userInputInString.contains("y")) {
//				continue;
//			}else {
//				System.out.println("please Enter A valid selection  ");
//			}

		}
		return userMoneySum;

	}
	
	public boolean getUserFinishTransaction() {
		System.out.println("Would you like to complete transaction (Y/N)?");
		String userInputInString = scan.nextLine();
		
		if (userInputInString.contains("Y") || userInputInString.contains("y")) {
			
			return true;
		}
		return false;
		
	}

}
