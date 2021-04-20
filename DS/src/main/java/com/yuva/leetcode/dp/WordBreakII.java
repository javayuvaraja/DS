package com.yuva.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Leetcode 140. Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to 
construct a sentence where each word is a valid dictionary word. Return all 
such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 * @author Yuvaraja Kanagarajan
 *
 */
public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	private List<String> DFS(String s, Set<String> wordDict, 
			HashMap<String, LinkedList<String>>map) {
	    
		if (map.containsKey(s)) {
	        return map.get(s);
	    }
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	
	public static void main(String[] args) {
		String s = "catsanddog"; 
		String words[] = new String[] {"cat","cats","and","sand","dog"};
		List<String> wordsList = Arrays.asList(words);
		Set<String> wordSet = wordsList.stream().collect(Collectors.toSet());
		WordBreakII obj = new WordBreakII();
		System.out.println(obj.wordBreak(s, wordSet));
	}
}
