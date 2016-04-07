package com.lalit.sharma;

import java.util.ArrayList;
import java.util.Map;

/**
 * Implements {@link PhoneAlphaNumericCombination}
 * 
 * Has built-in mapping of US phone digits to alphabet letters to compute
 * combination for a given number. Setting of a new map is not yet supported
 * 
 * @author Lalit Sharma
 *
 */
public class PhoneAlphaNumericCombinationService {
	//private static Log log = LogFactory.getLog(PhoneAlphaNumericCombinationService.class);

	/**
	 * The algorithm is to get all the combination by replacing letters for
	 * single digit starting at end. So starting with e.g. 240_386_6126, new
	 * strings for last digit 6 would be 240_386_612M, 240_386_612N,
	 * 240_386_612O, then for 2 would be 240_386_61AM, 240_386_61BM,
	 * 240_386_61AM, 240_386_61AN and so on
	 * 
	 * @param input
	 *            must be positive number for which the alphanumeric
	 *            combinations have to be computed
	 * @param digitAlphaMap
	 *            Map of digits to letter for a phone pad
	 * @return List of string that has all the combinations for the alphanumeric
	 *         representation for the input phone number
	 * 
	 *         TODO - Need more optimized version, for input = 999999999, takes
	 *         ~10s and
	 */
	static ArrayList<String> alpaNumericCombinationStringBackward(long input, Map<Integer, String> digitAlphaMap) {
		// Used for return value
		ArrayList<String> outputList = new ArrayList<String>();

		ArrayList<Integer> inputDigitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);
		ArrayList<String> inputDigitsLetterList = PhoneAlphaNumericCombinationUtil.digitAlphaList(input, digitAlphaMap);

		// The input number will be the starting string for output
		outputList.add(Long.toString(input));

		// Start at the last digit of input number and create output combination
		for (int i = inputDigitList.size() - 1; i >= 0; --i) {
			// Get all letters corresponding to the digit
			String digitLetters = inputDigitsLetterList.get(i);

			// New array to hold all combinations for the digit
			ArrayList<ArrayList<String>> digitOutputList = new ArrayList<ArrayList<String>>();

			// For each letter for the digit create new set of output strings
			for (int d = 0; d < digitLetters.length(); d++) {
				// Add all output strings so far and replace the character in
				// the
				ArrayList<String> digitLetterOutput = new ArrayList<String>(outputList);
				digitOutputList.add(digitLetterOutput);

				// Create new string with the character replaced
				for (int k = 0; k < digitLetterOutput.size(); k++) {
					StringBuilder strReplaced = new StringBuilder(digitLetterOutput.get(k));
					strReplaced.setCharAt(i, digitLetters.charAt(d));
					digitLetterOutput.set(k, strReplaced.toString());
				}
			}

			// Copy the newly created string to the output
			for (ArrayList<String> digitOutput : digitOutputList) {
				outputList.addAll(digitOutput);
			}
		}

		return outputList;
	}

	/**
	 * Uses StringBuilder to store the combination strings
	 * 
	 * @param input
	 *            Phone number for which the combinations are needed
	 * @param alphaMap
	 *            Mapping of letters for each phone number, just letters no
	 *            numbers, so 2 = "ABC"
	 * @return Array of StringBuilder containing all combination string for
	 *         given phone number
	 */
	static ArrayList<StringBuilder> alpaNumericCombinationStringBuilder(long input, String[][] alphaMap) {

		ArrayList<Integer> inputDigitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);

		// The input number will be the starting string for output
		ArrayList<StringBuilder> outputList = new ArrayList<StringBuilder>();
		outputList.add(new StringBuilder(Long.toString(input)));

		// Get all letters corresponding to the digit
		ArrayList<String[]> digitLettersList = new ArrayList<String[]>();
		for (int i = 0; i < inputDigitList.size(); ++i) {
			digitLettersList.add(alphaMap[inputDigitList.get(i)]);
		}

		String[] digitLetters = null;
		// Start at the first digit of input number and create output
		// combination
		for (int i = 0; i < digitLettersList.size(); ++i) {
			// Get all letters corresponding to the digit
			digitLetters = digitLettersList.get(i);

			ArrayList<StringBuilder> outputListTemp = new ArrayList<StringBuilder>();
			// For each letter for the digit create new set of output strings
			for (int d = 0; d < digitLetters.length; d++) {
				for (int k = 0; k < outputList.size(); k++) {
					StringBuilder strReplaced = new StringBuilder(outputList.get(k));
					// strReplaced.append(digitLetters[d]);
					strReplaced.replace(i, i + 1, digitLetters[d]);
					outputListTemp.add(strReplaced);
				}

			}
			outputList.addAll(outputListTemp);
		}
		return outputList;
	}

	/**
	 * Uses String to store combination values
	 * 
	 * @param input
	 *            Phone number
	 * @param alphaMap
	 *            Mapping of letters for each phone number, just letters no
	 *            numbers, so 2 = "ABC"
	 * @return List of AlphaNumeric combinations for the given phone number
	 */
	static ArrayList<String> alpaNumericCombinationStringForward(long input, String[][] alphaMap) {
		// Used for return value
		ArrayList<String> outputList = new ArrayList<String>();
		// The input number will be the starting string for output
		outputList.add(Long.toString(input));

		// All the digits in the input value
		ArrayList<Integer> inputDigitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);

		// Get all letters corresponding to the digit
		ArrayList<String[]> digitLettersList = new ArrayList<String[]>();
		for (int i = 0; i < inputDigitList.size(); ++i) {
			digitLettersList.add(alphaMap[inputDigitList.get(i)]);
		}

		String[] digitLetters = null;

		// Start at the first digit of input number and create output
		// combination
		for (int i = 0; i < digitLettersList.size(); ++i) {
			// Get all letters corresponding to the digit
			digitLetters = digitLettersList.get(i);

			ArrayList<String> sbListTemp = new ArrayList<String>();

			// For each letter for the digit create new set of output strings
			for (int d = 0; d < digitLetters.length; d++) {

				for (int k = 0; k < outputList.size(); k++) {
					StringBuilder strReplaced = new StringBuilder(outputList.get(k));
					// strReplaced.append(digitLetters[d]);
					strReplaced.replace(i, i + 1, digitLetters[d]);
					sbListTemp.add(strReplaced.toString());
				}
			}
			outputList.addAll(sbListTemp);
		}
		return outputList;
	}

	/**
	 * Uses Byte array to store and return the combinations
	 * 
	 * @param input
	 * @param alphaMap
	 *            Mapping of letters for each phone number, just letters no
	 *            numbers, so 2 = {'A','B','C'}
	 * @return Array of byte arrays containing all combination for
	 *         given phone number
	 */
	static ArrayList<byte[]> alpaNumericCombinationBytes(long input, byte[][] alphaMap) {
		ArrayList<Integer> inputDigitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);

		// Output array - initialize with input number as it would be part of
		// output
		ArrayList<byte[]> outputList = new ArrayList<byte[]>();
		byte[] digits = new byte[inputDigitList.size()];
		outputList.add(digits);

		ArrayList<byte[]> digitLettersList = new ArrayList<byte[]>();
		for (int i = 0; i < inputDigitList.size(); ++i) {
			// Get all letters corresponding to each input digit
			digitLettersList.add(alphaMap[inputDigitList.get(i)]);

			// Initialize output with all digits of input number
			digits[i] = (byte) (int) inputDigitList.get(i);
		}

		byte[] digitLetters = null;
		// Start at the first digit of input number and create output
		// combination
		for (int i = 0; i < digitLettersList.size(); ++i) {
			// Get all letters corresponding to the digit
			digitLetters = digitLettersList.get(i);

			// New array to hold all combinations for the digit
			ArrayList<byte[]> outputListTemp = new ArrayList<byte[]>();

			// For each letter for the digit create new set of output strings by
			// replacing with each letter for that digit
			for (int d = 0; d < digitLetters.length; d++) {
				for (int k = 0; k < outputList.size(); k++) {
					byte[] outputTemp = outputList.get(k).clone();
					outputTemp[i] = digitLetters[d];
					outputListTemp.add(outputTemp);
				}
			}
			outputList.addAll(outputListTemp);
		}

		return outputList;
	}

	/**
	 * Provides partial set of combinations starting at given combination
	 * position, this is useful when only partial set is need, like pagination,
	 * in that case the execution time & memory utilization will be much less
	 * than getting all combinations and only returning partial set.
	 * 
	 * The combination returned is based on starting with first digit so for 234
	 * it would be 234, A34, B34....
	 * 
	 * @param input
	 *            Phone number for which combinations is to be computed
	 * @param from
	 *            Return combination starting at this position
	 * @param count
	 *            Number of combinations to return, value will be less if count
	 *            is greater than the number of combinations possible
	 * @param alphaNumericMap
	 *            Mapping of digits and letters for each phone number, for example, 2 = {'1','A','B','C'}
	 * @return List of combinations, for example, can get 2 combinations
	 *         starting at 3rd for 1234 will return 1B34 & 1C34
	 */
	static ArrayList<byte[]> alpaNumericCombinationPartial(long input, int from, int count, byte[][] alphaNumericMap) {
		final int maxCombinations = maxCombinationsPossible(input, alphaNumericMap);
		final ArrayList<Integer> inputDigitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);

		ArrayList<byte[]> digitLettersList = new ArrayList<byte[]>();
		for (int i = 0; i < inputDigitList.size(); ++i) {
			digitLettersList.add(alphaNumericMap[inputDigitList.get(i)]);
		}

		int start = from;
		int end = (int) Math.min(maxCombinations + 1, (long) start + count);

		ArrayList<byte[]> outputList = null;
		if(end >= start){
			outputList = new ArrayList<byte[]>(end - start);
	
			for (int i = start; i < end; i++) {
				byte[] outDigits = alpaNumericIntegerAt(digitLettersList, i);
				outputList.add(outDigits);
			}
		}else{
			//Don't return null, that way caller does not have to check
			outputList = new ArrayList<byte[]>();
		}

		return outputList;
	}

	/**
	 * Gets the combination at given position
	 * 
	 * The combination returned is based on starting with combinations for first
	 * digit so for 123 it would be 1A3, 1B3, 1C3....
	 * 
	 * @param digitLettersList
	 *            List of digits for the input number
	 * @param at
	 *            Position of combination that needs to be returned
	 * @return Array representing the combination
	 */
	static byte[] alpaNumericIntegerAt(ArrayList<byte[]> digitLettersList, int at) {
		byte[] outDigits = new byte[digitLettersList.size()];
		int outIndex = 0;
		byte[] digitLetters = null;

		// Count when letters for a given digit will start repeating, for
		// example, if input is '678' then for first digit(2) it would be 4 as
		// for 6 the values are 6,M,N,O
		int repeatAfter = 1;
		int index = -1;
		// Determine which letter for the first digit will be at the given
		// combination position
		if (digitLettersList.size() > 0) {
			// Get all letters corresponding to the digit
			digitLetters = digitLettersList.get(0);

			repeatAfter = digitLetters.length;

			index = at % repeatAfter;
			index = (index == 0) ? repeatAfter - 1 : index - 1;
			outDigits[outIndex++] = digitLetters[index];
		}

		// Count when letters for a digit before given digit will start
		// repeating, for example, if input is '678' then when determining the
		// letter for '7' this would be 4 as values for digit before it(6) are
		// 2,M,N,O
		int prevRepeatsAfter = repeatAfter;

		// Determine which letter for second digits onwards will be for the
		// given combination position
		for (int i = 1; i < digitLettersList.size(); ++i) {
			// Get all digits & letters corresponding to the digit
			digitLetters = digitLettersList.get(i);

			// Count when letters for digit will repeat, for example, for '678',
			// letter for 7 will repeat after 4x5=20 combination as 6 as four
			// value(6,M,N,O) and 7 has five values(7,P,Q,R), for 8 they will
			// repeat after 4x5x4=80 combinations as 8 has four values (8,T,U,V)
			repeatAfter = prevRepeatsAfter * digitLetters.length;

			// Where in current digits repeat cycle
			int d = at % repeatAfter;

			if (d == 0) {
				// For case when the combination position is multiple of repeat
				// count it would be last letter, for example, for '678' the
				// value, for 7 at 20th combination would be last letter for
				// 7='S'
				index = digitLetters.length - 1;
			} else {
				// Each letter in current cycle is repeated for all letters for
				// previous digit, so dividing by it will give the letter for
				// current digit
				int q = d / prevRepeatsAfter;
				if (q == 0) {
					// Means at beginning of a repeat pattern for the letter for
					// current digit.
					index = 0;
				} else {
					int m = d % prevRepeatsAfter;
					if (m == 0) {
						// At the end of repeat cycle for previous digit letter
						// is last repeat of current letter, but the index will
						// point to next letter so adjust it
						index = q - 1;
					} else {
						// Letter for current digit is somewhere in its repeat
						// cycle, index will stay the same for all those repeats
						index = q;
					}
				}
			}
			outDigits[outIndex++] = digitLetters[index];

			prevRepeatsAfter = repeatAfter;
		}
		return outDigits;
	}

	/**
	 * Maximum number of combinations of digits and letters possible for given
	 * phone number
	 * 
	 * @param input
	 *            Phone number
	 * @return Number of combinations possible
	 */
	static int maxCombinationsPossible(long input, byte[][] alphaNumericMap) {
		int maxCombinations = 1;
		ArrayList<Integer> inputDigitList = PhoneAlphaNumericCombinationUtil.splitDigits(input);

		for (int i = 0; i < inputDigitList.size(); ++i) {

			maxCombinations = maxCombinations * alphaNumericMap[inputDigitList.get(i)].length;
		}
		return maxCombinations;
	}
}
