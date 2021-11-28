package com.yuva.leetcode.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
792. Number of Matching Subsequences

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) 
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

 * @author Yuvaraja Kanagarajan
 *
 */
public class NumberOfMatchingSequence {

	public int numMatchingSubseq(String str, String[] words) {
		Map<Character, Queue<String>> wordMap = new HashMap<>();
		
		for (char ch='a'; ch <='z'; ch++) {
			wordMap.putIfAbsent(ch, new LinkedList<String>());
		}
		
		for (String word: words) {
			wordMap.get(word.charAt(0)).offer(word);
		}
		
		int count = 0;
		
		for (Character ch : str.toCharArray()) {
			Queue<String> queue = wordMap.get(ch);
			int size = queue.size();
			
			for (int i=0; i < size ; i++) {
				String word = queue.poll();
				if (word.length()==1) {
					count++;
				} else {
					wordMap.get(word.charAt(1)).offer(word.substring(1));
				}				
			}
		}
		
		return count;
	}
}
