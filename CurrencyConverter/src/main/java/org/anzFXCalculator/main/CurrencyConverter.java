package org.anzFXCalculator.main;

import java.util.Scanner;

import org.anzFXCalculator.BO.Converter;
import org.anzFXCalculator.BO.InputParser;
import org.anzFXCalculator.BO.MyConverterImpl;
import org.anzFXCalculator.BO.MyInputParserImpl;
import org.anzFXCalculator.model.CurrencyUnit;
import org.apache.log4j.Logger;

/**
 * Main Point of Execution for the FXCalculator Program
 * @author SRI ADITYA
 * @version 1.0
 *
 */
public class CurrencyConverter {
	final static Logger logger = Logger.getLogger(CurrencyConverter.class);

	public static void main(String[] args) { 
		logger.debug("-------------------START NEW LOG-------------------------");
		
		int userChoice;
		Scanner in = new Scanner(System.in);

		System.out.println("------------------------------------");
		System.out.println("Welcome to FX Converter Application");
		
		do {
			System.out.println("------------------------------------");
			System.out.println("Sample Input: AUD 100.00 in USD");
			System.out.println("Sample Output: AUD 100.00 = USD 83.71");
			System.out.println("------------------------------------");

			System.out.println("<=== MENU ===> (1) Make a Conversion (2) Exit");
			System.out.println("Enter your choice (1/2): ");
			String choice = in.nextLine();		
			try {
				userChoice = Integer.parseInt(choice);
			} catch (Exception ex) {
				userChoice = 0;
			}
			
			if (userChoice == 1) {
				System.out.println("Enter your input: ");

				String userInput = in.nextLine();
				logger.debug("User has entered: " + userInput);
				
				InputParser myParser = new MyInputParserImpl();
				CurrencyUnit ccyUnit = myParser.parseInput(userInput);
				if(ccyUnit != null) {
					Converter myConverter = new MyConverterImpl();
					String output = myConverter.convert(ccyUnit).toString();
					System.out.println(output);
					logger.debug(output);
				}				
			} else if(userChoice == 2) {
				System.out.println("Good Bye.");
				logger.debug("Good Bye.");
			} else {
				System.out.println("Invalid Option. Try Again! Enter either 1 or 2");
				logger.debug("Invalid Option. Try Again! Enter either 1 or 2");
				userChoice = 1;
			}

		} while (userChoice == 1);

		in.close();
		logger.debug("-------------------END LOG-------------------------");
	}

}
