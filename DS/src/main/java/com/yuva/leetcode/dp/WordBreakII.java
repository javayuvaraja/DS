package com.yuva.leetcode.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
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
