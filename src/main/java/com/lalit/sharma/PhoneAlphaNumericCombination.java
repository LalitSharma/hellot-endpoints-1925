package com.lalit.sharma;

import java.util.ArrayList;
import java.util.Map;

/**
 * Interface for getting all the alphanumeric combination for given phone number.
 * 
 * @author Lalit Sharma
 *
 */
public interface PhoneAlphaNumericCombination {

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
	 *             if number is not a positive integer or greater than 9999999999
	 * 
	 */
	public ArrayList<String> alpaNumericCombinationAllPhoneUS(long input) throws IllegalArgumentException;


	/**
	 * Will compute given number of alphanumeric combinations to represent a phone
	 * number. Note: Right now it support is limited to US Phone pad
	 * 
	 * @param input Phone number for which the combinations are needed
	 * @param start Start position of the combination, must be integer greater than zero
	 * @param count Number of combination starting at the position, must be integer greater than zero
	 * @return List of string that has combinations for the alphanumeric
	 *         representation for the input phone number
	 * @throws IllegalArgumentException
	 *             if number is not a positive integer or greater than 9999999999
	 */
	public ArrayList<String> alpaNumericCombinationPartialPhoneUS(long input, int start, int count) throws IllegalArgumentException;
	
	/**
	 * Maximum number of combinations of digits and letters possible for given
	 * phone number
	 * 
	 * @param input
	 *            Phone number (greater than zero) 
	 * @return Number of combinations possible
	 * @throws IllegalArgumentException
	 *             if number is not a positive integer or greater than 9999999999
	 */
	public int maxalpaNumericCombination(long input) throws IllegalArgumentException;
	
	/**
	 * Will provide ability to change the digit-to-characters map when
	 * implemented, this is TO DO for now.
	 * 
	 * @param alphaMap
	 *            Map of alphabet letters for each digit from 0 to 9
	 * @throws UnsupportedOperationException
	 *             This method is placeholder for future enhancement
	 */
	public void setAlphaMap(Map<Integer, String> alphaMap) throws UnsupportedOperationException;
	
}
