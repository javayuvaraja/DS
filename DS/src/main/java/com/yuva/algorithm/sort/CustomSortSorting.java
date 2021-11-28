package com.yuva.algorithm.sort;

import java.util.HashMap;
import java.util.Map;

/**
791. Custom Sort String

You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. 
More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.
 * @author Yuvaraja Kanagarajan
 *
 */
public class CustomSortSorting {
	public String customSortString(String order, String str) {
		int[] freq = new int[26];
		for (Character ch : str.toCharArray()) {
			freq[ch - 'a'] +=1;
		}
		
		Map<Character, Character> foundMap = new HashMap<>();
		StringBuilder res = new StringBuilder();

		for (char c : order.toCharArray()) {
			if (freq[c - 'a'] > 0) {
				foundMap.put(c, c);
				while (freq[c - 'a']-- > 0)
					res.append(c);
			}
		}
		
		for (char c : str.toCharArray()) {
			if (!foundMap.containsKey(c))
				res.append(c);
		}
		return res.toString();
	}
	
	
	public String customSortString1(String order, String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
        	++freq[c - 'a']; // count each char string
        }  
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : order.toCharArray()) {                            
            while (freq[c - 'a']-- > 0) { 
            	sb.append(c);  // Add the same character till count is zero
            }    
        }
        
        for (char c = 'a'; c <= 'z'; ++c) {
            while (freq[c - 'a']-- > 0) { // add the not found character in the order
            	sb.append(c); 
            }    
        }
        return sb.toString();
   }
	
	public static void main(String[] args) {
		String 	order = "cba";
		String str = "abcd";
		
		CustomSortSorting obj = new CustomSortSorting();
		String result = obj.customSortString(order, str);
		System.out.println(result);
	}
}
