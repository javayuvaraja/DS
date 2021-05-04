package com.yuva.leetcode.array;

/**
953. Verifying an Alien Dictionary

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false

 * @author Yuvaraja Kanagarajan
 *
 */
public class VerifyAlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		int[] alphabet = new int[26]; // for storing the character occurrence
		for (int i = 0; i < order.length(); i++) {
			alphabet[order.charAt(i) - 'a'] = i;
		}

		for (int i = 1; i < words.length; i++) {
			int minLength = Math.min(words[i - 1].length(), words[i].length());
			for (int k = 0; k < minLength; k++) {
				char word1Char = words[i - 1].charAt(k);
				char word2Char = words[i].charAt(k);

				if (alphabet[word1Char - 'a'] < alphabet[word2Char - 'a']) { // it is in sorted order
					break;
				} else if (alphabet[word1Char - 'a'] > alphabet[word2Char - 'a']) { // it is not in sorted order
					return false;
				} else if (k == minLength - 1 && 
						words[i - 1].length() > words[i].length()) { // smaller length has to  come first condition
					return false;
				}
			}
		}
		return true;
	}
}
