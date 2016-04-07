package com.lalit.sharma;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class PhoneAlphaNumericCombinationServiceTest {

	/**
	 * Tests service algorithm that returns String but builds the combination starting from last digit
	 * 
	 * Scenario : Algorithm with the one that returns combination as String array bu
	 */
	@Test
	public void alpaNumericCombinationStringBackwardTest() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "1" }, 
				{ "101" }, 
				{ "120", "1A0", "1B0", "1C0" }, 
				{ "1209", "120W", "120X", "120Y", "120Z", "1A09", "1A0W", "1A0X", "1A0Y", "1A0Z", "1B09", "1B0W", "1B0X", "1B0Y", "1B0Z", "1C09", "1C0W", "1C0X", "1C0Y", "1C0Z" } };

		for (int i = 0; i < input.length; ++i) {
			ArrayList<String> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationStringBackward(input[i], PhoneAlphaNumericCombinationRefData.digitAlphaMap);
			String[] output = outputList.toArray(new String[outputList.size()]);

			assertTrue(Arrays.equals(expectedOutput[i], output));
		}
	}

	/**
	 * Tests service algorithm that returns String but builds the combination starting from first digit
	 * 
	 * Scenario : Algorithm with the one that returns combination as String array
	 */
	@Test
	public void alpaNumericCombinationStringForwardTest() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "1" }, 
				{ "101" }, 
				{ "120", "1A0", "1B0", "1C0" }, 
				{ "1209", "1A09", "1B09", "1C09", "120W", "1A0W", "1B0W", "1C0W", "120X", "1A0X", "1B0X", "1C0X", "120Y", "1A0Y", "1B0Y", "1C0Y", "120Z", "1A0Z", "1B0Z", "1C0Z" }
		};

		for (int i = 0; i < input.length; ++i) {
			ArrayList<String> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationStringForward(input[i], 
					PhoneAlphaNumericCombinationRefData.alphaStringMapPhoneUS);
			String[] output = outputList.toArray(new String[outputList.size()]);

			assertTrue(Arrays.equals(expectedOutput[i], output));
		}
	}

	/**
	 * Tests service algorithm that returns StringBuilder
	 * 
	 * Scenario : Algorithm with the one that returns combination as StringBuilder array
	 */
	@Test
	public void alpaNumericCombinationStringBuilderTest() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "1" }, 
				{ "101" }, 
				{ "120", "1A0", "1B0", "1C0" }, 
				{ "1209", "1A09", "1B09", "1C09", "120W", "1A0W", "1B0W", "1C0W", "120X", "1A0X", "1B0X", "1C0X", "120Y", "1A0Y", "1B0Y", "1C0Y", "120Z", "1A0Z", "1B0Z", "1C0Z" }
		};

		for (int i = 0; i < input.length; ++i) {
			ArrayList<StringBuilder> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationStringBuilder(input[i], 
					PhoneAlphaNumericCombinationRefData.alphaStringMapPhoneUS);
			
			StringBuilder[] outputs = outputList.toArray(new StringBuilder[outputList.size()]);

			for(int j = 0; j < outputs.length; j++){
				assertTrue(outputs[j].toString().equals(expectedOutput[i][j]));
			}
		}
	}

	/**
	 * Tests service algorithm that returns array of Bytes
	 * 
	 * Scenario : Algorithm with the one that returns combination a bytes
	 */
	@Test
	public void alpaNumericCombinationBytesTest() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "1" }, 
				{ "101" }, 
				{ "120", "1A0", "1B0", "1C0" }, 
				{ "1209", "1A09", "1B09", "1C09", "120W", "1A0W", "1B0W", "1C0W", "120X", "1A0X", "1B0X", "1C0X", "120Y", "1A0Y", "1B0Y", "1C0Y", "120Z", "1A0Z", "1B0Z", "1C0Z" }
		};

		for (int i = 0; i < input.length; ++i) {
			ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationBytes(input[i], 
					PhoneAlphaNumericCombinationRefData.alphaMapPhoneUS);
			
			for(int j = 0; j < outputList.size(); j++){
				String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumericSkipDigits(outputList.get(j));
				
				assertTrue(output.equals(expectedOutput[i][j]));
			}
		}
	}

	/**
	 * Tests service algorithm that returns array of Bytes, but compare with data returned by String Forward method
	 * 
	 * Scenario : Compare all output from String algorithm with the one that returns combination a bytes
	 */
	@Test
	public void alpaNumericCombinationBytesTest2() {
		long input = 2478091635L;
		ArrayList<String> expectedOutputs = PhoneAlphaNumericCombinationService.alpaNumericCombinationStringForward(input, 
				PhoneAlphaNumericCombinationRefData.alphaStringMapPhoneUS);
		ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationBytes(input, 
				PhoneAlphaNumericCombinationRefData.alphaMapPhoneUS);

		assertTrue(expectedOutputs.size() == outputList.size());
		
		for (int i = 0; i < outputList.size(); ++i) {
			String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumericSkipDigits(outputList.get(i));
			String expectedOutput = expectedOutputs.get(i);
			assertTrue(output.equals(expectedOutput));
		}
	}

	/**
	 * Tests getting partial combinations starting after first and ending before last
	 * 
	 * Scenarios : Get part of combination
	 * 		End is smaller than number of combination possible
	 * 		Start is after beginning
	 */
	@Test
	public void alpaNumericCombinationPartialRangeTest() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "" }, 
				{ "" }, 
				{ "1A0", "1B0" }, 
				{ "1A09", "1B09"}
		};

		for (int i = 0; i < input.length; ++i) {
			ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input[i], 2, 2,
					PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);
			
			for(int j = 0; j < outputList.size(); j++){
				String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(outputList.get(j));
				
				assertTrue(output.equals(expectedOutput[i][j]));
			}
		}
	}
	
	/**
	 * Tests getting partial combinations - all starting after first 
	 * 
	 * Scenarios : 
	 * 		End is larger than number of combination possible
	 * 		Start is after beginning
	 */
	@Test
	public void alpaNumericCombinationPartialRangeTest2() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "" }, 
				{ "" }, 
				{ "1A0", "1B0", "1C0" }, 
				{ "1A09", "1B09", "1C09", 
					"120W", "1A0W", "1B0W", "1C0W", 
					"120X", "1A0X", "1B0X", "1C0X", 
					"120Y", "1A0Y", "1B0Y", "1C0Y", 
					"120Z", "1A0Z", "1B0Z", "1C0Z" }
		};

		for (int i = 0; i < input.length; ++i) {
			ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input[i], 2, Integer.MAX_VALUE,
					PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);
			
			for(int j = 0; j < outputList.size(); j++){
				String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(outputList.get(j));
				
				assertTrue(output.equals(expectedOutput[i][j]));
			}
		}
	}

	
	/**
	 * Tests service algorithm that returns array of Bytes
	 * 
	 * Scenarios : Digits that have letter and without letters
	 */
	@Test
	public void alpaNumericCombinationPartialTest() {
		long[] input = { 1, 101, 120, 1209 };
		String[][] expectedOutput = { 
				{ "1" }, 
				{ "101" }, 
				{ "120", "1A0", "1B0", "1C0" }, 
				{ "1209", "1A09", "1B09", "1C09", 
					"120W", "1A0W", "1B0W", "1C0W", 
					"120X", "1A0X", "1B0X", "1C0X", 
					"120Y", "1A0Y", "1B0Y", "1C0Y", 
					"120Z", "1A0Z", "1B0Z", "1C0Z" }
		};

		for (int i = 0; i < input.length; ++i) {
			ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input[i], 1, Integer.MAX_VALUE,
					PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);
			
			for(int j = 0; j < outputList.size(); j++){
				String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(outputList.get(j));
				
				assertTrue(output.equals(expectedOutput[i][j]));
			}
		}
	}

	
	/**
	 * Tests service algorithm that returns array of Bytes, but compare with data returned by String Forward method
	 * 
	 * Scenario : Compare all output from String algorithm with the one that gets combination at specific position
	 */
	@Test
	public void alpaNumericCombinationPartialTest2() {
		long input = 2478091635L;
		ArrayList<String> expectedOutputs = PhoneAlphaNumericCombinationService.alpaNumericCombinationStringForward(input, 
				PhoneAlphaNumericCombinationRefData.alphaStringMapPhoneUS);
		ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input, 1, Integer.MAX_VALUE,
				PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);

		assertTrue(expectedOutputs.size() == outputList.size());
		
		for (int i = 0; i < outputList.size(); ++i) {
			String output = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(outputList.get(i));
			String expectedOutput = expectedOutputs.get(i);
			assertTrue(output.equals(expectedOutput));
		}
	}
	
	/**
	 * Tests service algorithm that returns array of Bytes
	 * 
	 * Scenario: Start larger than End
	 */
	@Test
	public void alpaNumericCombinationPartialTest3() {
		long input = 2478091635L;
		
		ArrayList<byte[]> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input, Integer.MAX_VALUE, 1,
				PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);

		assertTrue(0 == outputList.size());
	}

	
	/**
	 * Test getting combination at a specific position
	 */
	@Test
	public void alpaNumericIntegerAtTest(){
		long[] input = 				{ 1,  101,   120,   123,   1209,   67,   678,   56789,   9999999999L,  9999999999L};
		int[] at =     				{ 1,  1,     3,     8,     19,     20,   61,    220,     9765624,      9765625};
		String[] expectedOutputs = 	{"1","101", "1B0", "1CD", "1B0Z", "OS", "67V", "LNRU9", "YZZZZZZZZZ", "ZZZZZZZZZZ"};
		for (int i = 0; i < input.length; ++i) {
			byte [] output = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input[i], at[i], 1, 
					PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS).get(0);
			String outputString = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(output);
			String expectedOutput = expectedOutputs[i];
			
			assertTrue(outputString.equals(expectedOutput));
		}
	}

	
	/**
	 * Test the maximum combinations possible count
	 */
	@Test
	public void maxCombinationsPossibleTest(){
		long[] input =         { 1, 101, 120, 1209, 9999999999L};
		int[] expectedOutput = { 1, 1,   4,   20,   9765625};
		
		for(int i = 0; i < input.length; ++i){
			int output = PhoneAlphaNumericCombinationService.maxCombinationsPossible(input[i], 
					PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);
			
			assertTrue(output == expectedOutput[i]);
		}
	}
}
