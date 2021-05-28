package com.yuva.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
1160. Find Words That Can Be Formed by Characters

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindWordsFormedByCharacters {

	 public int countCharacters(String[] words, String chars) {
	        Map<Character, Integer> charMap = new HashMap<>();
	        
	        for(char ch : chars.toCharArray()) {
	            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);
	        }
	        
	        
	        int result = 0;
	        for (String word: words) {
	            Map<Character, Integer> freqMap= getFreqMap(word);
	            boolean isExists = true;
	            for (Character ch : freqMap.keySet()) {
	                if (charMap.containsKey(ch) && 
	                    charMap.get(ch) >= freqMap.get(ch)) {
	                    continue;        
	                } else {
	                    isExists = false;
	                    break;
	                }
	            }
	            
	            if (isExists) {
	                result = result+word.length();
	            }
	        }
	        
	        return result;
	    }
	    
	    private Map<Character, Integer> getFreqMap(String word) {
	        Map<Character, Integer> freqMap = new HashMap<>();
	        for(char ch : word.toCharArray()) {
	            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
	        }
	        return freqMap;
	    }
}
