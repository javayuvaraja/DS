package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;

/**
340. Longest Substring with At Most K Distinct Characters

Given a string s and an integer k, return the length of the longest substring of s 
that contains at most k distinct characters.

 

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.

 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestSubstringWithAtmostKDistinctChar {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] freqMap = new int[256];
		int distinctCharCount = 0, startIndex = 0, windowLen = 0;
		
		for (int endIndex = 0; endIndex < s.length(); endIndex++) {
			if (freqMap[s.charAt(endIndex)] == 0) { // new Distinct character
				distinctCharCount++;
			}
			freqMap[s.charAt(endIndex)]++;
			
			while (distinctCharCount > k && startIndex < s.length()) {
				freqMap[s.charAt(startIndex)]--;
				if (freqMap[s.charAt(startIndex)] == 0) {
					distinctCharCount--;
				}
				startIndex++;
			}
			
			windowLen = Math.max(windowLen, endIndex - startIndex + 1);
		}
		return windowLen;
	}
	
	
	public int lengthOfLongestSubstringKDistinct1(String str, int k) {
	    Map<Character, Integer> freqMap = new HashMap<>();
	    int startIndex = 0;
	    int maxWindowLen = 0;
	    for(int end = 0; end < str.length(); end++) {
	        char c = str.charAt(end);
	        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
	        while (freqMap.size() > k) { // more distinct character
	            char startChar = str.charAt(startIndex);
	            if (freqMap.containsKey(startChar)) {
	                freqMap.put(startChar, freqMap.get(startChar) - 1);                     
	                if (freqMap.get(startChar) == 0) { 
	                    freqMap.remove(startChar);
	                }
	            }
	            startIndex++;
	        }
	        maxWindowLen = Math.max(maxWindowLen, end - startIndex + 1);
	    }
	    return maxWindowLen;
	} 

}
