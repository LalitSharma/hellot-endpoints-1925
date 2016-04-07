package com.lalit.sharma;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.users.User;

import java.util.ArrayList;

import javax.inject.Named;

/**
 * Defines v1 of a helloworld API, which provides simple "greeting" methods.
 */
@Api(
    name = "helloworld",
    version = "v1",
    scopes = {GAEConstants.EMAIL_SCOPE},
    clientIds = {GAEConstants.WEB_CLIENT_ID, GAEConstants.ANDROID_CLIENT_ID, GAEConstants.IOS_CLIENT_ID},
    audiences = {GAEConstants.ANDROID_AUDIENCE}
)
public class GAEGreetings {

  public static ArrayList<GAEHelloGreeting> greetings = new ArrayList<GAEHelloGreeting>();

  static {
    greetings.add(new GAEHelloGreeting("hello world!"));
    greetings.add(new GAEHelloGreeting("goodbye world!"));
  }

  public GAEHelloGreeting getGreeting(@Named("id") Integer id) throws NotFoundException {
    try {
      return greetings.get(id);
    } catch (IndexOutOfBoundsException e) {
      throw new NotFoundException("Greeting not found with an index: " + id);
    }
  }

  public ArrayList<GAEHelloGreeting> listGreeting() {
    return greetings;
  }

  @ApiMethod(name = "greetings.multiply", httpMethod = "post")
  public GAEHelloGreeting insertGreeting(@Named("times") Integer times, GAEHelloGreeting greeting) {
    GAEHelloGreeting response = new GAEHelloGreeting();
    StringBuilder responseBuilder = new StringBuilder();
    for (int i = 0; i < times; i++) {
      responseBuilder.append(greeting.getMessage());
    }
    response.setMessage(responseBuilder.toString());
    return response;
  }

  @ApiMethod(name = "greetings.authed", path = "hellogreeting/authed")
  public GAEHelloGreeting authedGreeting(User user) {
    GAEHelloGreeting response = new GAEHelloGreeting("hello " + user.getEmail());
    return response;
  }
  
	/**
	 * GET - for maximum number of combinations
	 * @param phonenumber Phone number for which maximum number of combinations need to be calculated
	 * @return Returns the maximum number of combinations possible for a given phone number
	 * @throws IllegalArgumentException
	 */
	public CombinationCounts getMaxCombinationCount(@Named("phonenumber") Long phonenumber) throws IllegalArgumentException {
		try {
			PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();
			int maxCount = phoneAlphaNumericCombination.maxalpaNumericCombination(phonenumber);
			CombinationCounts maxCombinations = new CombinationCounts(maxCount);
			return maxCombinations;
		} catch (IllegalArgumentException e) {
			//TO DO - return error in more human readable format back to the page
			throw e;
		}
	}

	/**
	 * GET - combinations
	 * @return List of combination String
	 */
	public ArrayList<CombinationString> listCombinations(@Named("phonenumber") Long phonenumber, 
			@Named("start") Integer start, @Named("count") Integer count) {

		try {
			PhoneAlphaNumericCombination phoneAlphaNumericCombination = new PhoneAlphaNumericCombinationImpl();
			ArrayList<String> outputList = phoneAlphaNumericCombination.alpaNumericCombinationPartialPhoneUS(phonenumber, start, count);
			
			ArrayList<CombinationString> combinations = new ArrayList<CombinationString>(outputList.size());
			for(String output : outputList){
				combinations.add(new CombinationString(output));
			}
			return combinations;
		} catch (IllegalArgumentException e) {
			//TO DO - return error in more human readable format back to the page
			throw e;
		}
		
/*		
		ArrayList<CombinationString> combinations = new ArrayList<CombinationString>();
		long input = 12030L;
		String[] expectedOutput = { "12030", "1A030", "1B030", "1C030", "120D0", "1A0D0", "1B0D0", "1C0D0", 
									"120E0", "1A0E0", "1B0E0", "1C0E0", "120F0", "1A0F0", "1B0F0", "1C0F0"};
		
		for(String output : expectedOutput){
			combinations.add(new CombinationString(output));
		}
		return combinations;
*/		
	}
}
