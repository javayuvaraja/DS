package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**

Leetcode 205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the 
order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true

 * @author Yuvaraja Kanagarajan
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic (String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) { // if mapping character count is mismatch then return false
            	return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
	
	public boolean isIsomorphic1 (String s, String t) {
        Map<Character, Character> replaceMap = new HashMap<>();
        Set<Character> valueSet = new HashSet<>();
        
        if (s == null) {
        	return true;
        }
        
        for (int i = 0; i < s.length(); i++) {
        	char char1 = s.charAt(i);
        	char char2 = t.charAt(i);
        	if (replaceMap.containsKey(char1)) {
        		if (replaceMap.get(char1)!= char2) {
        			return false;
        		}
        	} else {
        		if (valueSet.contains(char2)) { // this value already mapped with some other character
        			return false;
        		}
        		
        		replaceMap.put(char1, char2);
        		valueSet.add(char2);
        	}
        }
        
        return true;
    } 

}
 