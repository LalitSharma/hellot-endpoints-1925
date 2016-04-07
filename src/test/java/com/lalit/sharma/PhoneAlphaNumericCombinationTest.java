package com.lalit.sharma;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PhoneAlphaNumericCombinationTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	/**
	 * Test unsupported method exception for TO DO methods for future
	 * enhancements
	 */
	@Test
	public void setAlphaMap_Throws_UnsupportedOperationExceptionTest() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();
		Map<Integer, String> alphaMap = new HashMap<Integer, String>();

		exception.expect(UnsupportedOperationException.class);

		phoneAlphaNumericCombination.setAlphaMap(alphaMap);
	}

	/**
	 * Test unsupported illegal argument exception when input is negative number
	 */
	@Test
	public void alpaNumericCombinationAllPhoneUS_Throws_IllegalArgumentExceptionTest() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.alpaNumericCombinationAllPhoneUS(-123);
	}

	/**
	 * Test unsupported illegal argument exception when input is larger than 9999999999
	 */
	@Test
	public void alpaNumericCombinationAllPhoneUS_Throws_IllegalArgumentExceptionTest2() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.alpaNumericCombinationAllPhoneUS(PhoneAlphaNumericCombinationRefData.maxInputAllowed+9);
	}
	
	
	/**
	 * Test unsupported illegal argument exception when input phone number is negative number
	 */
	@Test
	public void alpaNumericCombinationPartialPhoneUS_Throws_IllegalArgumentExceptionTest1() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.alpaNumericCombinationPartialPhoneUS(-123,1,2);
	}

	/**
	 * Test unsupported illegal argument exception when input is larger than 9999999999
	 */
	@Test
	public void alpaNumericCombinationPartialPhoneUS_Throws_IllegalArgumentExceptionTest2() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.alpaNumericCombinationPartialPhoneUS(PhoneAlphaNumericCombinationRefData.maxInputAllowed+9, 1, 1);
	}
	
	
	/**
	 * Test unsupported illegal argument exception when input start position is negative number
	 */
	@Test
	public void alpaNumericCombinationPartialPhoneUS_Throws_IllegalArgumentExceptionTest3() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.alpaNumericCombinationPartialPhoneUS(123,-1,2);
	}
	
	/**
	 * Test unsupported illegal argument exception when input count of combinations requested is negative number
	 */
	@Test
	public void alpaNumericCombinationPartialPhoneUS_Throws_IllegalArgumentExceptionTest4() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.alpaNumericCombinationPartialPhoneUS(123,1,-2);
	}

	/**
	 * Test unsupported illegal argument exception when input is negative number
	 */
	@Test
	public void maxalpaNumericCombination_Throws_IllegalArgumentExceptionTest() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.maxalpaNumericCombination(-123);
	}

	/**
	 * Test unsupported illegal argument exception when input is larger than 9999999999
	 */
	@Test
	public void maxalpaNumericCombination_Throws_IllegalArgumentExceptionTest2() {
		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();

		exception.expect(IllegalArgumentException.class);

		phoneAlphaNumericCombination.maxalpaNumericCombination(PhoneAlphaNumericCombinationRefData.maxInputAllowed+9);
	}
	
	
	/**
	 * Test for 'alpaNumericCombinationAllPhoneUS' method, this is simple that, more combinations are covered in the service test
	 */
	@Test
	public void alpaNumericCombinationAllPhoneUSTest(){
		long input = 12030L;
		String[] expectedOutput = { "12030", "1A030", "1B030", "1C030", "120D0", "1A0D0", "1B0D0", "1C0D0", 
									"120E0", "1A0E0", "1B0E0", "1C0E0", "120F0", "1A0F0", "1B0F0", "1C0F0"};

		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();
		
		ArrayList<String> outputList = phoneAlphaNumericCombination.alpaNumericCombinationAllPhoneUS(input);
		
		String[] output = outputList.toArray(new String[outputList.size()]);

		assertTrue(Arrays.equals(expectedOutput, output));		
	}
	
	/**
	 * Test for 'alpaNumericCombinationPartialPhoneUS' method, this is simple that, more combinations are covered in the service test
	 */
	@Test
	public void alpaNumericCombinationPartialPhoneUSTest(){
		long input = 12030L;
		String[] expectedOutput = { "1A030", "1B030", "1C030", "120D0", "1A0D0", "1B0D0", "1C0D0", 
									"120E0", "1A0E0", "1B0E0", "1C0E0", "120F0", "1A0F0", "1B0F0"};

		PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();
		
		ArrayList<String> outputList = phoneAlphaNumericCombination.alpaNumericCombinationPartialPhoneUS(input, 2, 14);
		
		String[] output = outputList.toArray(new String[outputList.size()]);

		assertTrue(Arrays.equals(expectedOutput, output));		
	}
}
