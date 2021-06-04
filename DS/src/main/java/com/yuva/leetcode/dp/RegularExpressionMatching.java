package com.yuva.leetcode.dp;

/**

Leetcode 10. Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression
 matching with support for '.' and '*' where: 

'.' Matches any single character
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).


Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. 
Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:

Input: s = "mississippi", p = "mis*is*p*."
Output: false
 
 * 
 * 
 * @author Yuvaraja Kanagarajan
 *
 *
 */
public class RegularExpressionMatching {

	/**
	Logic:
	1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
	2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
	3, If p.charAt(j) == '*': 
	   here are two sub conditions:
	               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
	               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
	                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
	                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
	                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
	*/
	
	public boolean isMatch(String s, String p) {

		char[] text = s.toCharArray();
		char[] pattern = p.toCharArray();
		boolean result[][] = new boolean[text.length + 1][pattern.length + 1];

		result[0][0] = true;
		
		// Deals with patterns like a* or a*b* or a*b*c*
		for (int i = 1; i < result[0].length; i++) {
			if (pattern[i - 1] == '*') {
				result[0][i] = result[0][i - 2];
			}
		}

		for (int i = 1; i < result.length; i++) {
			for (int j = 1; j < result[0].length; j++) {
				// if current pattern is . or pattern char and text char is matched
				if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
					result[i][j] = result[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {  // if pattern is * then check the two char before
					result[i][j] = result[i][j - 2];
					if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
						result[i][j] = result[i][j] | result[i - 1][j];
					}
				} else {
					result[i][j] = false;
				}
			}
		}
		return result[text.length][pattern.length];
	}
	
	public boolean isMatch1(String str, String pattern) {
		if (pattern.length()==0 ) {
			return str.length()==0;
		}
		
		boolean firstCharMatch =  str.length() > 0 && 
								(str.charAt(0)==pattern.charAt(0) || pattern.charAt(0)=='.'); 
		
		if(pattern.length()>=2 && pattern.charAt(1)=='*') {
			return isMatch1(str, pattern.substring(2)) || 
					(firstCharMatch && isMatch1(str.substring(1), pattern));
		} else {
			return firstCharMatch && isMatch1(str.substring(1), pattern.substring(1));
		}
			
	}
	
	public boolean isMatchDP(String str, String pattern) {
		
		int m = str.length();
		int n = pattern.length();
		
		boolean [][]result = new boolean[m+1][n+1];
		result[0][0]= true;
		
		// for handling the zero or more of preceding. Ex : a*, empty string should match this pattern
		for (int i =2; i <=n; i++) {
			if (pattern.charAt(i-1)=='*') {
				result[0][i] = result[0][i-2];
			}
		}
		
		for (int i =1; i <= str.length(); i++) {
			for (int j=1; j <= pattern.length(); j++) {
				char strChar = str.charAt(i-1);
				char patternChar = pattern.charAt(i-1);
				// pattern and curr char is match or pattern is .
				if (strChar == patternChar || patternChar == '.') {
					result [i][j] = result[i-1][j-1];
				} else if (patternChar == '*') {
					if (result[i][j-2]) { // zero occurrence case
						result[i][j] = true;
					} else if (strChar == pattern.charAt(j-2) ||
							pattern.charAt(j-2)=='.') {   // handling a. or a*
						result[i][j] = result[i-1][j];
					}
				}
				
			}
		}
		return result[m][n];
				
			
	}
	
	public static void main(String[] args) {
		String str = "mississippi";
		String pattern = "mis*is*p*.";
		
		RegularExpressionMatching obj = new RegularExpressionMatching();
		System.out.println(obj.isMatch(str, pattern));
	}

}
