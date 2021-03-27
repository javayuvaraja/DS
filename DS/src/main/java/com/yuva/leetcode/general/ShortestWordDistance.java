package com.yuva.leetcode.general;

/**
 * [LeetCode] 243 & 245. Shortest Word Distance
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Input: word1 = “coding”, word2 = “practice” Output: 3 Input: word1 = "makes",
 * word2 = "coding" Output: 1s
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int word1Index = -1;
		int word2Index = -1;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			if (word1.equals(s)) {
				word1Index = i;
				if (word2Index != -1)
					min = Math.min(min, word1Index - word2Index);
			} else if (word2.equals(s)) {
				word2Index = i;
				if (word1Index != -1)
					min = Math.min(min, word2Index - word1Index);
			}
		}

		return min;

	}
}
