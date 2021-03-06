package com.yuva.leetcode.dp;

/**
 * 
 * 
 * 
 * @author Yuvaraja Kanagarajan
 *
 *   Logic ":
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
