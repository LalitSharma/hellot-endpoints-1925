package com.lalit.sharma;

/**
 * Used to return the maximum number of combinations possible for a given phone
 * number
 * 
 * @author Lalit Sharma
 *
 */
public class CombinationCounts {

	private int maxCombinations;

	CombinationCounts() {
		//Intentionally left empty
	}

	CombinationCounts(int maxCombinations) {
		this.maxCombinations = maxCombinations;
	}
	
	public int getMaxCombinations() {
		return maxCombinations;
	}

	public void setMaxCombinations(int maxCombinations) {
		this.maxCombinations = maxCombinations;
	}
}
