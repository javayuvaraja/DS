package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
1048. Longest String Chain

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without 
changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:
Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

Example 2:
Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].

 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestStringChain {
	public static int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int result = 0;
        for (String word : words) {
            int currMax = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                currMax = Math.max(currMax, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, currMax);
            result = Math.max(result, currMax);
        }
        return result;
    }
	
	public static void main(String[] args) {
		String words[] = new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		int result = longestStrChain(words);
		System.out.println(result);
	}
}
