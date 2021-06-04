package com.yuva.leetcode.general;

/**
 * Leetcode 186 - Reverse Words in a String II
 * 
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters. The input string does not contain leading
 * or trailing spaces and the words are always separated by a single space. 
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the". Could you do
 * it in-place without allocating extra space?
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReverseWordsII {

	public void reverseWords(char[] s) {
		reverseWords(s, 0, s.length - 1);
		for (int end = 0, start = 0; end <= s.length; end++) {
			if (end == s.length || s[end] == ' ') {
				reverseWords(s, start, end - 1);
				start = end + 1;
			}
		}
	}

	private void reverseWords(char[] s, int begin, int end) {
		while (begin < end) {
			char c = s[begin];
			s[begin] = s[end];
			s[end] = c;
			begin++;
			end--;
		}
	}
}
