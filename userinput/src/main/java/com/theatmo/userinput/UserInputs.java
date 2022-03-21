package com.theatmo.userinput;

import java.util.Scanner;

public class UserInputs {

	private static final Scanner SCANNER = new Scanner(System.in);
	
	/**
	 * <p>
	 * Used to get the string inputs from the user 
	 * <p>
	 * 
	 * @param stringInput
	 */
	public static String getString(String stringInput) {
		System.out.println(stringInput);
		return SCANNER.next().trim();

	}
}
