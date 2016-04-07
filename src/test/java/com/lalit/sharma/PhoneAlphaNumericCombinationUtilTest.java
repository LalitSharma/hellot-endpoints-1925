package com.lalit.sharma;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
* Test for {@link PhoneAlphaNumericCombinationUtil}.
* 
* @author Lalit Sharma
*
*/
public class PhoneAlphaNumericCombinationUtilTest {
	/**
	 * Test for splitting an integer into individual digits
	 */
	@Test
	public void splitDigitsTest() {
		int input = 12304;
		Integer[] expectedOutput = { 1, 2, 3, 0, 4 };

		ArrayList<Integer> outputList = PhoneAlphaNumericCombinationUtil.splitDigits(input);
		Integer[] output  = outputList.toArray(new Integer[outputList.size()]);

		assertTrue(Arrays.equals(expectedOutput, output));
	}

	/**
	 * Test for getting string representing letters for each digit in the number
	 */
	@Test
	public void digitAlphaListTest(){
		Map<Integer, String> letterMap = new HashMap<Integer, String>();
		letterMap.put(0, "");
		letterMap.put(1, "");
		letterMap.put(2, "ABC");
		letterMap.put(9, "WXYZ");
		int input = 120920;
		
		ArrayList<String> outputList = PhoneAlphaNumericCombinationUtil.digitAlphaList(input, letterMap);
		ArrayList<Integer> digitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);
		
		//Length should be same as number of digits in the number
		assertTrue(outputList.size() == digitList.size());
		
		for( int i = 0; i < digitList.size(); ++i){
			int digit = digitList.get(i);
			String output = outputList.get(i);
			String mapValue = letterMap.get(digit);
			
			assertTrue(mapValue.equals(output));
		}
	}
	
	/**
	 * Test for converting byte array containing alphanumeric ASCII values to a string
	 */
	@Test
	public void bytesToAlphaNumericTest(){
		byte[] number = {'1','A','D','0', 'W', '9'};
		String expectedOutput = "1AD0W9";
		
		String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(number);
		
		assertTrue(expectedOutput.equals(output));		
	}

	/**
	 * Test for converting byte array containing alphanumeric ASCII values to a string
	 */
	@Test
	public void bytesToAlphaNumericSkipDigitsTest(){
		byte[] number = {1,'A','D', 0, 'W', 9};
		String expectedOutput = "1AD0W9";
		
		String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumericSkipDigits(number);
		
		assertTrue(expectedOutput.equals(output));		
	}
}
