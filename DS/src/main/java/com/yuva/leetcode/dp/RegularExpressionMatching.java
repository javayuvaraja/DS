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
		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

		T[0][0] = true;
		
		// Deals with patterns like a* or a*b* or a*b*c*
		for (int i = 1; i < T[0].length; i++) {
			if (pattern[i - 1] == '*') {
				T[0][i] = T[0][i - 2];
			}
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				// if current pattern is . or pattern char and text char is matched
				if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {  // if pattern is * then check the two char before
					T[i][j] = T[i][j - 2];
					if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length][pattern.length];
	}
	public static void main(String[] args) {
		String str = "mississippi";
		String pattern = "mis*is*p*.";
		
		RegularExpressionMatching obj = new RegularExpressionMatching();
		System.out.println(obj.isMatch(str, pattern));
	}

}
