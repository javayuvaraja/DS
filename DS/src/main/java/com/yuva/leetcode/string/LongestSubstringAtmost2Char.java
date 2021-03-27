package com.yuva.leetcode.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Leetcode : 159
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

	
	Input: "eceba"
	Output: 3
	Explanation: "ece" which its length is 3.
	
	Example 2:
	Input: "ccaabbb"
	Output: 5
	Explanation: "aabbb" which its length is 5.

 * @author Yuvaraja Kanagarajan
 *
 */

public class LongestSubstringAtmost2Char {

	public static void main(String[] args) {
		String str = "ccaabbb";
		System.out.println(longestSubString(str));
	}
	
	private static int longestSubString(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		
		char[] charArr = str.toCharArray();
		//Stores the last occurred index of the character
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		int startIndex = 0;
		int maxLength = 0;
		for (int i=0; i < charArr.length; i++) {
			
			// if char contains then update the maxlength
			if (charMap.containsKey(charArr[i])) {
				maxLength = Math.max(maxLength, i-startIndex+1);				
			} else {
				// if charMap contains 2 then remove the first char in the map
				// and update the startIndex
				if (charMap.size()>1) {
					int temp = startIndex;
					startIndex = charMap.get(charArr[temp]) + 1;
					charMap.remove(charArr[temp]);
				} 
			}
			charMap.put(charArr[i], i);
		}
		
		return maxLength;
	}
}
