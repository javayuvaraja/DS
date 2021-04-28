package com.yuva.leetcode.dp;

/**
 * Leetcode 1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their 
longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original 
string with some characters (can be none) deleted without changing the 
relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestCommonSubsequence {

	public int lcs (char charArr1[], char charArr2[], int m, int n) {
		
		if (m==0 || n==0) {
			return 0;
		}
		if (charArr1[m] == charArr2[n]) {
			return 1+ lcs(charArr1, charArr2, m+1, n+1);
		} else {
			return Math.max(lcs(charArr1, charArr2, m, n-1),
					        lcs(charArr1, charArr2, m-1, n));
		}		
	}
	
	
	public int lcs(String s1, String s2) {
		char charArr1[] = s1.toCharArray();
		char charArr2[] = s2.toCharArray();

		int result[][] = new int[charArr1.length+1]
								[charArr2.length+1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0)
					result[i][j] = 0;
				else if (charArr1[i - 1] == charArr2[j - 1])
					result[i][j] = result[i - 1][j - 1] + 1;
				else
					result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
			}
		}
		return result[charArr1.length][charArr2.length];
	}
 }
