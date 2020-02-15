package com.techelevator;

	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class Log {
		
		static File file = new File("Log.txt"); 
		
		public static void writeToLog(String log) throws IOException {
			FileWriter fileWriter = new FileWriter(file, true);
			try (PrintWriter writer = new PrintWriter(fileWriter)) {
				writer.println(log);

			}
		} 
	

}
