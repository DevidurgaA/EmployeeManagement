package com.theatmo.userinput;

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <p>
 *    Gives the information abut the input formats
 *    used in the entire project
 * </p>
 */
public class UserInputs {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(UserInputs.class);

	/**
	 * <p>
	 *    Used to get the string inputs from the user
	 * <p>
	 * 
	 * @param stringInput
	 */
	public static String getString(final String stringInput) {
		LOGGER.info(stringInput);
		return SCANNER.next().trim();
	}
}
