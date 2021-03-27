package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Leetcode 244: Shortest Word Distance II 
 * Design a class which receives a list of words in the constructor, 
 * and implements a method that takes two words word1 and word2 and
 * return the shortest distance between these two words in the list. 
 * Your method will be called repeatedly many times with different parameters.
 * 
 * Example:
 * 
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Input: word1 = “coding”, word2 = “practice” Output: 3 Input: word1 = "makes",
 * word2 = "coding" Output: 1 Note:
 * 
 * You may assume that word1 does not equal to word2, and word1 and word2 are
 * both in the list.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ShortestWordDistanceII {

	public Map<String, Integer> wordMap = new HashMap<>();
	public ShortestWordDistanceII(List<String> words) {
		wordMap = IntStream.range(0, words.size())
        .boxed()
        .collect(Collectors.toMap(words::get, Function.identity()));
	}
	
	public int shortestDistance(String word1, String word2) {
		
		int minDistance = Integer.MAX_VALUE;
		int word1Index =  wordMap.getOrDefault(word1, -1);
		int word2Index =  wordMap.getOrDefault(word2, -1);
		
		if (word1Index!=-1 && word2Index!=-1) {
			minDistance = Math.abs(word1Index-word2Index);
		}
		return minDistance;
	}
}
