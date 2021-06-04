package com.yuva.leetcode.dp;

/**
 * 
Leetcode 72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int word1Len = word1.length();
		int word2Len = word2.length();
		if (word1.equals(word2)) {
			return 0;
		}
		if (word1Len == 0 || word2Len == 0) {
			return word1Len == 0 ? word2Len : word1Len;
		}
		int result[][] = new int[word1Len + 1][word2Len + 1];
		char charArr1[] = word1.toCharArray();
		char charArr2[] = word2.toCharArray();

		for (int i = 1; i <= word1Len; i++) {
			result[i][0] = i;
		}

		for (int i = 1; i <= word2Len; i++) {
			result[0][i] = i;
		}

		for (int i = 1; i <= word1Len; i++) {
			for (int j = 1; j <= word2Len; j++) {
				if (charArr1[i - 1] == charArr2[j - 1]) {
					result[i][j] = result[i - 1][j - 1];
				} else {

					result[i][j] = Math.min(Math.min(result[i - 1][j - 1], result[i][j - 1]), result[i - 1][j]) + 1;
				}
			}
		}
		return result[word1Len][word2Len];
	}
}
