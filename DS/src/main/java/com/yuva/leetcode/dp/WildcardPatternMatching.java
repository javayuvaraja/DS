package com.yuva.leetcode.dp;

public class WildcardPatternMatching {

	boolean comparison(String str, String pattern) {
		int strIndex = 0, patternIndex = 0, 
				match = 0, starIndex = -1;
		while (strIndex < str.length()) {
			// advancing both pointers
			if (patternIndex < pattern.length() && 
					(pattern.charAt(patternIndex) == '?' || str.charAt(strIndex) == pattern.charAt(patternIndex))) {
				strIndex++;
				patternIndex++;
			}
			// * found, only advancing pattern pointer
			else if (patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
				starIndex = patternIndex;
				match = strIndex;
				
				patternIndex++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIndex != -1) {
				patternIndex = starIndex + 1;
				match++;
				strIndex = match;
			}
			// current pattern pointer is not star, last patter pointer was not *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*')
			patternIndex++;

		return patternIndex == pattern.length();
	}
	
	
	public boolean isMatch(String s, String p) {
        boolean result[][] = new boolean[s.length()+1][p.length()+1];
        result[0][0] = true;
        int index = 1; 
        while (index-1 < p.length() && p.charAt(index-1)=='*') {
            result[0][index++] = true;
        }
        if (p.length()>0 && p.charAt(0)=='*' ) {
            
        }
        for (int i=1; i < result.length; i++) {
            for (int j=1; j < result[0].length; j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || 
                    p.charAt(j-1)=='?') {
                    result[i][j] = result[i-1][j-1];
                } else if (p.charAt(j-1)=='*') {
                    result[i][j] = result[i-1][j] || result[i][j-1];
                } else {
                    result[i][j] = false;
                }
            }
        }
        
        for (int i=0; i < result.length; i++) {
            for (int j=0; j < result[0].length; j++) {
                System.out.print (result[i][j] + " ");
            }
            System.out.println ();
        }
        return result[result.length-1] [result[0].length-1];
    }
}
