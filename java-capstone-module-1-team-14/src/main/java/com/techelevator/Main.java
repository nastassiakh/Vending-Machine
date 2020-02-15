package com.techelevator;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		VendingMachine vm = new  VendingMachine();
		
		while (true) {
			vm.run();
		}
	}
	
	

}
