package com.yuva.leetcode.general;

/**
1392. Longest Happy Prefix

A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

Example 1:
Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".

Example 2:
Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.

 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestHappyPrefix {

	public String longestPrefix(String s) {
	    int dp[] = new int[s.length()], j = 0;
	    for (int i = 1; i < s.length(); ++i) {
	        if (s.charAt(i) == s.charAt(j))
	            dp[i] = ++j;
	        else if (j > 0) {
	            j = dp[j - 1];
	            --i;
	        }
	    }
	    return s.substring(0, j);       
	}
}
