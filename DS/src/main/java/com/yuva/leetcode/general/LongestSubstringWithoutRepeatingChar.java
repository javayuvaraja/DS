package com.yuva.leetcode.general;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * 	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestSubstringWithoutRepeatingChar {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char ch[] = s.toCharArray();
		int maxLen = 1;
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put(ch[0], 0);
		int startIndex = 0;
		for (int i = 1; i < ch.length; i++) {
			if (charMap.containsKey(ch[i])) {
				startIndex = Math.max(startIndex, charMap.get(ch[i]) + 1);
			}
			maxLen = Math.max(maxLen, i - startIndex + 1);
			charMap.put(ch[i], i);
		}
		return maxLen;

	}
}
