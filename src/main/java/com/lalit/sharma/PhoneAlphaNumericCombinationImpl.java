package com.lalit.sharma;

import java.util.ArrayList;
import java.util.Map;

public class PhoneAlphaNumericCombinationImpl implements PhoneAlphaNumericCombination {
	/**
	 * Will compute all the alphanumeric combinations to represent a phone
	 * number. Note: When 'setAlphaMap()' is implemented make this synchronized
	 * 
	 * @param input
	 *            Phone number (greater than zero) for which the alphanumeric
	 *            combinations have to be computed
	 * @return List of string that has all the combinations for the alphanumeric
	 *         representation for the input phone number
	 * @throws IllegalArgumentException
	 *             if number is not a positive integer
	 * 
	 */
	public ArrayList<String> alpaNumericCombinationAllPhoneUS(long input) throws IllegalArgumentException {

		if (input <= 0) {
			throw new IllegalArgumentException("Input must to be a positive integer");
		}
		if (input > PhoneAlphaNumericCombinationRefData.maxInputAllowed) {
			throw new IllegalArgumentException("Input must to be not greater than " + PhoneAlphaNumericCombinationRefData.maxInputAllowed);
		}

		ArrayList<String> outputList = PhoneAlphaNumericCombinationService.alpaNumericCombinationStringForward(input, 
				PhoneAlphaNumericCombinationRefData.alphaStringMapPhoneUS);

		return outputList;
	}

	/**
	 * Will compute given number of alphanumeric combinations to represent a
	 * phone number. Note: Right now it support is limited to US Phone pad till
	 * 'setAlphaMap()' is implemented or mapping for other countries is
	 * implemented
	 * 
	 * @param input
	 *            Phone number for which the combinations are needed
	 * @param start
	 *            Start position of the combination, must be integer greater
	 *            than zero
	 * @param count
	 *            Number of combination starting at the position, must be
	 *            integer greater than zero
	 * @return List of string that has combinations for the alphanumeric
	 *         representation for the input phone number
	 * @throws IllegalArgumentException
	 *             if number is not a positive integer
	 */
	public ArrayList<String> alpaNumericCombinationPartialPhoneUS(long input, int start, int count) throws IllegalArgumentException {

		if (input <= 0) {
			throw new IllegalArgumentException("Input must to be a positive integer");
		}
		if (input > PhoneAlphaNumericCombinationRefData.maxInputAllowed) {
			throw new IllegalArgumentException("Input must to be not greater than " + PhoneAlphaNumericCombinationRefData.maxInputAllowed);
		}

		if (start <= 0) {
			throw new IllegalArgumentException("Start must to be a positive integer");
		}

		if (count <= 0) {
			throw new IllegalArgumentException("Count must to be a positive integer");
		}

		ArrayList<byte[]> outputBytesList = PhoneAlphaNumericCombinationService.alpaNumericCombinationPartial(input, start, count,
				PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);

		ArrayList<String> outputStringList = new ArrayList<String>(outputBytesList.size());
		for(byte[] outputBytes : outputBytesList){
			String outputString = PhoneAlphaNumericCombinationUtil.bytesToAlphaNumeric(outputBytes);
			outputStringList.add(outputString);
		}
		
		return outputStringList;
	}

	/**
	 * Will provide ability to change the digit-to-characters map when
	 * implemented, this is TO DO for now. Note: Need to synchronize the access
	 * to map between methods.
	 * 
	 * @param alphaMap
	 *            Map of alphabet letters for each digit from 0 to 9
	 * @throws UnsupportedOperationException
	 *             This method is placeholder for future enhancement
	 */
	public void setAlphaMap(Map<Integer, String> alphaMap) throws UnsupportedOperationException {
		// TO DO - implement if ability to change the character mapping is
		// needed
		throw new UnsupportedOperationException("setAlphaMap()");
	}

	/**
	 * Maximum number of combinations of digits and letters possible for given
	 * phone number
	 * 
	 * @param input
	 *            Phone number (greater than zero)
	 * @return Number of combinations possible
	 * @throws IllegalArgumentException
	 *             if number is not a positive integer and greater than 9999999999
	 */
	public int maxalpaNumericCombination(long input) throws IllegalArgumentException {
		if (input <= 0) {
			throw new IllegalArgumentException("Input must to be a positive integer");
		}
		
		if (input > PhoneAlphaNumericCombinationRefData.maxInputAllowed) {
			throw new IllegalArgumentException("Input must to be not greater than " + PhoneAlphaNumericCombinationRefData.maxInputAllowed);
		}

		return PhoneAlphaNumericCombinationService.maxCombinationsPossible(input, PhoneAlphaNumericCombinationRefData.alphaNumericMapPhoneUS);
	}
	
}
