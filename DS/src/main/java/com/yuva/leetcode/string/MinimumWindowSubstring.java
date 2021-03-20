package com.yuva.leetcode.string;

/**
 * Leetcode 76. Minimum Window Substring
   
   Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
   If there is no such window in s that covers all characters in t, return the empty string "".

   Note that If there is such a window, it is guaranteed that there will always be 
   only one unique minimum window in s.
 *
 *  Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimumWindowSubstring {

	/**
	 * Logic : Build pattern hash and the string hash. 
	 *        
	 * @param inputStr
	 * @param patternStr
	 * @return
	 */
	public String minWindow(String inputStr, String patternStr) {
		if (inputStr.length() == 0 || patternStr.length() == 0) {
			return "";
		}
		if (inputStr.length() < patternStr.length()) {
			return "";
		}
		int patternHash[] = new int[256];
		int strHash[] = new int[256];

		for (int i = 0; i < patternStr.length(); i++) {
			patternHash[patternStr.charAt(i)]++;
		}
		int startIndex = -1;
		int start = 0;
		int minWinLength = Integer.MAX_VALUE;
		int len = 0;
		for (int i = 0; i < inputStr.length(); i++) {
			strHash[inputStr.charAt(i)]++;
			// If pattern hash is more than str hash for this character then increase the window length
			if (patternHash[inputStr.charAt(i)] > 0 
					&& patternHash[inputStr.charAt(i)] >= strHash[inputStr.charAt(i)]) {
				len++;
			}
			// if current length is same as pattern length then reduce the window	
			if (len == patternStr.length()) {
				// if out of the window the increase the start
				while (patternHash[inputStr.charAt(start)] == 0 || // if pattern doesn't have current char
						strHash[inputStr.charAt(start)] > patternHash[inputStr.charAt(start)]) { // if string hash has more  times than the pattern hash
					if (strHash[inputStr.charAt(start)] > patternHash[inputStr.charAt(start)]) {
						strHash[inputStr.charAt(start)]--;
					}
					start++;

				}
				int currWinLength = i - start + 1;
				if (currWinLength < minWinLength) {
					minWinLength = currWinLength;
					startIndex = start;
				}
				// startIndex = i;
			}
		}

		return startIndex == -1 ? "" : inputStr.substring(startIndex, startIndex + minWinLength);
	}
}
