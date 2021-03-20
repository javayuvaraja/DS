package com.yuva.leetcode.general;
/**
 * 
 * Pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 * @author Yuvaraja Kanagarajan
 *
 */
public class KMPSubString {

	public boolean KMP(String str, String pattern) {
		
		char []strArr = str.toCharArray();
		char[]patternArr = pattern.toCharArray();
		int patternCountArr[] = buildPatternArray(pattern);
		
		int i=0, j = 0;
		while (i < strArr.length && j < patternArr.length) {
			if (strArr[i]==patternArr[j]) {
				i++;
				j++;
			} else {
				if (j!=0) {
					j=patternCountArr[j-1];
				} else {
					i++;
				}
			}
		}
		return j==pattern.length();
	}
	
	public int[] buildPatternArray(String pattern) {
		char []patternArr = pattern.toCharArray();
		int index = 0; 
		int result[] = new int [pattern.length()];
		for (int i=1;i< pattern.length();) {
			// both are same character then increase the count and
			// increase the index and i
			if (patternArr[i]==patternArr[index]) {
				result[i] = result[index]+1;
				i++;
				index++;
			} else {
				if (index == 0) {
					i++;
				} else {
					index = result[index-1];
					i++;
				}
			}			
		}
		return result;
	}
} 
