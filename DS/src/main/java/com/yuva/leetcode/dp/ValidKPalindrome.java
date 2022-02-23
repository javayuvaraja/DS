package com.yuva.leetcode.dp;

/**
 * 1216. Valid Palindrome III
 * 
 * Given a string s and an integer k, return true if s is a k-palindrome.
 * 
 * A string is k-palindrome if it can be transformed into a palindrome by
 * removing at most k characters from it.
 * 
 * Example 1: Input: s = "abcdeca", k = 2 Output: true Explanation: Remove 'b'
 * and 'e' characters.
 * 
 * Example 2: Input: s = "abbababa", k = 1 Output: true
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidKPalindrome {

	/*
	 *  Logic : Find the longest palindromic subsequence in the string
	 *          1. Find the Longest subsequence between string and reverse of the string
	 *          2. Subtract the K, check 
	 */
	public boolean isValidPalindrome(String str, int k) {
		int strLen = str.length();

		StringBuilder stringBuilder = new StringBuilder(str).reverse();
		int lpsCount = lcs(str, stringBuilder.toString());

		return (strLen - lpsCount <= k);
	}

	/*
	 * longest palindromic subsequence: LCS of the given string & its reverse will
	 * be the longest palindromic sequence.
	 */
	private int lcs(String X, String Y) {
		int length = X.length();
		int[][] dp = new int[length + 1][length + 1];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) { // same
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else { // if not same check above the row, and before column
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[length][length];
	}
	
	public boolean isValidPalindrome1(String s, int k) {
        return s.length() - LCS(s) <= k;
    }
    
    private int LCS(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 0; i < n; i++) {
            int k = n - 1;
            for (int j = 0; j < n; j++, k--) {
                if (s.charAt(i) == s.charAt(k)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[n][n];
    }
}
