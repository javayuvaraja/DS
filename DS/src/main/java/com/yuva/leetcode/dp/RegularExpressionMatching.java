package com.yuva.leetcode.dp;

/**

Leetcode 10. Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression
 matching with support for '.' and '*' where: 

'.' Matches any single character.​​​​
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

	public boolean isMatch(String str, String pattern) {
        char[] strArr = str.toCharArray();
        char[] patternArr = pattern.toCharArray();

        boolean result[][] = new boolean[strArr.length + 1][patternArr.length + 1];

        if (patternArr.length > 0 && patternArr[0] == '*') {
            result[0][1] = true;
        }

        result[0][0] = true;

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (patternArr[j-1] == '?' || strArr[i-1] == patternArr[j-1]) {
                    result[i][j] = result[i-1][j-1];
                } else if (patternArr[j-1] == '*'){
                    result[i][j] = result[i-1][j] || result[i][j-1];
                }
            }
        }

        return result[strArr.length][patternArr.length];
    }
	
	public static void main(String[] args) {
		String str = "mississippi";
		String pattern = "mis*is*p*.";
		
		RegularExpressionMatching obj = new RegularExpressionMatching();
		System.out.println(obj.isMatch(str, pattern));
	}

}
