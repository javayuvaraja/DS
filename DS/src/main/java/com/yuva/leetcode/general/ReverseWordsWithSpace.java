package com.yuva.leetcode.general;

/**
 * 
51. Reverse Words in a String

Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

 * @author Yuvaraja Kanagarajan
 *
 */
public class ReverseWordsWithSpace {

	public String reverseWords(String s) {
		if (s == null)
			return null;

		char[] a = s.toCharArray();
		int n = a.length;

		// step 1. reverse the whole string
		reverse(a, 0, n - 1);
		// step 2. reverse each word
		reverseWords(a, n);
		// step 3. clean up spaces
		return cleanSpaces(a, n);
	}

	void reverseWords(char[] arr, int arrLen) {
		int start = 0, end = 0;

		while (start < arrLen) {
			while (start < end || start < arrLen && arr[start] == ' ')
				start++; // skip spaces
			while (end < start || end < arrLen && arr[end] != ' ')
				end++; // skip non spaces
			reverse(arr, start, end - 1); // reverse the word
		}
	}

	// trim leading, trailing and multiple spaces
	String cleanSpaces(char[] arr, int arrLen) {
		int resultIndex = 0, j = 0;

		while (j < arrLen) {
			while (j < arrLen && arr[j] == ' ')
				j++; // skip leading spaces
			while (j < arrLen && arr[j] != ' ')
				arr[resultIndex++] = arr[j++]; // keep non spaces
			while (j < arrLen && arr[j] == ' ')
				j++; // skip trailing spaces
			if (j < arrLen)
				arr[resultIndex++] = ' '; // keep only one space for all the words
		}

		return new String(arr).substring(0, resultIndex);
	}

	// reverse a[] from a[i] to a[j]
	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}
	
}
