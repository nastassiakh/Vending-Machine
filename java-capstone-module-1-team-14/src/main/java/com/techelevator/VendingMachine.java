package com.techelevator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class VendingMachine {
	LocalDateTime localTime;// = new LocalDateTime();
	double totalMoney = 0.00;
	double moneyRemaining = 0.0;
	Change change = new Change();
	Log log = new Log();

	public void run() throws IOException {

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

			while (true) {

				userCodeInput = menue.getCodeFromUser();
				if (snackObjectsMap.containsKey(userCodeInput)) {
					break;
				} else {

					System.out.println("This code is invalid input.");

				}

			}

			if (snackObjectsMap.get(userCodeInput).canPurchase()) {
				snackObjectsMap.get(userCodeInput).purchase();
				//// A1

				userMoney = menue.getMoneyInput();

				System.out.println("Your balance is $" + userMoney);
				System.out.println("");

				totalMoney += userMoney;

				String feedMoneyLog = LocalTime.now() + " c" + LocalDate.now() + "FEED MONEY: " + totalMoney + " "
						+ userMoney + "\n";
				log.writeToLog(feedMoneyLog);

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
			finishTransaction();
		}

	}

	public void finishTransaction() throws IOException {
		String afterChange;
		afterChange = change.getChange(moneyRemaining);
		String changeLog = LocalTime.now() + " " + LocalDate.now() + "GIVE CHANGE: " + afterChange + " "
				+ totalMoney + "\n";
		log.writeToLog(changeLog);
		System.out.println(afterChange);
		System.out.println("");
		totalMoney = 0;
	}

}