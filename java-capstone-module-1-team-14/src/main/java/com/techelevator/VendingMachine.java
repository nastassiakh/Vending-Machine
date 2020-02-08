package com.techelevator;

import java.util.HashMap;
import java.util.Map;


public class VendingMachine {
	double totalMoney = 0.00;
	double moneyRemaining = 0.0;
	Change change = new Change();

	public void run() {

		Map<String, Snacks> snackObjectsMap = new HashMap<String, Snacks>();
		Inventory inv = new Inventory();
		snackObjectsMap.putAll(inv.getInventory());

		double userMoney;
		Menue menue = new Menue();

		String userCodeInput = "";
		String userInput = menue.getUserInput();
		
		if (userInput.equals("1")) {
			for (Map.Entry<String, Snacks> entry : snackObjectsMap.entrySet()) { // foreach inside of Map
				System.out.println(entry.getValue().toString() + " ");

			}

		} else if (userInput.equals("2")) {

			userCodeInput = menue.getCodeFromUser();

			if (snackObjectsMap.get(userCodeInput).canPurchase()) {
				snackObjectsMap.get(userCodeInput).purchase();
				////
				
				userMoney = menue.getMoneyInput();

				System.out.println("Your balance is $" + userMoney);
				System.out.println("");
				
				
				totalMoney += userMoney;
				
				moneyRemaining = totalMoney - snackObjectsMap.get(userCodeInput).getPrice();

				System.out.println("Your purchase is : " + snackObjectsMap.get(userCodeInput).getName() + " "
						+ snackObjectsMap.get(userCodeInput).getPrice());
				System.out.println("");
				System.out.println("Your remaining balance is $ " + moneyRemaining);
				System.out.println(snackObjectsMap.get(userCodeInput).makeSound() + "  ");
				System.out.println("");

				/////
			} else {
				System.out.println("Sold out");
			}
			

		} else {
			System.exit(1);

		}
		
		if (menue.getUserFinishTransaction()) {
			finishTransaction() ;
		}
	
	}

	public void finishTransaction() {

		System.out.println(change.getChange(moneyRemaining));
		System.out.println("");
		totalMoney = 0;

	}

}