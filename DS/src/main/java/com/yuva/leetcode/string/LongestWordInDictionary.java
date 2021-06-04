package com.yuva.leetcode.string;

import java.util.Collections;
import java.util.List;
/**
524. Longest Word in Dictionary through Deleting

Given a string s and a string array dictionary, return the longest string in the dictionary
 that can be formed by deleting some of the given string characters. 
 If there is more than one possible result, return the longest word with the smallest 
 lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestWordInDictionary {

	public String findLongestWord(String str, List<String> dictionary) {
	    Collections.sort(dictionary, (a,b) -> a.length() != b.length() ? 
	    		-Integer.compare(a.length(), b.length()) :  a.compareTo(b));
	   
	    for (String dictWord : dictionary) {
	        int i = 0; 
	        for (char c : str.toCharArray()) { 
	            if (i < dictWord.length() && c == dictWord.charAt(i)) {
	            	i++;
	            }
	        }
	        
	        if (i == dictWord.length()) {
	        	return dictWord;
	        }
	    }
	    return "";
	}
	
	public String findLongestWordWithoutSorting(String str, List<String> dictionary) {
	    String longest = "";
	    for (String word : dictionary) {
	        int i = 0;
	        for (char ch : str.toCharArray()) {
	            if (i < word.length() && ch == word.charAt(i)) {
	            	i++;
	            }
	        }

	        if (i == word.length() && word.length() >= longest.length()) { 
	            if (word.length() > longest.length() || word.compareTo(longest) < 0) {
	            	longest = word;
	            }
	        }
	    }
	    return longest;
	}
}
