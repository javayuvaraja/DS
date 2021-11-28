package com.yuva.leetcode.general;

/**
299. Bulls and Cows

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. 
When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number 
but are located in the wrong position. Specifically, the non-bull digits in the guess 
that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. 
Note that both secret and guess may contain duplicate digits.

 

Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

 * @author Yuvaraja Kanagarajan
 *
 */
public class BullsAndCows {
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int sDigit = Character.getNumericValue(secret.charAt(i));
			int gDigit = Character.getNumericValue(guess.charAt(i));
			if (sDigit == gDigit)
				bulls++;
			else {
				if (numbers[sDigit] < 0) // less than zero means guess has the char
					cows++;
				if (numbers[gDigit] > 0) // greater than zero means secret already has the char
					cows++;
				numbers[sDigit]++;
				numbers[gDigit]--;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
