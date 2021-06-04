package com.yuva.leetcode.dp;

/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * Example 2: Input: s = "cbbd" Output: "bb"
 * 
 * Example 3: Input: s = "a" Output: "a"
 * 
 * Example 4: Input: s = "ac" Output: "a"
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String str) {
		if (str.length() == 0) {
			return "";
		}
		char charArr[] = str.toCharArray();
		boolean result[][] = new boolean[charArr.length][charArr.length];
		// Single character
		for (int i = 0; i < charArr.length; i++) {
			result[i][i] = true;
		}
		int startIndex = 0;
		int maxLength = 1;
		
		// Two Length
		for (int i = 0; i < charArr.length - 1; i++) {
			if (charArr[i] == charArr[i + 1]) {
				startIndex = i;
				result[i][i + 1] = true;
				maxLength = 2;
			}
		}

		// From three letter length
		for (int len = 3; len <= charArr.length; len++) {
			for (int start = 0; start < charArr.length - len + 1; start++) {
				int end = start + len - 1;
				if (charArr[start] == charArr[end] && result[start + 1][end - 1] == true) {
					result[start][end] = true;
					if (len > maxLength) {
						maxLength = len;
						startIndex = start;
					}
				}
			}
		}

		return str.substring(startIndex, startIndex + maxLength);
	}
}
