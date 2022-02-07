package com.yuva.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**

Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

Example 2:
Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 
 * @author Yuvaraja Kanagarajan
 *
 */

public class ConcatenatedWords {

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> preWords = new HashSet<>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (canForm(words[i], preWords)) {
				result.add(words[i]);
			}
			preWords.add(words[i]);
		}

		return result;
	}

	private static boolean canForm(String word, Set<String> dict) {
		if (dict.isEmpty())
			return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j])
					continue;
				if (dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}
		private static Node root;
	    
	    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
	        if (words == null || words.length == 0)
	            return new ArrayList<>();
	        
	        root = new Node();
	        buildTrie(words);
	        
	        List<String> result = new LinkedList<>();
	        for (String word : words) {
	            if (isConcatenated(word, 0, 0))
	                result.add(word);
	        }
	        return result;
	    }
	    
	    // Return true if word starting from index is concatenated
	    boolean isConcatenated(String word, int index, int countConcatenatedWords) {
	        if (index == word.length())
	            return countConcatenatedWords >= 2;
	        
	        Node ptr = root;
	        for (int i = index; i < word.length(); i++) {
	            if (ptr.children[word.charAt(i) - 'a'] == null) 
	                return false;
	            ptr = ptr.children[word.charAt(i) - 'a'];
	            
	            if (ptr.isWordEnd)
	                if (isConcatenated(word, i + 1, countConcatenatedWords + 1))
	                    return true;
	        }
	        
	        return false;
	    }
	    
	    private void buildTrie(String[] words) {
	        Node ptr;
	        for (String word : words) {
	            ptr = root;
	            for (char ch : word.toCharArray()) {
	                int order = ch - 'a';
	                if (ptr.children[order] == null) {
	                    ptr.children[order] = new Node();
	                } 
	                ptr = ptr.children[order];
	            }
	            ptr.isWordEnd = true;
	        }
	    }
	    
	    class Node {
	        Node[] children;
	        boolean isWordEnd;
	        
	        public Node() {
	            children = new Node[26];
	            isWordEnd = false;
	        }
	    }
	}

