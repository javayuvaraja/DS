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
        int[] countArr = new int[26];
        s = s.toLowerCase();
        t = t.toLowerCase();
        char[] s1Arr = s.toCharArray();
        char[] s2Arr = t.toCharArray();
        
        for (char ch : s1Arr) {
            countArr[ch-'a']++;
        }
        
        for (char ch : s2Arr) {
            countArr[ch-'a']--;
        }
        
        for (int temp : countArr) {
            if (temp!=0) {
                return false;
            }
        }
        
        return true;
    }
}
