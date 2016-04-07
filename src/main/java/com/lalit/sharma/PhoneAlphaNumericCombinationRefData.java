package com.lalit.sharma;

import java.util.HashMap;
import java.util.Map;

public class PhoneAlphaNumericCombinationRefData {
	
	static final long maxInputAllowed = 9999999999L;
	
	/**
	 * Letters for US Phone pad
	 */
	static final byte[][] alphaMapPhoneUS = { 
		{}, 					//Letters for #  0
		{}, 					//Letters for #  1
		{ 'A', 'B', 'C' }, 		//Letters for #  2
		{ 'D', 'E', 'F' }, 		//Letters for #  3
		{ 'G', 'H', 'I' }, 		//Letters for #  4
		{ 'J', 'K', 'L' }, 		//Letters for #  5
		{ 'M', 'N', 'O' }, 		//Letters for #  6
		{ 'P', 'Q', 'R', 'S' }, //Letters for #  7
		{ 'T', 'U', 'V' }, 		//Letters for #  8
		{ 'W', 'X', 'Y', 'Z' } 	//Letters for #  9
		};

	/**
	 * Digit and letters for US Phone pad
	 */
	static final byte[][] alphaNumericMapPhoneUS = { 
		{ '0' }, 					//Digit and letters for #  0
		{ '1' }, 					//Digit and letters for #  1
		{ '2', 'A', 'B', 'C' }, 	//Digit and letters for #  2
		{ '3', 'D', 'E', 'F' }, 	//Digit and letters for #  3
		{ '4', 'G', 'H', 'I' }, 	//Digit and letters for #  4
		{ '5', 'J', 'K', 'L' }, 	//Digit and letters for #  5
		{ '6', 'M', 'N', 'O' }, 	//Digit and letters for #  6
		{ '7', 'P', 'Q', 'R', 'S' },//Digit and letters for #  7
		{ '8', 'T', 'U', 'V' }, 	//Digit and letters for #  8
		{ '9', 'W', 'X', 'Y', 'Z' } //Digit and letters for #  9
		};

	static final String[][] alphaStringMapPhoneUS = { 
		{}, 					//Letters for #  0
		{}, 					//Letters for #  1
		{ "A", "B", "C" }, 		//Letters for #  2
		{ "D", "E", "F" }, 		//Letters for #  3
		{ "G", "H", "I" }, 		//Letters for #  4
		{ "J", "K", "L" }, 		//Letters for #  5
		{ "M", "N", "O" }, 		//Letters for #  6
		{ "P", "Q", "R", "S" }, //Letters for #  7
		{ "T", "U", "V" }, 		//Letters for #  8
		{ "W", "X", "Y", "Z" } 	//Letters for #  9
		};
	
	// TO DO - If multiple mapping to letter is to be supported, make this
	// member variable and use 'setAlphaMap()' before getting the combinations
	public static final Map<Integer, String> digitAlphaMap = new HashMap<Integer, String>();

	// Mapping of phone number digits on US phone, adding entry for digits that
	// do not have mapping so that null check is not required in the code
	static {
		digitAlphaMap.put(0, "");
		digitAlphaMap.put(1, "");
		digitAlphaMap.put(2, "ABC");
		digitAlphaMap.put(3, "DEF");
		digitAlphaMap.put(4, "GHI");
		digitAlphaMap.put(5, "JKL");
		digitAlphaMap.put(6, "MNO");
		digitAlphaMap.put(7, "PQRS");
		digitAlphaMap.put(8, "TUV");
		digitAlphaMap.put(9, "WXYZ");
	}
}
