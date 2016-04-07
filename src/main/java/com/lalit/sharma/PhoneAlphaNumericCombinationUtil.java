package com.lalit.sharma;

import java.util.ArrayList;
import java.util.Map;

/**
 * Utility function to support PhoneNumPermuationImpl
 * 
 * @author Lalit Sharma
 *
 */
public class PhoneAlphaNumericCombinationUtil {
	
	/**
	 * Returns the list of string with each string representing the letter for
	 * the digit in number, e.g. 2="ABC", 9="WXYZ"
	 * 
	 * @param input
	 *            Phone Number for strings representing each letter is needed
	 * @return Array of string with each string represents letter corresponding
	 *         to the digit of input phone number
	 */
	static ArrayList<String> digitAlphaList(long input, Map<Integer, String> digitAlphaMap) {
		ArrayList<String> digitAlphaStrings = new ArrayList<String>();
		ArrayList<Integer> digitList = splitDigits(input);

		for (Integer digit : digitList) {
			digitAlphaStrings.add(digitAlphaMap.get(digit));
		}

		return digitAlphaStrings;
	}

	/**
	 * Converts an integer into an Integer array that has individual digits
	 * 
	 * @param input
	 *            The number for which digits need to be collected
	 * @return Array of Integer that represent all digits that make the number,
	 *         in same order, i.e. 123 = {1,2,3}
	 */
	static ArrayList<Integer> splitDigits(long input) {
		ArrayList<Integer> digits = new ArrayList<Integer>();

		String digitsString = Long.toString(input);
		for (int i = 0; i < digitsString.length(); i++) {
			String subStr = digitsString.substring(i, i + 1);
			digits.add(Integer.parseInt(subStr));
		}

		return digits;
	}
	
	/**
	 * Converts bytes representing the phone number alphanumeric value for digit and letters
	 * @param number ASCII value of alphabet letters A..Z or digits 0..9
	 * @return String representing the phone number
	 */
	static String bytesToAlphaNumeric(byte[] number) {
		StringBuilder alphaNumeric = new StringBuilder();
		for (short n : number) {
			alphaNumeric.append(Character.toChars(n));
		}
		return alphaNumeric.toString();
	}

	/**
	 * Converts bytes representing the phone number alphanumeric value for digit and letters, skips any digits
	 * @param number ASCII value of alphabet letters A..Z or digits 0..9
	 * @return String representing the phone number
	 */
	static String bytesToAlphaNumericSkipDigits(byte[] number) {
		StringBuilder alphaNumeric = new StringBuilder();
		for (short n : number) {
			if (n > 64) {
				alphaNumeric.append(Character.toChars(n));
			} else {
				alphaNumeric.append(n);
			}
		}
		return alphaNumeric.toString();
	}
	
}
