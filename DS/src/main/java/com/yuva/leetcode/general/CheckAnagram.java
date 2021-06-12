package com.yuva.leetcode.general;

/**

 Leetcode 242. Valid Anagram
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 
 Example 1:

	Input: s = "anagram", t = "nagaram"
	Output: true

 Example 2:
	Input: s = "rat", t = "car"
	Output: false
 * @author Yuvaraja Kanagarajan
 *
 */
public class CheckAnagram {
	public boolean isAnagram(String s, String t) {
        if (s==null && t==null) {
            return true;
        }
        if (s==null || t==null) {
            return false;
        }
        if (s.length()!=t.length()) {
            return false;
        }
        
        int []freq= new int[26];
        for (int i =0; i < s.length(); i++) {
            freq[s.charAt(i)-'a'] ++;
            freq[t.charAt(i)-'a'] --;            
        }
        
        for (int temp : freq) {
            if (temp >0) {
                return false;
            }
        }
        
        return true;
    }
}
